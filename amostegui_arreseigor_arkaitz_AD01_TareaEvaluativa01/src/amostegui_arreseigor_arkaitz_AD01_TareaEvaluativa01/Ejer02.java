package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejer02 {
    public static void main(String[] args) {
        String inputFile = "ejer02-entrada.txt";       // Archivo de entrada
        String outputFile = "Ejer02_salida.txt"; // Archivo de salida

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Separar la línea en palabras
                String[] palabras = linea.split(" ");

                // Filtrar los nombres con exactamente cinco letras
                for (String palabra : palabras) {
                    if (palabra.length() == 5) {
                        bw.write(palabra);  // Escribir el nombre en el archivo de salida
                        bw.newLine();        // Agregar una nueva línea
                    }
                }
            }

            System.out.println("Nombres de cinco letras guardados en " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
