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

        employees.add(new Fresher(1, "Quang Dang", "quang.dang@codegym.vn",
                LocalDate.of(1999, 8, 8), "KHA", "DH KHTN"));

        employees.add(new Fresher(2, "Quốc Anh", "quoc.anh@codegym.vn",
                LocalDate.of(1995, 8, 8), "GIOI", "DH Hue"));

        employees.add(new Experience(3, "Ngân 98", "ngan@gmail.com", 5, "chà đĩa"));

    }


    public void displayEmployees(){
        System.out.printf("%10s %20s %20s %10s\n", "ID", "Fullname", "Email", "Employee count");
        for (Employee e : employees) {
            System.out.printf("%10s %20s %20s %10s\n", e.getId(), e.getFullName(), e.getEmail(), e.getEmployeeCount());
        }
    }

    public static void main(String[] args) {
        Company company = new Company();
        company.displayEmployees();
        company.createEmployee();

        company.displayEmployees();

    }

    public void createEmployee() {

        Employee employee = inputBasicInfo();


        switch (employee.employeeType) {
            case Employee.employeeTypeExperience:{
                employee = new Experience(employee.getId(), employee.getFullName(), employee.getEmail());
                inputExperienceInfo((Experience) employee);
                break;
            }
            case Employee.employeeTypeIntern:{
                break;
            }
            case Employee.employeeTypeFresher:{
                employee = new Fresher(employee.getId(), employee.getFullName(), employee.getEmail());
                inputFresherInfo((Fresher) employee);
                break;
            }
        }

        employees.add(employee);
    }
    public Employee inputBasicInfo(){

        Employee employee = null;
        System.out.println("Nhập thông tin nhân viên: ");
        System.out.println("Nhập ID: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập fullName: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Nhập loại nhân viên: ");
        String employeeType = scanner.nextLine();

        employee = new Employee(id, fullName, email);
        employee.setEmployeeType(employeeType);
        return employee;
    }

    public void inputExperienceInfo(Experience experience){
        System.out.println("Nhập số năm kinh nghiệm");
        int expYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kĩ năng chuyên môn");
        String proSkill = scanner.nextLine();

        experience.setProSkill(proSkill);
        experience.setExpInYear(expYear);
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

    }
}
