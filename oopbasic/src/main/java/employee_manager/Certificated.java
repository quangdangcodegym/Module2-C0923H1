package employee_manager;

import java.time.LocalDate;

public class Certificated {
    private long certificatedID;
    private String certificatedName;
    private String certificatedRank;
    private LocalDate certificatedDate;

    public Certificated(long certificatedID, String certificatedName, String certificatedRank, LocalDate certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
    }

    public Certificated() {
    }

    public long getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(long certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificatedName() {
        return certificatedName;
    }

    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }

    public String getCertificatedRank() {
        return certificatedRank;
    }

    public void setCertificatedRank(String certificatedRank) {
        this.certificatedRank = certificatedRank;
    }

    public LocalDate getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(LocalDate certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
}
