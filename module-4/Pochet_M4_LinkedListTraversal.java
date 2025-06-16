// Julio Pochet
// 06/15/2025
// Assignment: Module 4 – Programming Assignment
// Purpose: Compare how fast a LinkedList can be looped through using an iterator vs. get(index)

import java.util.LinkedList;
import java.util.Iterator;

public class Pochet_M4_LinkedListTraversal {
    public static void main(String[] args) {

        // Run the test with 50,000 elements
        System.out.println("🔍 Testing with 50,000 elements:");
        runTest(50000);

        System.out.println("\n------------------------------\n");

        // Run the test with 500,000 elements
        System.out.println("🔍 Testing with 500,000 elements:");
        runTest(500000);
    }

    // Method to run the speed test
    public static void runTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the list with numbers from 0 to size - 1
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Measure time using an iterator
        long startIterator = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // just reading values
        }
        long endIterator = System.currentTimeMillis();
        System.out.println("⏱ Time using iterator: " + (endIterator - startIterator) + " ms");

        // Measure time using get(index)
        long startGet = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // this is slower with LinkedList
        }
        long endGet = System.currentTimeMillis();
        System.out.println("⏱ Time using get(index): " + (endGet - startGet) + " ms");

        // ✅ Testing the list to make sure it's filled correctly
        boolean firstOK = list.getFirst() == 0;
        boolean lastOK = list.getLast() == size - 1;
        boolean middleOK = list.get(size / 2) == size / 2;

        if (firstOK && lastOK && middleOK) {
            System.out.println("✅ Data check passed: The list is correct.");
        } else {
            System.out.println("❌ Data check failed: Something is wrong.");
        }
    }
}

/*
 * RESULT SUMMARY:
 * 
 * This program fills a LinkedList with 50,000 and then 500,000 numbers.
 * 
 * Then it times two ways to go through the list:
 * 1. Using an iterator → fast
 * 2. Using get(index) in a loop → slow
 * 
 * Why is get(index) slow?
 * Because LinkedList has to start from the beginning every time you call
 * get(i).
 * So if you loop with get(index), it restarts over and over again — very slow
 * with big lists.
 * 
 * Why is the iterator faster?
 * It moves one step at a time and remembers where it is — no restarting.
 * 
 * With 50,000 items, get(index) was already slower.
 * With 500,000 items, it was much worse.
 * 
 * I also added a simple test to make sure the list worked right.
 * It checks the first, middle, and last values.
 * 
 * Conclusion:
 * Use an iterator (or foreach loop) when looping through a LinkedList.
 * It's much better for performance.
 */