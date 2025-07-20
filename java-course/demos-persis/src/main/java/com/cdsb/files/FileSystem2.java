package com.cdsb.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSystem2 {

    // Leer lista ficheros y carpetas
    public static String listFiles(String pathName) {

        StringBuilder sb = new StringBuilder();
        Path path = Path.of(pathName);

        if (Files.notExists(path)) {
            return MessagesFS.FO_NOT.message.formatted(pathName);
        }

        if (!Files.isDirectory(path)) {
            return MessagesFS.NOT_IS_FO.message.formatted(pathName);
        }

        try {
            Files.list(path).forEach((p) -> {
                char type = Files.isDirectory(p) ? 'D' : 'F';
                sb.append("[").append(type).append("] ");
                sb.append(p.getFileName()).append("\n");
            });
            return sb.toString();
        } catch (IOException e) {
            return MessagesFS.ERROR_LIST + "\n" + e.getMessage();
        }
    }

    public static String listFiles(String pathName, boolean onlyFiles) {
        StringBuilder sb = new StringBuilder();
        if (!onlyFiles) {
            return listFiles(pathName);
        }

        Path path = Paths.get(pathName);

        if (Files.notExists(path)) {
            return MessagesFS.FO_NOT.message.formatted(pathName);
        }

        if (!Files.isDirectory(path)) {
            return MessagesFS.NOT_IS_FO.message.formatted(pathName);
        }

        try {
            Files.list(path).filter(file -> !Files.isDirectory(file)).forEach((p) -> {
                char type = Files.isDirectory(p) ? 'D' : 'F';
                sb.append("[").append(type).append("] ");
                sb.append(p.getFileName()).append("\n");
            });
            return sb.toString();
        } catch (IOException e) {
            return MessagesFS.ERROR_LIST + "\n" + e.getMessage();
        }
    }

    // Crear carpetas
    public static String createFolder(String pathName) {
        Path path = Path.of(pathName);

        if (Files.exists(path) && Files.isDirectory(path)) {
            return MessagesFS.FO_EXISTS.message.formatted(pathName);
        }

        if (Files.exists(path) && !Files.isDirectory(path)) {
            return MessagesFS.FI_EXISTS.message.formatted(pathName);
        }

        try {
            Files.createDirectories(path);
            return MessagesFS.OK_FO_CREATE.message.formatted(pathName);
        } catch (IOException e) {
            return MessagesFS.FAIL_FO.message.formatted(pathName) + "\n" + e.getMessage();
        }
    }

    // Borra carpetas / ficheros

    private static String deleteFile(String pathName) {
        Path path = Paths.get(pathName);
        if (Files.notExists(path)) {
            return MessagesFS.FI_NOT.message.formatted(pathName);
        }
        try {
            Files.delete(path);
        } catch (IOException e) {
            return MessagesFS.FAIL_DELETE.message.formatted(pathName) + "\n" + e.getMessage();
        }
        return MessagesFS.OK_DELETE.message.formatted(pathName);

    }

    public static String deleteFileOrFolder(String pathName) {
        Path path = Paths.get(pathName);
        if (Files.notExists(path)) {
            return ("File or directory does not exist: " + pathName);
        }

        if (!Files.isDirectory(path)) {
            deleteFile(pathName);
        }

        try {
            boolean hasError = Files.walk(path).sorted((a, b) -> b.compareTo(a))
                    // Sort in reverse order to delete files before directories
                    .anyMatch(p -> {
                        try {
                            Files.delete(p);
                            return false;
                        } catch (IOException e) {
                            return true;
                        }
                    });

            if (hasError) {
                return MessagesFS.FAIL_DELETE.message.formatted("directory", pathName);
            }
            return MessagesFS.OK_DELETE.message.formatted(pathName);
        } catch (IOException e) {
            return MessagesFS.FAIL_DELETE.message.formatted(pathName) + "\n" + e.getMessage();
        }
    }

    // Crear ficheros
    public static String createFile(String pathName) {
        Path path = Paths.get(pathName);

        if (Files.exists(path) && Files.isDirectory(path)) {
            return MessagesFS.FO_EXISTS.message.formatted(pathName);
        }

        if (Files.exists(path)) {
            return MessagesFS.FI_EXISTS.message.formatted(pathName);
        }

        try {
            Files.createFile(path);
            return MessagesFS.OK_FI_CREATE.message.formatted(pathName);
        } catch (IOException e) {
            return MessagesFS.FAIL_FI.message.formatted(pathName) + "\n" + e.getMessage();
        }
    }

    // Escribir en ficheros
    public static String writeFile(String pathName, String content) {
        Path path = Paths.get(pathName);

        if (content == null || content.isEmpty()) {
            return MessagesFS.CONTENT_EMPTY.message.formatted(pathName);
        }

        if (Files.notExists(path)) {
            String result = createFile(pathName);
            if (!result.contains("created")) {
                return result;
            }
        }

        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return MessagesFS.ERROR_WR.message.formatted(pathName) + "\n" + e.getMessage();
        }

        return MessagesFS.OK_WRITE.message.formatted(pathName, content);

    }

    // Leer de un fichero

    public static List<String> readFileToList(String pathName) {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(pathName);
        if (!Files.exists(path)) {
            lines.add(MessagesFS.FI_NOT.message.formatted(pathName));
            return lines;
        }
        try {
            lines.addAll(Files.readAllLines(path));
            return lines;
        } catch (IOException e) {
            lines.add(MessagesFS.ERROR_RE.message.formatted(pathName));
            lines.add(e.getMessage());
            return lines;
        }

    }

    public static String readFileToString(String pathName) {

        Path path = Paths.get(pathName);
        if (!Files.exists(path)) {
            return MessagesFS.FI_NOT.message.formatted(pathName);
        }
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return MessagesFS.ERROR_RE.message.formatted(pathName) + "\n" + e.getMessage();
        }
    }

    public static void main(String[] args) {

        String pathName;
        pathName = "no_folder";
        pathName = "demos-persis/pom.xml";
        pathName = "demos-persis";
        System.out.println(listFiles(pathName));
        pathName = "demos-persis/resources";
        pathName = "demos-persis/pom.xml";
        pathName = "demos-persis/resources/sample";
        System.out.println(createFolder(pathName));
        pathName = "demos-persis/resources/sample/sample.txt";
        System.out.println(writeFile(pathName, "Hola Pepe"));
        pathName = "demos-persis/resources/sample.txt";
        System.out.println(readFileToList(pathName));
    }

}