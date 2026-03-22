package org;

class OddEvenPrinter {

    private int number = 1;
    private final int MAX;

    public OddEvenPrinter(int max) {
        this.MAX = max;
    }

    // Print odd numbers
    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notify();
            }
        }
    }

    // Print even numbers
    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notify();
            }
        }
    }
}

public class OddEvenThreadExample {

    public static void main(String[] args) {

        OddEvenPrinter printer = new OddEvenPrinter(10);

        Thread oddThread = new Thread(() -> printer.printOdd(), "OddThread");
        Thread evenThread = new Thread(() -> printer.printEven(), "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}