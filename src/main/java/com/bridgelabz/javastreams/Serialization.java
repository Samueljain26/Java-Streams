package com.bridgelabz.javastreams;

import java.io.*;

class Employee implements Serializable {
        private static final long serialVersionUID = 1L;
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "ID: " + id + ", Name: " + name;
        }
    }

public class Serialization {
        public static void main(String[] args) {
            Employee emp = new Employee(1, "Alice");

            // Serialize
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
                oos.writeObject(emp);
                System.out.println("Employee serialized!");
            } catch (IOException e) {
                System.out.println("Serialization Error: " + e.getMessage());
            }

            // Deserialize
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
                Employee deserializedEmp = (Employee) ois.readObject();
                System.out.println("Deserialized Employee: " + deserializedEmp);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Deserialization Error: " + e.getMessage());
            }
        }
    }
    /*Employee serialized!
Deserialized Employee: ID: 1, Name: Alice
     */