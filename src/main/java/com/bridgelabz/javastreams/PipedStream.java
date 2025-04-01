package com.bridgelabz.javastreams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream output;

    public WriterThread(PipedOutputStream output) {
        this.output = output;
    }

    public void run() {
        try {
            String message = "message from WriterThread!";
            output.write(message.getBytes());
            output.close();
        } catch (IOException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream input;

    public ReaderThread(PipedInputStream input) {
        this.input = input;
    }

    public void run() {
        try {
            int data;
            while ((data = input.read()) != -1) {
                System.out.print((char) data);
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}

public class PipedStream {
    public static void main(String[] args) throws IOException {
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(output);

        WriterThread writer = new WriterThread(output);
        ReaderThread reader = new ReaderThread(input);

        writer.start();
        reader.start();
    }
}
