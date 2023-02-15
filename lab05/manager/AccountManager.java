package lab05.manager;

import java.time.LocalDate;
import java.util.Random;

import lab05.account.Account;

public class AccountManager {
    public static void main(String[] args) {
        LocalDate created = LocalDate.of(2021, 12, 01);
        Account myAccount = new Account("Kim", 5, created);
        System.out.println(myAccount.toString());
        boolean flag = true;

        while (myAccount.getBalance() <= 10000) {
            myAccount.receiveIncome(100);
            myAccount.receiveInterest();
            created = created.plusMonths(1);

            if (created.getMonthValue() == 1) {
                Random random = new Random();
                if (random.nextInt(10) == 0) {
                    System.out.println("이벤트 당첨! " + created);
                    myAccount.receiveIncome(100);
                }
            }

            if (flag && created.isAfter(myAccount.getCreated().plusYears(3))) {
                myAccount.increaseYearlyInterest(2);
                System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");
                flag = false;
            }
        }
        System.out.println(myAccount.toString() + ", 1억 모으기 끝 :" + created);
    }
}