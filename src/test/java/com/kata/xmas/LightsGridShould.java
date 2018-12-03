package com.kata.xmas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LightsGridShould {


    @Test
    public void start_with_all_the_lights_turned_off() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // thenit

        for (int i = 0; i < grid.getLights().length; i++) {
            for (int j = 0; j < grid.getLights()[0].length; j++) {
                assertEquals(0, grid.getLights()[i][j]);
            }
        }
    }

    @Test
    void turn_on_lights_at_coordinates_pair() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.turnOn(0, 0, 999, 999);

        // then

        for (int i = 0; i < grid.getLights().length; i++) {
            for (int j = 0; j < grid.getLights()[0].length; j++) {
                assertEquals(1, grid.getLights()[i][j]);
            }
        }
    }

    @Test
    void toggle_lights_at_coordinates_pair() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.toggle(0, 0, 999, 0);

        // then

        for (int i = 0; i < grid.getLights().length; i++) {
            assertEquals(2, grid.getLights()[i][0]);

        }
    }

    @Test
    void turn_off_lights_at_coordinates_pair() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.turnOn(499, 499, 500, 500);

        // then

        for (int i = 499; i <= 500; i++) {
            for (int j = 499; j <= 500; j++) {
                assertEquals(1, grid.getLights()[i][j]);
            }
        }

        // and
        grid.turOff(499, 499, 500, 500);

        // then

        for (int i = 499; i <= 500; i++) {
            for (int j = 499; j <= 500; j++) {
                assertEquals(0, grid.getLights()[i][j]);
            }
        }
    }

    @Test
    void return_the_number_of_lights_that_are_on() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.turnOn(0, 0, 999, 999);
        grid.toggle(0, 0, 999, 0);
        grid.turOff(499, 499, 500, 500);

        // then

        assertEquals(999996, grid.numberOfLightsOn());
    }

    @Test
    void return_current_grid_total_brightness() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.turnOn(0, 0, 999, 999);
        grid.toggle(0, 0, 999, 0);
        grid.turOff(499, 499, 500, 500);

        // then

        assertEquals(1001996, grid.brightness());
    }


    @Test
    void not_allow_negative_brightness() {

        // given

        LightsGrid grid = LightsGrid.of(1000,1000);

        // when

        grid.turOff(0,0,999,999);

        // then

        assertEquals(0, grid.brightness());
    }
}
