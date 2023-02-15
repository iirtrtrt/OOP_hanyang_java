package assignment2;

import java.time.LocalDate;
import java.util.Scanner;

public class HospitalManagementSystem {
    static HospitalPersonnel[] hospitalPersonnelList;
    static int hosIndex = 0;
    static Patient[] patientList;
    static int patIndex = 0;

    HospitalManagementSystem(HospitalPersonnel[] hp, Patient[] pa) {
        hospitalPersonnelList = hp;
        patientList = pa;
    }

    public void addDoctor(Doctor doctor) {
        hospitalPersonnelList[hosIndex] = doctor;
        hosIndex++;
    }

    public void addNurse(Nurse nurse) {
        hospitalPersonnelList[hosIndex] = nurse;
        hosIndex++;
    }

    public void addPatient(Patient patient) {
        patientList[patIndex] = patient;
        patIndex++;
    }

    public void outputPatient(int pid) {
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null && patientList[i].getPid() == pid) {
                patientList[i].outputPatientInfo();
            }
        }
    }

    public void outputPatient() {
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null) {
                patientList[i].outputPatientInfo();
            }
        }
    }

    public HospitalPersonnel login(String name, String password) {
        for (int i = 0; i < hospitalPersonnelList.length; i++) {
            if (hospitalPersonnelList[i].name.equals(name) && hospitalPersonnelList[i].password.equals(password)) {
                return hospitalPersonnelList[i];
            }
        }
        return null;
    }

    public Patient checkPid(int pid) {
        for (int i = 0; i < patientList.length; i++) {
            if (patientList[i] != null && patientList[i].getPid() == pid) {
                return patientList[i];
            }
        }
        return null;
    }

    public Doctor getDoctor(String doctorName) {
        for (int i = 0; i < hospitalPersonnelList.length; i++) {
            if (hospitalPersonnelList[i] != null && hospitalPersonnelList[i].getName().equals(doctorName)) {
                return (Doctor) hospitalPersonnelList[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        HospitalPersonnel[] hp = new HospitalPersonnel[20];
        Patient[] pa = new Patient[20];
        HospitalManagementSystem HMS = new HospitalManagementSystem(hp, pa);

        Doctor d1 = new Doctor(1, "Emma", "123456", HMS);
        Doctor d2 = new Doctor(2, "Olivia", "123456", HMS);
        Nurse n1 = new Nurse(1, "Ava", "123456", HMS);
        Nurse n2 = new Nurse(2, "Mia", "123456", HMS);
        HMS.addDoctor(d1);
        HMS.addDoctor(d2);
        HMS.addNurse(n1);
        HMS.addNurse(n2);

        Patient p1 = new Patient(1, "Bob", 25);
        Patient p2 = new InPatient(2, "Tom", 23, d1, LocalDate.of(2022, 01, 01), LocalDate.of(2022, 11, 11));
        Patient p3 = new OutPatient(3, "Alice", 18, d2, LocalDate.of(2022, 12, 12));
        HMS.addPatient(p1);
        HMS.addPatient(p2);
        HMS.addPatient(p3);

        System.out.println("Name:");
        String sName = scan.next();
        System.out.println("Password:");
        String sPass = scan.next();

        HospitalPersonnel logHP = HMS.login(sName, sPass);
        if (logHP != null) {
            while (true) {
                logHP.managePatient();
                int sNum = scan.nextInt();
                if (logHP instanceof Nurse) {
                    if (sNum == 0) {
                        break;
                    } else if (sNum == 1) {
                        System.out.println("ID for a new patient:");
                        int sPid = scan.nextInt();
                        Patient sP = HMS.checkPid(sPid);
                        if (sP != null) {
                            System.out.println("The ID already exists.");
                        } else {
                            System.out.println("Patient name:");
                            String sPN = scan.next();
                            System.out.println("Patient age:");
                            int sPA = scan.nextInt();
                            System.out.println("Doctor name(Possible to be empty):");
                            String sDN = scanLine.nextLine();
                            if (sDN.isEmpty()) {
                                Patient newPatient = new Patient(sPid, sPN, sPA);
                                HMS.addPatient(newPatient);
                            } else {
                                Doctor Doc = HMS.getDoctor(sDN);
                                if (Doc != null) {
                                    System.out.println(
                                            "Start or appointment date[YYYY-MM-DD](Possible to be empty):");
                                    String sSD = scanLine.nextLine();
                                    if (sSD.isEmpty()) {
                                        Patient newPatient = new Patient(sPid, sPN, sPA, Doc);
                                        HMS.addPatient(newPatient);
                                    } else {
                                        System.out.println("End date[YYYY-MM-DD](Possible to be empty):");
                                        String sED = scanLine.nextLine();
                                        if (sED.isEmpty()) {
                                            LocalDate appointment = LocalDate.parse(sSD);
                                            Patient newPatient = new OutPatient(sPid, sPN, sPA, Doc, appointment);
                                            HMS.addPatient(newPatient);
                                        } else {
                                            LocalDate inDate = LocalDate.parse(sSD);
                                            LocalDate outDAte = LocalDate.parse(sED);
                                            Patient newPatient = new InPatient(sPid, sPN, sPA, Doc, inDate,
                                                    outDAte);
                                            HMS.addPatient(newPatient);
                                        }
                                    }
                                } else {
                                    System.out.println("Could not find the Doctor");
                                }
                            }
                        }
                    } else if (sNum == 2) {
                        System.out.println("ID to update:");
                        int sPid = scan.nextInt();
                        Patient sP = HMS.checkPid(sPid);
                        if (sP != null) {
                            System.out.println(sP.getClass().getSimpleName());
                            System.out.println("Doctor name:");
                            String sDN = scan.next();
                            Doctor Doc = HMS.getDoctor(sDN);
                            if (Doc != null) {
                                sP.setDoctor(Doc);
                                if (sP instanceof OutPatient) {
                                    System.out.println("Appointment date[YYYY-MM-DD]:");
                                    String sSD = scan.next();
                                    LocalDate st = LocalDate.parse(sSD);
                                    ((Nurse) logHP).updatePatient(sPid, st, null);
                                } else if (sP instanceof InPatient) {
                                    System.out.println("Start date[YYYY-MM-DD]:");
                                    String sSD = scan.next();
                                    LocalDate st = LocalDate.parse(sSD);
                                    System.out.println("End date[YYYY-MM-DD]:");
                                    String sED = scan.next();
                                    LocalDate en = LocalDate.parse(sED);
                                    ((Nurse) logHP).updatePatient(sPid, st, en);
                                }
                            } else {
                                System.out.println("Could not find the Doctor");
                            }
                        } else {
                            System.out.println("Could not find that ID");
                        }
                    } else if (sNum == 3) {
                        System.out.println("Write ID or 0 for All");
                        System.out.println("ID to see the information:");
                        int sPid = scan.nextInt();
                        if (sPid == 0) {
                            HMS.outputPatient();
                        } else {
                            HMS.outputPatient(sPid);
                        }
                    } else {
                        System.out.println("Please enter your choice between 0 and 3");
                    }
                } else if (logHP instanceof Doctor) {
                    if (sNum == 0) {
                        break;
                    } else if (sNum == 1) {
                        System.out.println("ID to update:");
                        int sPid = scan.nextInt();
                        Patient sP = HMS.checkPid(sPid);
                        if (sP != null && sP.getDoctor() != null
                                && sP.getDoctor().getName().equals(logHP.getName())) {
                            System.out.println(sP.getDoctor().getName() + " " + logHP.getName());
                            System.out.println("Prescription:");
                            String sPre = scanLine.nextLine();
                            ((Doctor) logHP).updatePatient(sPid, sPre);
                        } else {
                            System.out.println("Could not find that ID or Not your patient");
                        }
                    } else if (sNum == 2) {
                        System.out.println("Write ID or 0 for All");
                        System.out.println("ID to see the information:");
                        int sPid = scan.nextInt();
                        if (sPid == 0) {
                            HMS.outputPatient();
                        } else {
                            HMS.outputPatient(sPid);
                        }
                    } else {
                        System.out.println("Please enter your choice between 0 and 2");
                    }
                }
            }
        }

        scan.close();
        scanLine.close();
    }
}
