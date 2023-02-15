package assignment2;

import java.time.LocalDate;

public class InPatient extends Patient {
    LocalDate inDate;
    LocalDate outDate;

    public InPatient(int pid, String name, int age, Doctor doctor, LocalDate in, LocalDate out) {
        super(pid, name, age, doctor);
        inDate = in;
        outDate = out;
    }

    public void setInOutDate(LocalDate in, LocalDate out) {
        inDate = in;
        outDate = out;
    }

    @Override
    public String toString() {
        return super.toString() + ", inDate: " + inDate + ", outDate: " + outDate;
    }
}
