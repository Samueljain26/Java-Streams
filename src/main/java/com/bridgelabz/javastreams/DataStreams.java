package com.bridgelabz.javastreams;

import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Roll No: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA: " + dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*Roll No: 101
Name: Alice
GPA: 3.8
 */