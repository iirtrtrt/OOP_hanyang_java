package lab05.account;

import java.time.LocalDate;

public class Account {
    private String name;
    private double yearlyInterest;
    private double balance;
    private LocalDate created;

    public Account(String name, double yearlyInterest, LocalDate created) {
        this.name = name;
        this.yearlyInterest = yearlyInterest;
        this.balance = 0;
        this.created = created;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void increaseYearlyInterest(int byPrecent) {
        yearlyInterest = yearlyInterest + byPrecent;
    }

    public void receiveIncome(double income) {
        balance = balance + income;
    }

    public void receiveInterest() {
        balance = balance + (((balance * yearlyInterest) / 12) / 100);
    }

    public String toString() {
        return "이름: " + name + ", 연이자: " + yearlyInterest + ", 잔고: " + balance + ", 가입일: " + created;
    }
}
