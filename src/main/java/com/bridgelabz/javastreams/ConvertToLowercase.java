package com.bridgelabz.javastreams;

import java.io.*;

public class ConvertToLowercase {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/bridgelabz/javastreams/input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Write a newline
            }

            System.out.println("Conversion completed successfully!");

        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
