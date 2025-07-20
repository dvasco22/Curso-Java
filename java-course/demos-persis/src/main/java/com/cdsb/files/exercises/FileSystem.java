package com.cdsb.files.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FileSystem {

    private static String[] messages = {
        "[8][OK_DELETE][O]%s %s deleted",
        "[6][OK_FO_CREATE][O]Directory %s created",
        "[10][OK_FI_CREATE][O]File %s created",
        "[13][OK_WRITE][O]Writing to file %s: %s",
        "[3][FO_EXISTS][W] Directory %s exist",
        "[4][FI_EXISTS][W] File %s exist",
        "[14][FI_NOT][W]File does not exist: %s",
        "[0][FO_NOT][W]Directory %s does not exist",
        "[11][CONTENT_EMPTY][W]Content is empty, nothing to write to file: %s",
        "[1][NOT_IS_FO][W] %s is not a directory",
        "[2][FI_NOT][W] No files found in the directory: %s",
        "[5][FAIL_FO][E]Failed to create directory: %s",
        "[9][FAIL_FI][E]Failed to create file: %s",
        "[7][FAIL_DELETE][E]Failed to delete %s: %s",
        "[12][ERROR_WR][E]Error writing file: %s",
        "[15][ERROR_RE][E]Error reading file: %s"
    };

    public static String listFiles(String pathName) {
        File file = new File(pathName);
        File[] filesList;
        StringBuilder sb = new StringBuilder();

        if (!file.exists()) {
            return messages[0].formatted(pathName);
        }

        if (!file.isDirectory()) {
            return messages[1].formatted(pathName);
        }

        filesList = file.listFiles();

        if (filesList == null || filesList.length == 0) {
            return messages[2].formatted(pathName);
        }

        for (File fileItem : filesList) {
            char type = fileItem.isDirectory() ? 'D' : 'F';
            sb.append("[%s] - %s".formatted(type, fileItem.getName()));
        }
        return sb.toString();
    }

    public static String createFolder(String pathName) {
        File file = new File(pathName);

        if (file.exists() && file.isDirectory()) {
            return messages[3].formatted(pathName);
        }

        if (file.exists() && !file.isDirectory()) {
            return messages[4].formatted(pathName);
        }

        if (!file.mkdir()) {
            return messages[5].formatted(pathName);
        }
        return messages[6].formatted(pathName);

    }

    public static String deleteFolder(String pathName) {
        File file = new File(pathName);
        char type = file.isDirectory() ? 'D' : 'F';

        if (!file.exists()) {
            return messages[0].formatted(pathName);
        }

        if (!file.delete()) {
            return messages[7].formatted(type, pathName);
        }

        return messages[8].formatted(type, pathName);
    }

    public static String createFile(String pathName) {
        File file = new File(pathName);

        if (file.exists() && file.isDirectory()) {
            return messages[3].formatted(pathName);
        }

        if (file.exists() && !file.isDirectory()) {
            return messages[4].formatted(pathName);
        }

        try {
            if (!file.createNewFile()) {
                return messages[9].formatted(pathName);
            }
        } catch (IOException e) {
             return messages[9].formatted(pathName);
        }

        return messages[10].formatted(pathName);
    }

    public static String writeFile(String pathName, String content) {

        if (content == null || content.isEmpty()) {
            return messages[11].formatted(pathName);
        }
        try (FileWriter writer = new FileWriter(pathName)) {
            writer.write(content);
        } catch (IOException e) {
            return messages[12].formatted(pathName);
        }

        return messages[13].formatted(pathName,content);
    }

    public static List<String> readFileToList(String pathName) {
        File file = new File(pathName);
        List<String> lines = new ArrayList<>();

        if (!file.exists()) {
            lines.add(messages[14].formatted(pathName));
            return lines;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            lines.add(messages[15].formatted(pathName));
            return lines;
        }


        return lines;
    }

    public static String readFileToString(String pathName) {
        File file = new File(pathName);

        StringBuilder sb = new StringBuilder();

        if (!file.exists()) {
            return messages[14].formatted(pathName);
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line);
                sb.append("\n");
            }

        } catch (FileNotFoundException e) {
            return messages[15].formatted(pathName);
        }
        return sb.toString();
    }

}