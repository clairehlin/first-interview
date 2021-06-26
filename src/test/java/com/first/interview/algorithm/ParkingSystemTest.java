package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingSystemTest {
    @Test
    void can_find_available_space() {
        // given
        ParkingSystem parking = new ParkingSystem(1, 1, 0);

        // when
        boolean queryBigCar = parking.addCar(1);

        // then
        assertThat(queryBigCar).isTrue();
    }

    @Test
    void cannot_find_available_space_with_space_zero() {
        // given
        ParkingSystem parking = new ParkingSystem(1, 1, 0);

        // when
        boolean queryBigCar = parking.addCar(3);

        // then
        assertThat(queryBigCar).isFalse();
    }
    @Test
    void cannot_find_available_space_once_running_out_of_space() {
        // given
        ParkingSystem parking = new ParkingSystem(1, 2, 0);

        // when
        boolean queryBigCar1 = parking.addCar(2);
        boolean queryBigCar2 = parking.addCar(2);
        boolean queryBigCar3 = parking.addCar(2);



        // then
        assertThat(queryBigCar3).isFalse();
    }

}