package com.first.interview.threads;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * to run code in a separate thread you do one of the following:
 * - extend thread class and override the run() method with your code then call start() method
 * - implements runnable interface and override the run() method and then instantiate a thread object passing
 * an instance of your runnable to the constructor of your thread, and then call start() on the thread object
 */
class FirstThreadsTest {

    @Test
    public void runnable_race_complete_successfully() {
        HorseRunnable horseA = new HorseRunnable("a", 100);
        HorseRunnable horseB = new HorseRunnable("b", 100);
        HorseRunnable horseC = new HorseRunnable("c", 100);

        RunnableRace runnableRace = new RunnableRace();
        runnableRace.register(horseA, horseB, horseC);

        runnableRace.start();
    }

    @Test
    public void thread_race_complete_successfully() {
        HorseThread horseA = new HorseThread("a", 100);
        HorseThread horseB = new HorseThread("b", 100);
        HorseThread horseC = new HorseThread("c", 100);

        ThreadRace threadRace = new ThreadRace();
        threadRace.register(horseA, horseB, horseC);

        threadRace.start();
    }



    static class HorseRunnable implements Runnable {

        private final String name;
        private final int distance;

        HorseRunnable(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public void run() {
            int currentDistance = 0;
            while (currentDistance < distance) {
                currentDistance++;
//                System.out.print(name);
            }
            System.out.println(name + " arrived");
        }
    }

    static class HorseThread extends Thread {

        private final String name;
        private final int distance;

        HorseThread(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public void run() {
            int currentDistance = 0;
            while (currentDistance < distance) {
                currentDistance++;
//                System.out.print(name);
            }
            System.out.println(name + " arrived");
        }
    }

    static class RunnableRace {

        private final Set<HorseRunnable> registeredHorses = new HashSet<>();

        void start() {
            registeredHorses.forEach(
                    h -> new Thread(h).start()
            );
        }

        void register(HorseRunnable... horses) {
            registeredHorses.addAll(Arrays.asList(horses));
        }
    }

    static class ThreadRace {

        private final Set<HorseThread> registeredHorses = new HashSet<>();

        void start() {
            // the method reference is equivalent to calling horse.start()
            registeredHorses.forEach(Thread::start);
        }

        void register(HorseThread... horses) {
            registeredHorses.addAll(Arrays.asList(horses));
        }
    }
}
