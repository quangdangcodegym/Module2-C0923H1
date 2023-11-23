package employee_manager;

public enum EmployeeType {


    EXPERIENCE(1, "Experience"), FRESHER (2, "Fresher"), INTERN(3 , "Intern");

    private EmployeeType(long id, String name){
        this.id = id;
        this.name = name;
    }

    public static EmployeeType getEmployeeTypeById(long id) {
        for (EmployeeType e : EmployeeType.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        for (EmployeeType e : EmployeeType.values()){
            System.out.println(e.getId());
        }
    }
}
