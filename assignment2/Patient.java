package assignment2;

public class Patient {
    private int pid;
    private String name;
    private int age;
    private Doctor doctor;
    private String prescription;

    public Patient(int pid, String name, int age) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.doctor = null;
        this.prescription = null;
    }

    public Patient(int pid, String name, int age, Doctor doctor) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
        this.prescription = null;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String toString() {
        return "pid: " + pid + ", name: '" + name + "', age: " + age;
    }

    public void outputPatientInfo() {
        System.out.print(toString());
        if (doctor != null) {
            System.out.print(", doctor: '" + doctor.getName() + "'");

            if (prescription != null) {
                System.out.print(", prescription: '" + prescription + "'");
            }
        }
        System.out.println();
    }

    public int getPid() {
        return pid;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}