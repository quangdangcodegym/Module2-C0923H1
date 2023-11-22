package employee_manager;

public class Employee {

    public final static String employeeTypeExperience = "Experience";
    public final static String employeeTypeFresher  = "Fresher";
    public final static String employeeTypeIntern   = "Intern";

    protected long id;              // thuộc tính, biến instance của đổi tượng, biến toàn cục: có giá tri mặc định
    protected String fullName;
    protected String email;
    protected String employeeType;
    protected static int employeeCount = 0;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Employee(long id, String fullName, String email){
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        employeeCount++;
    }
    public Employee(){
        employeeCount++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeTypeExperience='" + employeeTypeExperience + '\'' +
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
