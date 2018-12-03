package com.kata.xmas;

public final class LightsGrid {

    private int[][] lights;

    private LightsGrid(int row, int columns) {

        this.lights = new int[row][columns];
    }

    public static LightsGrid of(int row, int columns){

        return new LightsGrid(row, columns);
    }

    public int[][] getLights() {
        return lights;
    }

    public void turnOn(int i, int j, int k, int l) {

        for (int m = i; m <= k; m++) {
            for (int n = j; n <= l; n++) {

                this.lights[m][n]++;
            }
        }
    }

    public void turOff(int i, int j, int k, int l) {
        for (int m = i; m <= k; m++) {
            for (int n = j; n <= l; n++) {

                if (lights[m][n] > 0) {
                    this.lights[m][n]--;
                }
            }
        }
    }

    public void toggle(int i, int j, int k, int l) {

        for (int m = i; m <= k; m++) {
            for (int n = j; n <= l; n++) {

                this.lights[m][n] += 2;
            }
        }
    }

    public int numberOfLightsOn() {

        int lightsOn = 0;

        for (int m = 0; m < lights.length; m++) {
            for (int n = 0; n < lights[0].length; n++) {

                if (lights[m][n] > 0) {
                    lightsOn++;
                }
            }
        }
        return lightsOn;
    }

    public int brightness() {
        int brightness = 0;

        for (int m = 0; m < lights.length; m++) {
            for (int n = 0; n < lights[0].length; n++) {

                brightness += lights[m][n];
            }
        }
        return brightness;
    }
}
