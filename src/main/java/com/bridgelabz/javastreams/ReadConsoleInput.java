package com.bridgelabz.javastreams;

import java.io.*;

public class ReadConsoleInput {
        public static void main(String[] args) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 FileWriter writer = new FileWriter("demo1.txt")) {

                // Taking user input
                System.out.print("Enter your name: ");
                String name = reader.readLine();

                System.out.print("Enter your age: ");
                String age = reader.readLine();

                // Writing to file
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");

                System.out.println("User information saved successfully!");

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
