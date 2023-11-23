package employee_manager;

import java.time.LocalDate;

public class Fresher extends Employee{

    private LocalDate graduationDate;
    private String graduationRank;

    private String education;

    public Fresher(String fullName, String email, LocalDate graduationDate, String graduationRank, String education) {
        // Dung super gọi tới hàm khởi tạo
        //        super(id, fullName, email);

        // Dung super.phuong thuc
//        super.setEmail(email);
//        super.setFullName(fullName);
//        super.setId(id);

        // dùng this
//        this.setEmail(email);
//        this.setFullName(fullName);
//        this.setId(id);

//        this.email = email;
//        this.fullName = fullName;
        super(fullName, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
        employeeCount++;

        this.employeeType = EmployeeType.FRESHER;
        this.id = currentId++;
    }


    public Fresher(String fullName, String email){
        super(fullName, email);
        employeeCount++;

        this.id = currentId++;
    }




    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
