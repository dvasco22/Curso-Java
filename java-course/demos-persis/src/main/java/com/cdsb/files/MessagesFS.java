package com.cdsb.files;

public enum MessagesFS {

    OK_DELETE("O", "%s %s deleted"),
    OK_FO_CREATE("O", "Directory %s created"),
    OK_FI_CREATE("O", "File %s created"),
    OK_WRITE("O", "Writing to file %s: %s"),
    FO_EXISTS("W", "Directory %s exist"),
    FI_EXISTS("W", "File %s exist"),
    FI_NOT("W", "File does not exist: %s"),
    FO_NOT("W", "Directory %s does not exist"),
    CONTENT_EMPTY("W", "Content is empty, nothing to write to file: %s"),
    NOT_IS_FO("W", "%s is not a directory"),
    FIS_NOT("W", "No files found in the directory: %s"),

    FAIL_FO("E", "Failed to create directory: %s"),
    FAIL_FI("E", "Failed to create file: %s"),
    FAIL_DELETE("E", "Failed to delete %s: %s"),
    ERROR_WR("E", "Error writing file: %s"),
    ERROR_RE("E", "Error reading file: %s"),
    ERROR_LIST("E", "Error listing from: %s");

    String code;
    String message;

    MessagesFS(String code, String message) {
        this.code = code;
        this.message = message;
    }

}