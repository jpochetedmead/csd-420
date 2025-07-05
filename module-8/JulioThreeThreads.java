// Julio Pochet
// 07/04/2025
// Module 8 Programming Assignment - ThreeThreads
// Purpose: Create a class named JulioThreeThreads that runs 3 threads to generate
//          random letters, digits, and symbols. Each thread appends 10,000 characters
//          to a shared text area (simulated by StringBuilder).

import java.util.Random;

public class JulioThreeThreads {

    public static void main(String[] args) {

        // This StringBuilder simulates the text area for display
        StringBuilder textArea = new StringBuilder();

        // Create the 3 threads
        Thread letterThread = new Thread(new LetterGenerator(textArea));
        Thread digitThread = new Thread(new DigitGenerator(textArea));
        Thread symbolThread = new Thread(new SymbolGenerator(textArea));

        // Start all threads
        letterThread.start();
        digitThread.start();
        symbolThread.start();

        // Wait for all threads to finish
        try {
            letterThread.join();
            digitThread.join();
            symbolThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        // Print a sample of output to confirm the threads worked
        System.out.println("\n--- Sample Output (first 300 characters) ---\n");
        System.out.println(textArea.substring(0, Math.min(textArea.length(), 300)));

        // Display total character count to confirm 10,000 from each thread
        System.out.println("\nTotal characters generated: " + textArea.length());
    }
}

// Thread for generating lowercase letters
class LetterGenerator implements Runnable {
    private final StringBuilder output;
    private final Random random = new Random();

    public LetterGenerator(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            synchronized (output) {
                output.append(letter);
            }
        }
    }
}

// Thread for generating digits 0-9
class DigitGenerator implements Runnable {
    private final StringBuilder output;
    private final Random random = new Random();

    public DigitGenerator(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            char digit = (char) ('0' + random.nextInt(10));
            synchronized (output) {
                output.append(digit);
            }
        }
    }
}

// Thread for generating special symbols
class SymbolGenerator implements Runnable {
    private final StringBuilder output;
    private final Random random = new Random();
    private final char[] symbols = { '!', '@', '#', '$', '%', '&', '*' };

    public SymbolGenerator(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];
            synchronized (output) {
                output.append(symbol);
            }
        }
    }
}