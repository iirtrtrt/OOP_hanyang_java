package lab03;

public class StaffManager {
    public static void main(String[] args) {
        Staff staff1 = new Staff("James Wright", 29, "Accounting", 365, 15);
        Staff staff2 = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
        Staff staff3 = new Staff("Amy Smith", 27);

        System.out.println(staff1.toString());
        System.out.println(staff2.toString());
        System.out.println(staff3.toString());
        System.out.println("---");

        System.out.println("Same Career?");
        System.out.printf("%s and %s, ", staff2.getName(), staff3.getName());
        if (staff2.sameCarrer(staff3)) {
            System.out.println("same.");
        } else {
            System.out.println("Not exactly same.");
        }
        System.out.println("...A Few years later...");
        staff3.setCarrer(staff2);
        System.out.printf("%s and %s, ", staff2.getName(), staff3.getName());
        if (staff2.sameCarrer(staff3)) {
            System.out.println("same.");
        } else {
            System.out.println("Not exactly same.");
        }
        System.out.println("---");

        staff1.vacation(10);
        staff3.vacation(20);
        staff3.vacation(1);
    }
}
