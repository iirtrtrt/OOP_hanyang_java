package lab08;

import java.time.LocalDate;

public class BEV extends Car {
    private static int carNum;
    private static int CO2emission;
    private int GHGPERCAR = 25;

    public BEV() {
    }

    public BEV(String name, LocalDate date, int carNum) {
        super();
        this.name = name;
        this.date = date;
        BEV.carNum = BEV.carNum + carNum;
        BEV.CO2emission = BEV.CO2emission + (carNum * GHGPERCAR);
    }

    public boolean equals(BEV bev) {
        if (name.equals(bev.name) && date.equals(bev.date)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "name: " + name + ", date: " + date + ", carNum: " + carNum;
    }

    public int totalCO2() {
        System.out.println("BEV emit CO2 most when generating electric energy");
        return CO2emission;
    }
}
