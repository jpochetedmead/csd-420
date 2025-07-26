/*
 * Julio Pochet
 * 07/25/2025
 * Assignment: Module 11 - Gson Java JSON API Example
 * Purpose: Demonstrates how to serialize and deserialize objects using Gson.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Student {
    String name;
    int age;
    String course;

    // Constructor
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class GsonExample {
    public static void main(String[] args) {
        // Create a Gson instance with pretty-printing enabled
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Create a Student object
        Student student = new Student("Alice", 22, "Software Development");

        // Serialize the Student object to JSON
        String json = gson.toJson(student);
        System.out.println("Serialized JSON:\n" + json);

        // Deserialize the JSON back to a Student object
        Student deserializedStudent = gson.fromJson(json, Student.class);
        System.out.println("\nDeserialized Object:");
        System.out.println("Name: " + deserializedStudent.name);
        System.out.println("Age: " + deserializedStudent.age);
        System.out.println("Course: " + deserializedStudent.course);
    }
}