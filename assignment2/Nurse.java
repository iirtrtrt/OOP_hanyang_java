package assignment2;

import java.time.LocalDate;

public class Nurse extends HospitalPersonnel {
    public Nurse(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
        super(id, name, password, hospitalsystem);
    }

    @Override
    void managePatient() {
        System.out.println("====== Welcome to Hospital Management System (Nurse)======");
        System.out.println("1 - Register patient");
        System.out.println("2 - Update patient information");
        System.out.println("3 - Output patient information");
        System.out.println("0 - Exit");
    }

    public void updatePatient(int pid, LocalDate start, LocalDate end) {
        for (int i = 0; i < HospitalManagementSystem.patientList.length; i++) {
            if (HospitalManagementSystem.patientList[i] != null
                    && HospitalManagementSystem.patientList[i].getPid() == pid) {
                if (end == null) {
                    ((OutPatient) HospitalManagementSystem.patientList[i]).setAppointment(start);
                } else {
                    ((InPatient) HospitalManagementSystem.patientList[i]).setInOutDate(start, end);
                }
            }
        }
    }

    public void registerPatient(Patient patient, Doctor doctor) {
        patient.setDoctor(doctor);
        HospitalManagementSystem.patientList[HospitalManagementSystem.patIndex] = patient;
        HospitalManagementSystem.patIndex++;
    }
}
