package lab02;

import java.util.Scanner;

public class lab02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] splited = input.split(",");
        String[] names = splited[0].split(" ");
        System.out.printf("Name Length(Korean) : %d\n", names.length);

        for (int i = 0; i < names.length - 1; i++) {
            splited[0] = splited[0].replace(names[i], names[i].toUpperCase().charAt(0) + ".");
        }
        splited[0] = splited[0].replaceAll(" ", "");
        splited[0] = splited[0].replace(names[names.length - 1],
                names[names.length - 1].substring(0, 1).toUpperCase() + names[2].substring(1));

        splited[1] = splited[1].trim().replace("ppt", "pdf");
        splited[1] = splited[1].substring(0, 1).toUpperCase() + splited[1].substring(1);

        System.out.printf("%s submitted %s\n", splited[0], splited[1]);

        scan.close();
    }
}
