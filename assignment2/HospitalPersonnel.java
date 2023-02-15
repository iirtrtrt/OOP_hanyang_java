package assignment2;

public abstract class HospitalPersonnel {
    int uid;
    String password;
    String name;
    HospitalManagementSystem hospitalsystem;

    public HospitalPersonnel(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
        this.uid = id;
        this.name = name;
        this.password = password;
        this.hospitalsystem = hospitalsystem;
    }

    abstract void managePatient();

    public String getName() {
        return name;
    }
}
