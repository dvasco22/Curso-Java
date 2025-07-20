package com.cdsb.files.exercises;

import java.util.List;
import java.util.Scanner;

import com.cdsb.files.FileSystem1;

public class SaveUser {

    private String name;
    private String surname1;
    private String surname2;
    private String pathName;

    public SaveUser(String pathName) {
        this.pathName = pathName;
        getUserData();
        System.out.println(this);
    }

    private void getUserData() {

        String[] answers = new String[3];
        String[] questions = {
                "Dime tu nombre",
                "Dime tu primer apellido",
                "Dime tu segundo apellido"
        };
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            answers[i] = scanner.nextLine();
        }

        name = answers[0];
        surname1 = answers[1];
        surname2 = answers[2];

    }

    public void saveUserData() {
        FileSystem1.createFile(pathName);
        FileSystem1.writeFile(pathName, makeFullName());
    }

    private String makeFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.trim());
        sb.append(" ").append(surname1.trim());
        sb.append(" ").append(surname2.trim());
        return sb.toString();
    }

    public void readUserData() {
        List<String> read = FileSystem1.readFile(pathName);
        showUserData(read);
    }

    private void showUserData( List<String> list) {
        // TODO
    }


    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("SaveUse\n");
        sb.append("name: ");
        sb.append(name);
        sb.append("\n");
        sb.append("surname1: ");
        sb.append(surname1);
        sb.append("\n");
        sb.append("surname2: ");
        sb.append(surname2);
        sb.append("\n");
        sb.append("pathName: ");
        sb.append(pathName);
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        new SaveUser("demos-persis/resources/sample.txt");

    }

}