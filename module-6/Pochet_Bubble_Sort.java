/*
 * Julio Pochet
 * 06/27/2025
 * Module 6 Programming Assignment
 *
 * This program defines two generic bubble sort methods.
 * One method uses Comparable to sort items in natural order.
 * The second method uses Comparator so items can be sorted in a custom way.
 * Test cases are included to make sure both versions work correctly.
 * 
 */

import java.util.Arrays;
import java.util.Comparator;

public class Pochet_Bubble_Sort {

    // Bubble sort using natural order (Comparable)
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap items
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort using custom order (Comparator)
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Swap items
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Helper method to print any array
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method with test cases
    public static void main(String[] args) {

        // Test 1: Sort strings using Comparable
        String[] names = { "Zoe", "Adam", "Maya", "John" };
        System.out.println("Before sorting (Comparable):");
        printArray(names);

        bubbleSort(names);
        System.out.println("After sorting (Comparable):");
        printArray(names);

        System.out.println();

        // Test 2: Sort integers in descending order using Comparator
        Integer[] numbers = { 9, 1, 4, 7, 3 };
        System.out.println("Before sorting (Comparator - Descending):");
        printArray(numbers);

        bubbleSort(numbers, (a, b) -> b - a);
        System.out.println("After sorting (Comparator - Descending):");
        printArray(numbers);
    }
}