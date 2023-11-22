package employee_manager;

import java.time.LocalDate;

public class Fresher extends Employee{

    private LocalDate graduationDate;
    private String graduationRank;

    private String education;

    public Fresher(long id, String fullName, String email, LocalDate graduationDate, String graduationRank, String education) {
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

        this.id = id;
        this.email = email;
        this.fullName = fullName;

    }

    public Fresher(long id, String fullName, String email){
        super(id, fullName, email);
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
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
