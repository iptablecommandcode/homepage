package org.iptime.kibnm821.homepage.bean;

import java.time.LocalDate;

public class CONTENT_VO {
    private String ID;
    private String BIGHEADTITLE;
    private String HEADTITLE;
    private String TITLE;
    private String CONTENTS;
    private String NAME;
    private int NUMBER;
    private LocalDate TIME;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBIGHEADTITLE() {
        return BIGHEADTITLE;
    }

    public void setBIGHEADTITLE(String BIGHEADTITLE) {
        this.BIGHEADTITLE = BIGHEADTITLE;
    }

    public String getHEADTITLE() {
        return HEADTITLE;
    }

    public void setHEADTITLE(String HEADTITLE) {
        this.HEADTITLE = HEADTITLE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCONTENTS() {
        return CONTENTS;
    }

    public void setCONTENTS(String CONTENTS) {
        this.CONTENTS = CONTENTS;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(int NUMBER) {
        this.NUMBER = NUMBER;
    }

    public LocalDate getTIME() {
        return TIME;
    }

    public void setTIME(LocalDate TIME) {
        this.TIME = TIME;
    }

}
