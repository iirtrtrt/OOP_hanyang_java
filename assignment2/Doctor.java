package assignment2;

public class Doctor extends HospitalPersonnel {
    Doctor(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
        super(id, name, password, hospitalsystem);
    }

    @Override
    void managePatient() {
        System.out.println("====== Welcome to Hospital Management System (Doctor)======");
        System.out.println("1 - Update patient information");
        System.out.println("2 - Output patient information");
        System.out.println("0 - Exit");
    }

    public void updatePatient(int pid, String prescription) {
        for (int i = 0; i < HospitalManagementSystem.patientList.length; i++) {
            if (HospitalManagementSystem.patientList[i] != null
                    && HospitalManagementSystem.patientList[i].getPid() == pid) {
                HospitalManagementSystem.patientList[i].setPrescription(prescription);
            }
        }
    }
}
