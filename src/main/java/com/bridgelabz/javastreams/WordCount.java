package com.bridgelabz.javastreams;

import java.util.*;
import java.io.*;

public class WordCount {
        public static void main(String[] args) {
            String fileName = "src/main/java/com/bridgelabz/javastreams/input.txt";
            Map<String, Integer> wordCount = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    for (String word : line.toLowerCase().split("\\W+")) {
                        if (!word.isEmpty()) {
                            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            wordCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
    /*world: 10
hello: 10
v: 2
     */