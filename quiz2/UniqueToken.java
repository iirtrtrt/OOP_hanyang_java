package quiz2;

public class UniqueToken {
    protected String name;
    protected String description;
    protected int tokenId;

    protected UniqueToken(String n, String d, int t) {
        name = n;
        description = d;
        tokenId = t;
    }

    public int getTokenId() {
        return this.tokenId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}