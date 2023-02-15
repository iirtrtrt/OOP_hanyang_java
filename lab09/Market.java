package lab09;

import java.util.Scanner;

public class Market {
    public static void main(String[] args) {
        Wallet w = new Wallet("my wallet");
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                w.empty();
                System.out.print("Enter price: ");
                int num = scan.nextInt();

                if (num < 0) {
                    throw new NegativeException();
                } else if (num > 100) {
                    throw new TooMuchExpenseException(num);
                } else if (num > w.getBalance()) {
                    throw new TooMuchExpenseException();
                } else {
                    w.increseIndex();
                    w.decreaseBalance(num);
                    System.out.println("peace~~");
                }
            } catch (NegativeException e) {
                e.printStackTrace();
                System.out.println("oh, sorry!");
            } catch (TooMuchExpenseException e) {
                e.printStackTrace();
                if (e.getMessage().equals("Over the limit!")) {
                    System.out.println("you pay " + e.getInputNum());
                }
                System.out.println("oh, my!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("the end...");
                scan.close();
                return;
            } finally {
                System.out.println(w.toString());
                System.out.println("---transaction complete---\n");
            }
        }
    }
}
