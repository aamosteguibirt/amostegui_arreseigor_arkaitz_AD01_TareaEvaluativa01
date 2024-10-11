package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejer04b {

    private static final String FILE_NAME = "Marvel.dat"; // Nombre del archivo con los datos
    private static final int DNI_SIZE = 9;
    private static final int NOMBRE_SIZE = 10;
    private static final int IDENTIDAD_SIZE = 20;
    private static final int TIPO_SIZE = 10;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java Ejer4b <DNI> <peso>");
            return;
        }

        String dniInput = args[0].trim();
        int nuevoPeso;

        // Validar que el peso es un número entero
        try {
            nuevoPeso = Integer.parseInt(args[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("El peso debe ser un número entero.");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
            boolean personajeEncontrado = false;

            // Leer el archivo en busca del personaje con el DNI dado
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String dni = readString(raf, DNI_SIZE);
                String nombre = readString(raf, NOMBRE_SIZE);
                String identidad = readString(raf, IDENTIDAD_SIZE);
                String tipo = readString(raf, TIPO_SIZE);
                int peso = raf.readInt();
                int altura = raf.readInt();

                // Comprobar si el DNI coincide
                if (dni.equals(dniInput)) {
                    personajeEncontrado = true;

                    // Calcular el cambio en el peso
                    int diferencia = nuevoPeso - peso;

                    // Actualizar el peso en el archivo
                    raf.seek(raf.getFilePointer() - Integer.BYTES); // Volver al peso
                    raf.writeInt(nuevoPeso); // Escribir el nuevo peso

                    // Mostrar el resultado al usuario
                    String resultado = (diferencia > 0) ? "ha engordado " + diferencia + " kilos."
                            : (diferencia < 0) ? "ha adelgazado " + Math.abs(diferencia) + " kilos."
                            : "se mantiene en su peso.";

                    System.out.println("El personaje " + nombre.trim() + " " + resultado);
                    break;
                }
            }

            if (!personajeEncontrado) {
                System.out.println("Error: No se encontró el personaje con DNI " + dniInput);
            }

        } catch (IOException e) {
            System.out.println("Error al acceder al archivo: " + e.getMessage());
        }
    }

    // Método para leer una cadena de longitud fija
    private static String readString(RandomAccessFile raf, int size) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(raf.readChar()); // Leer un carácter
        }
        return sb.toString().trim(); // Convertir a string y eliminar espacios
    }
}
