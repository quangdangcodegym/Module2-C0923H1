package employee_manager;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;



    public Experience(){
//        super()
    }

    public Experience(long id, String fullName, String email, int expInYear, String proSkill){
        super(id, fullName, email);

        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    public Experience(long id, String fullName, String email){
        super(id, fullName, email);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "proSkill='" + proSkill + '\'' +
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
