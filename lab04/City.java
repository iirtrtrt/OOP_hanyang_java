package lab04;

import java.util.Random;

public class City {
    private String name;
    private int locationX;
    private int locationY;

    public City(String name, int locationX, int locationY) {
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public City(String name) {
        this.name = name;
        Random random = new Random();
        this.locationX = random.nextInt(361);
        this.locationY = random.nextInt(361);
    }

    public String getName() {
        return name;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public boolean equals(City city) {
        if (this.name.equals(city.name) && this.locationX == city.locationX && this.locationY == city.locationY) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.name + ", " + this.locationX + ", " + this.locationY;
    }

    public static double distance(City c1, City c2) {
        double result = Math.sqrt(
                (int) Math.pow((c1.locationX - c2.locationX), 2) + (int) Math.pow((c1.locationY - c2.locationY), 2));
        return result;
    }
}
