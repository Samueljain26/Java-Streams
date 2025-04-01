package com.bridgelabz.javastreams;

import java.io.*;

public class ImageToByte {
    public static void main(String[] args) {
        String inputImage = "src/main/java/com/bridgelabz/javastreams/input.txt";
        String outputImage = "output.jpg";

        try {
            byte[] imageBytes = convertImageToByteArray(inputImage);

            writeByteArrayToImage(imageBytes, outputImage);

            System.out.println("Image conversion successful!");

        } catch (IOException e) {
            System.out.println("Error processing the image: " + e.getMessage());
        }
    }

    // Method to convert an image to a byte array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Method to write byte array back to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
