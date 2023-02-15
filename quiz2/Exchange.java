package quiz2;

import java.util.Scanner;

public class Exchange {
    public static <T extends UniqueToken> void main(String[] args) {
        Collector<T> c1 = new Collector<>("Red", 100);
        Collector<T> c2 = new Collector<>("Green", 200);
        PocketMonster p1 = new PocketMonster("Pikachu", "1 Million Volt Electric Shock");
        PocketMonster p2 = new PocketMonster("GGobugi", "Surfing");

        c1.add((T) p1);
        c2.add((T) p2);
        c1.printAllTokens();
        c2.printAllTokens();

        System.out.println("----- Enter tokenId -----");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        c1.transfer(num, c2);

        c1.printAllTokens();
        c2.printAllTokens();

        scan.close();
    }
}
