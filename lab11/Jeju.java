package lab11;

public class Jeju extends Hub {
    public static int init_num = 9000;
    public static String init_area = "Jeju";
    public static int init_per_box = 6000;

    public Jeju(String description) {
        super(++init_num, init_area, init_per_box);
        // super.setNumber(++init_num);
        super.setDescription(description);
        // super.setArea(init_area);
        // super.setPrice_per_box(init_per_box);
    }
}
