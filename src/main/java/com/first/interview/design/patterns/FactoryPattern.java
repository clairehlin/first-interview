package com.first.interview.design.patterns;
/*
Allows you to hide the concrete class of the implementation
 */
public class FactoryPattern {
    public static void main(String[] args) {
        // note that this piece of codes does not mention any particular implementation of car and that is the point
        // of factory pattern
        Object o = new String("abc");
        CarFactory carFactory = new CarFactory();
        Car toyota = carFactory.createCar("toyota");
        System.out.println(toyota);
        Car ford = carFactory.createCar("ford");
        System.out.println(ford);
        Car mercedes = carFactory.createCar("mercedes");
        System.out.println(mercedes);

        Car fastCar = carFactory.createCar(170);
        System.out.println(fastCar);
        Car fasterCar = carFactory.createCar(200);
        System.out.println(fasterCar);
        Car slowCar = carFactory.createCar(100);
        System.out.println(slowCar);
        Car slowerCar = carFactory.createCar(80);
        System.out.println(slowerCar);
        Car stillCar = carFactory.createCar(0);
        System.out.println(stillCar);
    }
}

class CarFactory {
    public Car createCar(String brand) {
        if (brand.equalsIgnoreCase("Toyota")) {
            return new Toyota();
        } else if (brand.equalsIgnoreCase("ford")) {
            return new Ford();
        } else {
            return new UnknownBrandCar(brand);
        }
    }

    public Car createCar(int maxSpeed) {
        if (maxSpeed > 160) {
            return new Toyota();
        } else if (maxSpeed > 70) {
            return new Ford();
        } else {
            throw new IllegalArgumentException("there is no car with max speed of " + maxSpeed);
        }
    }
}

interface Car {
    String getBrandName();
    void drive();
}

class Ford implements Car {

    @Override
    public String getBrandName() {
        return "Ford";
    }

    @Override
    public void drive() {
        System.out.println("driving Ford");
    }
}

class Toyota implements Car {

    @Override
    public String getBrandName() {
        return "Toyota";
    }

    @Override
    public void drive() {
        System.out.println("driving Toyota");
    }
}

class UnknownBrandCar implements Car {
    private final String brand;

    UnknownBrandCar(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    @Override
    public void drive() {
        throw new IllegalArgumentException("cannot be sure it is safe to drive " + brand);
    }
}
