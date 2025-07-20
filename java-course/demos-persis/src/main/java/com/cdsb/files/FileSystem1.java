package com.cdsb.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystem1 {

    // Leer lista ficheros y carpetas

   public static void listFiles(String pathName) {
       // El objeto File representa un archivo o directorio en el sistema de archivos.
       // Independientemente de si este existe o no.
        File file = new File(pathName);

        // // Debemos comprobar si el directorio existe y es un directorio.
        if (!file.exists()) {
            System.out.println("Directory %s does not exist".formatted(pathName) );
            return;
        }

        if (!file.isDirectory()) {
            System.out.println("%s is not a directory: ".formatted(pathName));
            return;
        }

        // Podemos obtener la lista de los ficheros y directorios o de sus nombres
        File[] filesList =  file.listFiles();
        // String[] filesNames = file.list();


        if (filesList == null || filesList.length == 0) {
            System.out.println("No files found in the directory: " + pathName);
            return;
        }


        // Imprimimos los nombres de los ficheros
        for (File fileItem : filesList) {
            char type = fileItem.isDirectory() ? 'D' : 'F';
            System.out.println("[%s] - %s".formatted(type, fileItem.getName()));
        }
    }

    // Crear carpetas

    public static void createFolder(String pathName) {
       // El objeto File representa un archivo o directorio en el sistema de archivos.
       // Independientemente de si este existe o no.
        File file = new File(pathName);


        // Debemos comprobar si el directorio/fichero.
        if (file.exists() && file.isDirectory())  {
            System.out.println("Directory %s exist".formatted(pathName) );
            return;
        }

        if (file.exists() && !file.isDirectory())  {
            System.out.println("File %s exist".formatted(pathName) );
            return;
        }

        // Para crear un directorio, debemos llamar al método mkdir() o mkdirs()
        // mkdir() crea un único directorio, mientras que mkdirs() crea todos los
        // directorios necesarios en la ruta especificada.
        // Devuelven true o false dependiendo de si la operación fue exitosa o no.
        if (!file.mkdir()) {
            System.out.println("Failed to create directory: " + pathName);
            return;
        }
        System.out.println("Directory " + pathName + " created.");

    }


    // Borra carpetas / ficheros

    public static void deleteFolder(String pathName) {
          // El objeto File representa un archivo o directorio en el sistema de archivos.
       // Independientemente de si este existe o no.
        File file = new File(pathName);

         // // Debemos comprobar si el directorio existe y es un directorio.
        if (!file.exists()) {
            System.out.println("Directory %s does not exist".formatted(pathName) );
            return;
        }

        char type = file.isDirectory() ? 'D' : 'F';

        if (!file.delete()) {
            System.out.println("Failed to delete " + type + ": " + pathName);
            return;
        }
        System.out.println(type + " " + pathName + " deleted.");

     }

    // Crear ficheros

    public static void createFile(String pathName) {
       // El objeto File representa un archivo o directorio en el sistema de archivos.
       // Independientemente de si este existe o no.
        File file = new File(pathName);


        // Debemos comprobar si el directorio/fichero.
        if (file.exists() && file.isDirectory())  {
            System.out.println("Directory %s exist".formatted(pathName) );
            return;
        }

        if (file.exists() && !file.isDirectory())  {
            System.out.println("File %s exist".formatted(pathName) );
            return;
        }


        try {
            if (!file.createNewFile()) {
                System.out.println("Failed to create file: " + pathName);
                return;
            }

        } catch (IOException e) {
            System.err.println("Error creating file: " + pathName);
            return;
        }

        // If the file is created successfully, we can write to it.
        // For now, we just print a message.
        // In a real application, we would write to the file here.
        System.out.println("File " + pathName + " created.");

    }

    // Escribir en ficheros

    public static void writeFile(String pathName, String content) {

        if (content == null || content.isEmpty()) {
            System.out.println("Content is empty, nothing to write to file: " + pathName);
            return;
        }
        // Here we would write the content to the file.
        // For example, using FileWriter or BufferedWriter.
        try (FileWriter writer = new FileWriter(pathName)) {
            writer.write(content);
            //writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + pathName);
        }

        // For now, we just print a message.
        // This is a placeholder for the actual file writing logic.

        System.out.println("Writing to file " + pathName + ": " + content);
    }


    // Leer de un fichero

    public static List<String> readFile(String pathName) {
        // El objeto File representa un archivo o directorio en el sistema de archivos.
        // Independientemente de si este existe o no.
        File file = new File(pathName);
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // Comentar para probar la gestión de excepciones
        if (!file.exists()) {
            System.out.println("File does not exist: " + pathName);
            return lines;
        }

        try (Scanner scanner = new Scanner(file)) {
            // Scanner is used to read the file line by line
            // It throws FileNotFoundException if the file does not exist
            // or if there is an error reading the file.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                lines.add(line);
                sb.append(line);
                sb.append("\n");
            }
            System.out.println("Read file: " + pathName);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + pathName);
            return lines;
        }
        System.out.println(lines);
        System.out.println(sb.toString());

        return lines;
    }


    public static void main(String[] args) {
        String pathName = "demos-persis";
        // pathName = "demos-persis/resources";
        // pathName = "demos-persis/pom.xml";
        listFiles(pathName);
        pathName = "demos-persis/samples";
        createFolder(pathName);
        deleteFolder(pathName);
        pathName = "demos_fault";
        deleteFolder(pathName);
        pathName = "demos-persis/resources/sample.txt";
        createFile(pathName);
        writeFile(pathName, "Hola Mundo\nAdios amigos");
        System.out.println("=".repeat(50));
        // pathName = "demos-persis/resources/sample.md";
        readFile(pathName);
    }

}
