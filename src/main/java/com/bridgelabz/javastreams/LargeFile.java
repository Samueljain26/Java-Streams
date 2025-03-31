package com.bridgelabz.javastreams;

import java.io.*;

public class LargeFile {
        public static void main(String[] args) {
            String fileName = "src/main/java/com/bridgelabz/javastreams/input.txt";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.toLowerCase().contains("error")) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }