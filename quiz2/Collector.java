package quiz2;

import java.util.ArrayList;

public class Collector<T extends UniqueToken> implements UniqueTokenCollector<T> {
    private ArrayList<T> arr;
    private String name;
    private int uid;

    Collector(String name, int uid) {
        this.name = name;
        this.uid = uid;
        this.arr = new ArrayList<T>();
    }

    @Override
    public void add(T item) {
        arr.add(item);
    }

    @Override
    public void remove(T item) {
        arr.remove(item);
    }

    @Override
    public T get(int id) {
        for (T i : arr) {
            if (i.getTokenId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void transfer(int id, Collector<T> peer) {
        T temp = get(id);

        if (temp != null) {
            System.out.println("This token is " + temp.getName());
            arr.remove(temp);
            peer.add(temp);
            System.out.println("----- Successfully Transfered! -----");
        }
    }

    @Override
    public void printAllTokens() {
        System.out.println(this.name + "(" + this.uid + "):");

        if (arr.size() == 0) {
            System.out.println("no pokemon");
            return;
        }

        for (T e : arr) {
            System.out.println(
                    "name: " + e.getName() + ", id: " + e.getTokenId() + ", " + "description: " + e.getDescription());
        }
    }
}
