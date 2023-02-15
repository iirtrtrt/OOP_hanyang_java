package lab11;

public class Gyeonggi extends Hub {
    public static int init_num = 1000;
    public static String init_area = "Gyeonggi";
    public static int init_per_box = 3000;

    public Gyeonggi(String description) {
        super(++init_num, init_area, init_per_box);
        // super.setNumber(++init_num);
        super.setDescription(description);
        // super.setArea(init_area);
        // super.setPrice_per_box(init_per_box);
    }
}
