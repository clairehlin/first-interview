package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private final Map<Integer, Integer> space = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        space.put(1, big);
        space.put(2, medium);
        space.put(3, small);
    }

    public boolean addCar(int carType) {
        int availableSpace = space.get(carType);

        if (availableSpace > 0) {
            int newAvailableSpace = availableSpace - 1;
            space.put(carType, newAvailableSpace);
            return true;
        } else {
            return false;
        }
    }
}
