package assignment1;

public class User {
    private String uid;
    private String password;

    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }
}
