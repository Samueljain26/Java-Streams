package com.bridgelabz.javastreams;

import java.io.*;

public class FileHandling {
        public static void main(String[] args) {
            File inputFile = new File("src/main/java/com/bridgelabz/javastreams/input.txt");
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream("output.txt")) {

                int byteData;
                while ((byteData = fis.read()) != -1) {
                    fos.write(byteData);
                }
                System.out.println("File copied successfully.");

            } catch (IOException e) {
                System.out.println("Exception handled");
            }
        }
    }
