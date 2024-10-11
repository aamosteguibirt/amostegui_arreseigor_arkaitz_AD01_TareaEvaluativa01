package amostegui_arreseigor_arkaitz_AD01_TareaEvaluativa01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejer04a {

    public static void main(String[] args) {
        // Datos de los personajes
        int[] ids = {1, 2, 3, 4, 5, 6, 7};
        String[] dnis = {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
        String[] noms = {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
        String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
        String[] tipos = {"heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano"};
        int[] pesos = {76, 84, 66, 136, 78, 102, 70};
        int[] alturas = {178, 183, 156, 152, 177, 182, 188};

        // Nombre del archivo
        String fileName = "Marvel.dat";

        // Guardar datos en el archivo
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            for (int i = 0; i < ids.length; i++) {
                // Escribir los datos de cada personaje en el archivo
                raf.writeInt(ids[i]);                         // Escribir el ID
                raf.writeChars(String.format("%-9s", dnis[i]));      // Escribir el DNI
                raf.writeChars(String.format("%-10s", noms[i]));      // Escribir el Nombre
                raf.writeChars(String.format("%-20s", identidades[i])); // Escribir la Identidad Secreta
                raf.writeChars(String.format("%-10s", tipos[i]));      // Escribir el Tipo
                raf.writeInt(pesos[i]);                       // Escribir el Peso
                raf.writeInt(alturas[i]);                     // Escribir la Altura
            }

            System.out.println("Carga de datos realizada satisfactoriamente en " + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}

