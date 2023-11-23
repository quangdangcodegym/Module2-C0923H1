package employee_manager;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;



    public Experience(){
//        super()
    }

    public Experience(String fullName, String email, int expInYear, String proSkill){
        super(fullName, email);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        employeeCount++;

//        currentId++;
//        this.id = currentId;

        this.employeeType = EmployeeType.EXPERIENCE;
        this.id = currentId++;
    }
    public Experience(String fullName, String email){
        super(fullName, email);
        employeeCount++;

        //        currentId++;
//        this.id = currentId;

        this.id = currentId++;
    }



    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
