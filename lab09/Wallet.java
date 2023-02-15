package lab09;

public class Wallet {
    String name;
    int balance;
    int txIndex;

    public Wallet(String name) {
        this.name = name;
        this.balance = 100;
        this.txIndex = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void increseIndex() {
        txIndex++;
    }

    public void decreaseBalance(int expense) {
        balance = balance - expense;
    }

    public String toString() {
        return "name: " + name + ", #" + txIndex + ", balance: " + balance;
    }

    public void empty() throws Exception {
        if (balance <= 0) {
            throw new Exception("Go Home");
        }
    }
}
