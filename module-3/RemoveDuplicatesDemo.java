// Julio Pochet
// 06/13/2025
// Module 3 Programming Assignment – Removing Duplicates with a Generic Method

// This program creates a list of 50 random numbers between 1 and 20.
// It uses a generic method to remove any duplicate values from the list.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicatesDemo {

    // This method takes a list with any type (E) and removes duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // A HashSet only keeps unique values, so we use it to filter out duplicates
        return new ArrayList<>(new HashSet<>(list));
    }

    public static void main(String[] args) {
        // Create an empty list to hold random numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Add 50 random numbers between 1 and 20 to the list
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1);
        }

        // Print the list with duplicates
        System.out.println("Original list (with duplicates):");
        System.out.println(numbers);

        // Call our method to remove duplicates
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);

        // Print the list after removing duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueNumbers);
    }
}