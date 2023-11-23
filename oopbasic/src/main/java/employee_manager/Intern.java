package employee_manager;

import java.time.LocalDate;

public class Intern extends Employee{
    private String majors;
    private int semester;
    private String universityName;

    public Intern(String fullName, String email, String majors, int semester, String universityName) {
        super(fullName, email);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;

        employeeCount++;
        this.id = currentId++;
        this.employeeType = EmployeeType.INTERN;
    }


}
