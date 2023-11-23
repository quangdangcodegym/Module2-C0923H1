package employee_manager;

public class Employee {



    protected long id;              // thuộc tính, biến instance của đổi tượng, biến toàn cục: có giá tri mặc định
    protected String fullName;
    protected String email;
    protected EmployeeType employeeType;
    protected static int employeeCount = 0;


    protected static int currentId = 1;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Employee(String fullName, String email){
        this.email = email;
        this.fullName = fullName;

    }
    public Employee(){

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


    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }
}
