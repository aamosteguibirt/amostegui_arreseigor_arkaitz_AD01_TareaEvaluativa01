package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejer04c {
    private static final String FILE_NAME = "Marvel.dat"; // Nombre del archivo con los datos
    private static final int DNI_SIZE = 9;
    private static final int NOMBRE_SIZE = 10;
    private static final int IDENTIDAD_SIZE = 20;
    private static final int TIPO_SIZE = 10;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Ejer04c <tipo>");
            return;
        }

        String tipoInput = args[0].trim().toLowerCase(); // Convertir a minúsculas para comparar
        if (!tipoInput.equals("heroe") && !tipoInput.equals("villano")) {
            System.out.println("Tipo no válido. Debe ser 'heroe' o 'villano'.");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r")) {
            boolean tipoEncontrado = false;
            int contador = 0;

            // Leer el archivo y contar personajes del tipo especificado
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String dni = readString(raf, DNI_SIZE);
                String nombre = readString(raf, NOMBRE_SIZE);
                String identidad = readString(raf, IDENTIDAD_SIZE);
                String tipo = readString(raf, TIPO_SIZE);
                int peso = raf.readInt();
                int altura = raf.readInt();

                // Comparar el tipo de personaje
                if (tipo.equals(tipo.trim().toLowerCase())) {
                    // Si coincide, mostrar datos
                    System.out.printf("ID: %d, DNI: %s, Nombre: %s, Identidad: %s, Tipo: %s, Peso: %d, Altura: %d%n",
                            id, dni, nombre.trim(), identidad.trim(), tipo.trim(), peso, altura);
                    contador++;
                    tipoEncontrado = true;
                }
            }

            // Mostrar el resultado
            if (tipoEncontrado) {
                System.out.printf("Total de personajes de tipo '%s': %d%n", tipoInput, contador);
            } else {
                System.out.printf("No se encontraron personajes del tipo '%s'.%n", tipoInput);
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
