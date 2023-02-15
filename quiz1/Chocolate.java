package quiz1;

public class Chocolate {
    private String name;
    private double price;
    private int box;
    private double sales;

    public Chocolate(String name, double price, int box) {
        this.name = name;
        this.price = price;
        this.box = box;
        this.sales = price * box;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    // public static double calculateTotalSales(Chocolate[] chocolateTotalList) {
    // double totalSales = totalSales + chocolateTotalList.sales;
    // return totalSales;
    // }

    public String toString() {
        return "Name='" + name + "', price=" + price + ", box=" + box + ", sales=" + sales;
    }
}
