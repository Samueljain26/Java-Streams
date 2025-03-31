package com.bridgelabz.javastreams;

import java.io.*;

public class CompareBufferedStreams {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/bridgelabz/javastreams/input.txt";
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyFileBuffered(sourceFile, destBuffered);

        // Copy using Unbuffered Streams
        long unbufferedTime = copyFileUnbuffered(sourceFile, destUnbuffered);

        // Print time comparison
        System.out.println("Buffered Streams Time: " + bufferedTime + " ns");
        System.out.println("Unbuffered Streams Time: " + unbufferedTime + " ns");
    }

    // Method for Buffered File Copy
    public static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    // Method for Unbuffered File Copy
    public static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
/*Buffered Streams Time: 2547100 ns
Unbuffered Streams Time: 8288600 ns
 */