package lab08;

import java.time.LocalDate;

public class ICE extends Car {
    private static int carNum;
    private static int CO2emission;
    private int GHGPERCAR = 35;

    public ICE() {
    }

    public ICE(String name, LocalDate date, int carNum) {
        super();
        this.name = name;
        this.date = date;
        ICE.carNum = ICE.carNum + carNum;
        ICE.CO2emission = ICE.CO2emission + (carNum * GHGPERCAR);
    }

    public boolean equals(ICE ice) {
        if (name.equals(ice.name) && date.equals(ice.date)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "name: " + name + ", date: " + date + ", carNum: " + carNum;
    }

    public int totalCO2() {
        System.out.println("ICE emit CO2 most when driving");
        return CO2emission;
    }
}
