package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ejer03 {
    public static void main(String[] args) {
        // Comprobar que se ha pasado un argumento (nombre del archivo)
        if (args.length != 1) {
            System.out.println("Uso: java Ejer03 <nombre_del_archivo.pdf>");
            return;
        }

        String filePath = args[0];

        // Llamar al método para verificar si es un archivo PDF
        if (isValidPDF(filePath)) {
            System.out.println("El archivo es un PDF válido.");
        } else {
            System.out.println("El archivo no es un PDF válido.");
        }
    }

    // Método para verificar si el archivo es un PDF
    private static boolean isValidPDF(String filePath) {
        byte[] pdfHeader = new byte[4]; // Buffer para los primeros 4 bytes

        try (FileInputStream fis = new FileInputStream(filePath)) {
            // Leer los primeros 4 bytes del archivo
            int bytesRead = fis.read(pdfHeader);

            // Comprobar si se leyeron 4 bytes
            if (bytesRead != 4) {
                return false; // No se pudo leer el archivo correctamente
            }

            // Comprobar si los bytes coinciden con la cabecera PDF
            return pdfHeader[0] == 37 && // '%'
                   pdfHeader[1] == 80 && // 'P'
                   pdfHeader[2] == 68 && // 'D'
                   pdfHeader[3] == 70;   // 'F'

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false; // Retorna false en caso de excepción
        }
    }
}
