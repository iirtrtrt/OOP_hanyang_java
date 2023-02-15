package lab11;

public class Hub {
    private int number;
    private String description;
    private String area;
    private double price_per_box;

    public Hub(int number, String area, double price_per_box) {
        this.number = number;
        this.area = area;
        this.price_per_box = price_per_box;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getArea() {
        return area;
    }

    public double getPrice_per_box() {
        return price_per_box;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPrice_per_box(double price_per_box) {
        this.price_per_box = price_per_box;
    }

    @Override
    public String toString() {
        return "Box Number: " + number + "\nDescription: " + description + "\nArea: " + area + "Price per box: "
                + price_per_box;
    }
}
