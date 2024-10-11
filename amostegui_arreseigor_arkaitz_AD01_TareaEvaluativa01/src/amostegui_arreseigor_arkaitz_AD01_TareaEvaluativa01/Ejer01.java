package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejer01 {
    public static void main(String[] args) {
        String inputFile = "ejer01-entrada.txt";  // Nombre del archivo de entrada
        String outputFile = "ejer01-salida.txt";  // Nombre del archivo de salida
        
        try (FileReader fr = new FileReader(inputFile);
             FileWriter fw = new FileWriter(outputFile)) {
            
            StringBuilder sb = new StringBuilder();
            int c;
            
            // Leer el archivo carácter por carácter y formar una cadena
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
            
            // Separar la línea leída en palabras
            String[] palabras = sb.toString().split(" ");
            StringBuilder resultado = new StringBuilder();
            
            // Invertir cada palabra y añadirla al resultado
            for (String palabra : palabras) {
                String palabraInvertida = new StringBuilder(palabra).reverse().toString();
                resultado.append(palabraInvertida).append(" ");
            }
            
            // Escribir el resultado en el archivo de salida
            fw.write(resultado.toString().trim());
            System.out.println("Palabras invertidas guardadas en " + outputFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
