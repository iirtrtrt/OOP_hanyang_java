package assignment2;

import java.time.LocalDate;

public class OutPatient extends Patient {
    LocalDate appointment;

    public OutPatient(int pid, String name, int age, Doctor doctor, LocalDate aptment) {
        super(pid, name, age, doctor);
        appointment = aptment;
    }

    @Override
    public String toString() {
        return super.toString() + ", appointment: " + appointment;
    }

    public void setAppointment(LocalDate appointment) {
        this.appointment = appointment;
    }
}
