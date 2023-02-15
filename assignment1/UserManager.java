package assignment1;

import java.util.Scanner;

public class UserManager {
    static User[] userList = new User[20];
    static Scanner scan = new Scanner(System.in);

    public void addUser() {
        userList[0] = new User("1", "123456");
    }

    public boolean login() {
        while (true) {
            System.out.println("Please Login");
            System.out.println("ID:");
            String sUid = scan.next();
            System.out.println("Password:");
            String sPass = scan.next();

            for (int i = 0; i < userList.length; i++) {
                if (userList[i] != null && userList[i].getUid().equals(sUid)
                        && userList[i].getPassword().equals(sPass)) {
                    System.out.println("Login success, input 1 to continue.");
                    int sCon = scan.nextInt();
                    if (sCon == 1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            System.out.println("Login failed, input 1 to continue.");
            int sCon = scan.nextInt();
            if (sCon != 1) {
                return false;
            }
        }
    }
}
