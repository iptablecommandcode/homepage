package org.iptime.kibnm821.homepage.bean;

public class ACCOUNT_DTO {
    private String ID;
    private String PASSWORD;
    private String NAME;
    private String ADMIN;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADMIN() {
        return ADMIN;
    }

    public void setADMIN(String ADMIN) {
        this.ADMIN = ADMIN;
    }

    @Override
    public String toString() {
        return "ACCOUNT_DTO{" +
                "ID='" + ID + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ADMIN='" + ADMIN + '\'' +
                '}';
    }
}
