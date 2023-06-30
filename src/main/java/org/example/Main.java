package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("commentsOnPost.txt");
        File dir = new File("commentsOnPost");

        Random randomNumber = new Random();
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);

        System.out.print("How many users you want to take part in discussion: ");
        byte userNumbers = scanInt.nextByte();

        ArrayList<String> usernames = new ArrayList<>();

        for (int i = 1; i < userNumbers + 1; i++) {
            System.out.print("The " + i + " username is going to be ");
            String username = scanLine.nextLine();
            usernames.add(username);
        }


        Path path = Paths.get(dir.getPath() + File.separator + file.getName());

        if (!(file.exists() && dir.exists())) {
            dir.mkdir();
            file = path.toFile();
        }

        try {
            PrintWriter pw = new PrintWriter(file);

            int randomInt = usernames.size() * randomNumber.nextInt(1, 2);

            for (int i = 1; i < randomInt + 1; i++) {
                System.out.print(usernames.get(i - 1) + " says: ");
                String comments = scanLine.nextLine();
                pw.println(usernames.get(i - 1) + ": " + comments);
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("Something wrong...");
        }








    }
}