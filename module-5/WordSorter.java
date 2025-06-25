// Julio Pochet
// 06/21/2025
// Module 5 – Programming Assignment
// Purpose: Reads words from a file, removes duplicates, and displays them in ascending and descending order

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSorter {

    public static void main(String[] args) {
        // Run the main program using the required input file
        displaySortedWords("collection_of_words.txt");

        // Run a basic test to confirm functionality
        runTest();
    }

    /**
     * Reads words from a file and displays non-duplicate words in ascending and
     * descending order.
     */
    public static void displaySortedWords(String filename) {
        Set<String> words = new TreeSet<>(); // TreeSet keeps words sorted and unique

        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNext()) {
                // Convert to lowercase and remove any non-letter characters
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }

            scanner.close();

            // Print words in ascending order
            System.out.println("\nWords in Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            // Print words in descending order
            System.out.println("\nWords in Descending Order:");
            List<String> wordList = new ArrayList<>(words);
            Collections.reverse(wordList);
            for (String word : wordList) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found.");
        }
    }

    /**
     * Simple test method to verify that the program can read words,
     * remove duplicates, and display them in both orders.
     */
    public static void runTest() {
        System.out.println("\n--- Running Basic Test ---");

        String testFile = "test_words.txt";

        try {
            // Create a small sample file with mixed words and duplicates
            java.io.PrintWriter writer = new java.io.PrintWriter(testFile);
            writer.println("apple banana banana kiwi orange cat dog dog apple");
            writer.println("Miami tokyo Tokyo lion tiger grape apple mango");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error creating test file: " + e.getMessage());
            return;
        }

        // Display sorted words from the test file
        displaySortedWords(testFile);

        // Delete test file after running
        new File(testFile).delete();
    }
}