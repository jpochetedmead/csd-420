// Julio Pochet
// 06/08/2025
// Assignment: Module 2 – Write Random Numbers to File
// Purpose: This program creates or appends to a data file with 5 random integers and 5 random doubles.

import java.io.*;
import java.util.Random;

public class Pochet_WriteDataFile {
    public static void main(String[] args) {
        String filename = "Pochet_datafile.dat"; // Output file name
        Random random = new Random(); // Random number generator

        try (
                // Set up file output stream in append mode
                DataOutputStream output = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream(filename, true)))) {
            // Write 5 random integers (0–99)
            for (int i = 0; i < 5; i++) {
                int randomInt = random.nextInt(100);
                output.writeInt(randomInt);
            }

            // Write 5 random doubles (0.0–100.0)
            for (int i = 0; i < 5; i++) {
                double randomDouble = random.nextDouble() * 100;
                output.writeDouble(randomDouble);
            }

            System.out.println("Random data saved to: " + filename);

        } catch (IOException e) {
            System.out.println("Something went wrong while writing: " + e.getMessage());
        }
    }
}