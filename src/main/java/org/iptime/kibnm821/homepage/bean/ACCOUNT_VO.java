package org.iptime.kibnm821.homepage.bean;

import java.time.LocalDate;

public class ACCOUNT_VO {
    private String ID;
    private String PASSWORD;
    private String NAME;
    private int POSTCODE;
    private String ROADADDRESS;
    private String MOREADDRESS;
    private int PHONE1;
    private int PHONE2;
    private int PHONE3;
    private String ADMIN;
    private LocalDate TIME;

    public ACCOUNT_VO() {
        setADMIN("USER");
    }

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

    public int getPOSTCODE() {
        return POSTCODE;
    }

    public void setPOSTCODE(int POSTCODE) {
        this.POSTCODE = POSTCODE;
    }

    public String getROADADDRESS() {
        return ROADADDRESS;
    }

    public void setROADADDRESS(String ROADADDRESS) {
        this.ROADADDRESS = ROADADDRESS;
    }

    public String getMOREADDRESS() {
        return MOREADDRESS;
    }

    public void setMOREADDRESS(String MOREADDRESS) {
        this.MOREADDRESS = MOREADDRESS;
    }

    public int getPHONE1() {
        return PHONE1;
    }

    public void setPHONE1(int PHONE1) {
        this.PHONE1 = PHONE1;
    }

    public int getPHONE2() {
        return PHONE2;
    }

    public void setPHONE2(int PHONE2) {
        this.PHONE2 = PHONE2;
    }

    public int getPHONE3() {
        return PHONE3;
    }

    public void setPHONE3(int PHONE3) {
        this.PHONE3 = PHONE3;
    }

    public String getADMIN() {
        return ADMIN;
    }

    public void setADMIN(String ADMIN) {
        this.ADMIN = ADMIN;
    }

    public LocalDate getTIME() {
        return TIME;
    }

    public void setTIME(LocalDate TIME) {
        this.TIME = TIME;
    }

    @Override
    public String toString() {
        return "ACCOUNT_VO{" +
                "ID='" + ID + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", NAME='" + NAME + '\'' +
                ", POSTCODE=" + POSTCODE +
                ", ROADADDRESS='" + ROADADDRESS + '\'' +
                ", MOREADDRESS='" + MOREADDRESS + '\'' +
                ", PHONE1=" + PHONE1 +
                ", PHONE2=" + PHONE2 +
                ", PHONE3=" + PHONE3 +
                ", ADMIN='" + ADMIN + '\'' +
                ", TIME=" + TIME +
                '}';
    }
}
