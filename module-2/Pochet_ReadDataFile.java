// Julio Pochet
// 06/08/2025
// Assignment: Module 2 – Read File Contents
// Purpose: This program reads and displays all integers and doubles from a binary file.

import java.io.*;

public class Pochet_ReadDataFile {
    public static void main(String[] args) {
        String filename = "Pochet_datafile.dat"; // Input file

        try (
                // Open file for reading
                DataInputStream input = new DataInputStream(
                        new BufferedInputStream(new FileInputStream(filename)))) {
            int entry = 1;

            // Keep reading until the end of the file
            while (true) {
                System.out.print("Entry " + entry + " - Ints: ");

                // Read and display 5 integers
                for (int i = 0; i < 5; i++) {
                    System.out.print(input.readInt() + " ");
                }

                System.out.print("| Doubles: ");

                // Read and display 5 doubles
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%.2f ", input.readDouble());
                }

                System.out.println();
                entry++;
            }

        } catch (EOFException e) {
            System.out.println("Done reading file. End reached.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}