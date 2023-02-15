package assignment1;

import java.util.Scanner;

public class PatientManager {
    static Patient[] patientList = new Patient[20];
    static int ind = 0;
    static Scanner scan = new Scanner(System.in);

    public static void managePatients() {
        while (true) {
            System.out.println("==========Welcome to patient management system==========");
            System.out.println("1 - Add patient");
            System.out.println("2 - Delete patient");
            System.out.println("3 - Update patient");
            System.out.println("4 - Find patient");
            System.out.println("5 - Exit");
            System.out.println("Please enter your choice");

            int num = scan.nextInt();
            if (num == 1) {
                addPatient();
            } else if (num == 2) {
                deletePatient();
            } else if (num == 3) {
                updatePatient();
            } else if (num == 4) {
                outputAllPatients();
            } else if (num == 5) {
                break;
            } else {
                System.out.println("Please enter your choice between 1 and 5");
            }
        }
    }

    public static void addPatient() {
        System.out.println("Please enter Patient ID:");
        String sPid = scan.next();
        if (doesExist(sPid)) {
            return;
        }
        System.out.println("Please enter Patient name:");
        String sName = scan.next();
        System.out.println("Please enter Patient age:");
        int sAge = scan.nextInt();
        System.out.println("Please enter Patient status:");
        String sStatus = scan.next();
        patientList[ind] = new Patient(sPid, sName, sAge, sStatus);
        ind++;

        System.out.println("Add patient completed, input 1 to continue.");
        int sCon = scan.nextInt();
        if (sCon == 1) {
            addPatient();
        }
    }

    public static boolean doesExist(String pid) {
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null && patientList[i].getPid().equals(pid)) {
                System.out.println("This ID already exists, please try again");
                return true;
            }
        }
        return false;
    }

    public static void outputAllPatients() {
        boolean once = true;
        boolean exists = false;
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null) {
                if (once) {
                    System.out.println("Patient ID         Name         Age         Status");
                    once = false;
                    exists = true;
                }
                System.out.println("Patient{" + patientList[i].toString() + "}");
            }
        }
        if (!exists) {
            System.out.println("No such information, please add new informaion");
        }
    }

    public static void deletePatient() {
        System.out.println("Please enter Patient ID of the patient you want to delete:");
        String sPid = scan.next();
        boolean deleted = delete(sPid);
        if (deleted) {
            System.out.println("Delete patient information completed, input 1 to continue.");
            int sCon = scan.nextInt();
            if (sCon == 1) {
                deletePatient();
            }
        } else {
            System.out.println("This ID does not exist!");
        }
    }

    public static boolean delete(String pid) {
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null && patientList[i].getPid().equals(pid)) {
                patientList[i] = null;
                return true;
            }
        }
        return false;
    }

    public static void updatePatient() {
        System.out.println("Please enter Patient ID of the patient you want to change:");
        String sPid = scan.next();
        if (doesExist(sPid)) {
            for (int i = 0; i < patientList.length; i++) {
                if (patientList[i] != null && patientList[i].getPid().equals(sPid)) {
                    System.out.println("Please enter Patient name:");
                    String sName = scan.next();
                    patientList[i].setName(sName);
                    System.out.println("Please enter Patient age:");
                    int sAge = scan.nextInt();
                    patientList[i].setAge(sAge);
                    System.out.println("Please enter Patient status:");
                    String sStatus = scan.next();
                    patientList[i].setStatus(sStatus);

                    System.out.println("Modify patient completed, input 1 to continue.");
                    int sCon = scan.nextInt();
                    if (sCon == 1) {
                        updatePatient();
                    } else {
                        break;
                    }
                }
            }
        } else {
            System.out.println("This ID does not exist!");
        }
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.addUser();
        if (userManager.login()) {
            managePatients();
        }
    }
}
