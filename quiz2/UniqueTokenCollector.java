package quiz2;

public interface UniqueTokenCollector<T extends UniqueToken> {
    void add(T item);

    void remove(T item);

    T get(int id);

    void transfer(int id, Collector<T> peer);

    void printAllTokens();
}
