package assignment1;

public class Patient {
    private String pid;
    private String name;
    private int age;
    private String status;

    public Patient(String pid, String name, int age, String status) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "pid: '" + pid + "', name: '" + name + "', age: " + age + ", status: '" + status + "'";
    }
}