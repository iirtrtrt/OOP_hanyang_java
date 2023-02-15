package quiz2;

public class PocketMonster extends UniqueToken {
    static private int serialNum = 0;

    public PocketMonster(String name, String desc) {
        super(name, desc, ++serialNum);
    }
}