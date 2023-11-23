package employee_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private static Scanner scanner = new Scanner(System.in);
    private List<Employee> employees;


    public Company(){
        employees = new ArrayList<>();

        employees.add(new Fresher("Quang Dang", "quang.dang@codegym.vn",
                LocalDate.of(1999, 8, 8), "KHA", "DH KHTN"));

        employees.add(new Fresher("Quốc Anh", "quoc.anh@codegym.vn",
                LocalDate.of(1995, 8, 8), "GIOI", "DH Hue"));

        employees.add(new Experience("Ngân 98", "ngan@gmail.com", 5, "chà đĩa"));

    }

    public void displayEmployees(){
        System.out.printf("%10s %20s %30s %20s %30s\n", "ID", "Fullname", "Email", "Employee count", "Summary info");
        for (Employee e : employees) {
            String summary = "";
            if (e instanceof Experience) {
                Experience ex = (Experience) e;
                summary += ex.getEmployeeType() + " " + ex.getProSkill() + " " + ex.getExpInYear();
            }
            if (e instanceof Fresher) {
                Fresher ex = (Fresher) e;
                summary += ex.getEmployeeType() + " " +  ex.getGraduationRank() + " " + ex.getEducation();
            }
            System.out.printf("%10s %20s %30s %20s %30s\n", e.getId(), e.getFullName(), e.getEmail(), e.getEmployeeCount(), summary);
        }
    }

    public static void main(String[] args) {
        Company company = new Company();
//        company.displayEmployees();
//        company.createEmployeeView();
        company.displayEmployees();
        company.editEmployeeView();



    }

    public void createEmployeeView() {

        Employee employee = inputBasicInfo(null);

        switch (employee.employeeType) {
            case EXPERIENCE:{
                employee = new Experience(employee.getFullName(), employee.getEmail());
                inputExperienceInfo((Experience) employee);
                break;
            }
            case INTERN:{
                break;
            }
            case FRESHER:{
                employee = new Fresher(employee.getFullName(), employee.getEmail());
                inputFresherInfo((Fresher) employee);
                break;
            }
        }

        employees.add(employee);
    }


    public void editEmployeeView(){
        System.out.println("Nhập ID: ");
        long id = Long.parseLong(scanner.nextLine());

        Employee e = getEmployeeById(id);
        if (e == null) {
            System.out.println("KHÔNG TỒN TẠI");
        }else{
            Employee employeeEdit = inputBasicInfo(e.getEmployeeType());

            e.setEmail(employeeEdit.getEmail());
            e.setEmployeeCount(employeeEdit.getEmployeeCount());
            e.setFullName(employeeEdit.getFullName());
            e.setEmployeeType(employeeEdit.getEmployeeType());


            switch (e.employeeType) {
                case EXPERIENCE:{
                    e = new Experience(e.getFullName(), e.getEmail());
                    inputExperienceInfo((Experience) e);
                    break;
                }
                case INTERN:{
                    break;
                }
                case FRESHER:{
                    e = new Fresher(e.getFullName(), e.getEmail());
                    inputFresherInfo((Fresher) e);
                    break;
                }
            }

            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    employees.set(i, e);
                }
            }
            displayEmployees();

        }

    }

    public Employee getEmployeeById(long id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    public Employee inputBasicInfo(EmployeeType type){

        Employee employee = null;
        System.out.println("Nhập thông tin nhân viên: ");
        System.out.println("Nhập fullName: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Loại nhân viên: ");
        int choice = 1;
        for (EmployeeType employeeType : EmployeeType.values()) {
            if (employeeType.equals(type) && type != null) {
                continue;
            }
            System.out.printf("Nhập %s: %s \n", choice, employeeType.getName());
            choice++;
        }
        System.out.println("Nhập loại nhân viên: ");
        long employeeType = Long.parseLong(scanner.nextLine());

        employee = new Employee(fullName, email);
        employee.setEmployeeType(EmployeeType.getEmployeeTypeById(employeeType));
        return employee;
    }

    public void inputExperienceInfo(Experience experience){
        System.out.println("Nhập số năm kinh nghiệm");
        int expYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kĩ năng chuyên môn");
        String proSkill = scanner.nextLine();

        experience.setProSkill(proSkill);
        experience.setExpInYear(expYear);
        experience.setEmployeeType(EmployeeType.EXPERIENCE);
    }
    public void inputFresherInfo(Fresher fresher){
        System.out.println("Nhập ngày tốt nghiệp");
        LocalDate date = LocalDate.now();

        System.out.println("Nhập xếp hạng:");
        String rank = scanner.nextLine();

        System.out.println("Nhập trường học");
        String education = scanner.nextLine();


        fresher.setEducation(education);
        fresher.setGraduationDate(date);
        fresher.setGraduationRank(rank);

        fresher.setEmployeeType(EmployeeType.FRESHER);

    }
}
