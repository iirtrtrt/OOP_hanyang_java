package lab03;

public class Staff {
    private String name;
    private int age;
    private String department = "None";
    private int workDays = 0;
    private int vacationDays = 20;

    public Staff(String name, int age) {
        this.name = name.substring(0, name.indexOf(" "));
        this.age = age;
    }

    public Staff(String name, int age, String department, int workDays, int vacationDays) {
        this.name = name.substring(0, name.indexOf(" "));
        this.age = age;
        this.department = department;
        this.workDays = workDays;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public boolean sameCarrer(Staff somebody) {
        if (this.department.equals(somebody.department) && this.workDays == somebody.workDays) {
            return true;
        } else {
            return false;
        }
    }

    public void setCarrer(Staff somebody) {
        this.setDepartment(somebody.department);
        this.setWorkDays(somebody.workDays);
    }

    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Department: " + this.department + ", WorkDays: "
                + this.workDays + ", VacationDays: " + this.vacationDays;
    }

    public void vacation(int useVacation) {
        if (useVacation > this.vacationDays) {
            System.out.printf("%s, 남은 휴가 일 수 부족.\n", this.name);
        } else {
            this.vacationDays = this.vacationDays - useVacation;
            System.out.printf("%s, 휴가 %d 사용. 남은 휴가 일 수: %d\n", this.name, useVacation, this.vacationDays);
        }
    }
}