package com.first.interview.threads;

public class Incrementer {
    private int counter;

    // immutable variable
    // if all instance variables are final or there is none, then the object is immutable and thread safe.
    private final int immutableCounter;

    public Incrementer() {
        immutableCounter = (int) Math.random() * 100;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementUnsynchronized() {
        if (counter > -1) {
            counter++;
            counter++;
        }
    }

    public synchronized void incrementSynchronized() {
        if (counter > -1) {
            counter++;
            counter++;
        }
    }

    public void incrementSynchronized2() {
        if (counter > -1) {
            // only the block of code is synchronized. not the whole method is synchronized.
            synchronized (this) {
                counter++;
                counter++;
            }
        }

//        System.out.println("I am not synchronized and not dangerous");
        System.out.print(".");
    }

    // stateless implementation
    public int age(int x) {
        return x + 5;
    }

    public int getImmutableCounter() {
        return immutableCounter;
    }
}
