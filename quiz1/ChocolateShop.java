package quiz1;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateShop {
    public static void main(String[] args) {
        Chocolate[] Chocolate = new Chocolate[3];
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            String temp1 = scanner.next();
            double temp2 = scanner.nextDouble();
            int temp3 = scanner.nextInt();
            Chocolate[i] = new Chocolate(temp1, temp2, temp3);
            System.out.println(Chocolate[i].toString());
            scanner.close();
        }
        double[] arr = new double[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Chocolate[i].getPrice();
        }
        Arrays.sort(arr);
        System.out.println(arr);
    }
}
