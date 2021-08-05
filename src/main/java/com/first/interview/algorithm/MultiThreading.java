package com.first.interview.algorithm;

import org.apache.commons.lang3.RandomUtils;

public class MultiThreading {
    public static void main(String[] args) {
        CarDriver carDriver1 = new CarDriver("Mike");
        CarDriver carDriver2 = new CarDriver("Katy");
        Thread thread1 = new Thread(carDriver1);
        Thread thread2 = new Thread(carDriver1);
        Thread thread3 = new Thread(carDriver1);
        Thread thread4 = new Thread(carDriver1);
        Thread thread5 = new Thread(carDriver1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println("main finished");
    }

    private static class CarDriver implements Runnable {
        private final String name;
        private int fuel = 200;


        private CarDriver(String name) {
            this.name = name;
        }

        public void run() {
            while (fuel > 0) {
                updateFuel();
                int localFuel = updateFuel();
                String tName = Thread.currentThread().getName();

                try {
                    Thread.sleep(RandomUtils.nextLong(0, 1000));
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name + " driving..." + localFuel + " " + tName);
            }
        }

        private synchronized int updateFuel() {
            return fuel = fuel - 4;
        }
    }
}
