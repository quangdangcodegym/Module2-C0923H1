package employee_manager;

import java.time.LocalDate;

public class Intern extends Employee{
    private String majors;
    private int semester;
    private String universityName;

    public Intern(long id, String fullName, String email, String majors, int semester, String universityName) {
        super(id, fullName, email);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                ", employeeTypeExperience='" + employeeTypeExperience + '\'' +
                ", employeeTypeFresher='" + employeeTypeFresher + '\'' +
                ", employeeTypeIntern='" + employeeTypeIntern + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
