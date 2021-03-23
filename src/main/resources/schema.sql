DROP TABLE NOTICE_BOARD;
DROP TABLE MEMBER;
DROP SEQUENCE NUMBER_SEQ;

CREATE TABLE MEMBER (
                        ID VARCHAR(10) PRIMARY KEY NOT NULL,
                        PASSWORD VARCHAR (200) NOT NULL,
                        NAME VARCHAR (20) NOT NULL,
                        ADMIN VARCHAR (5) NOT NULL,
                        POSTCODE INT,
                        ROADADDRESS VARCHAR (200),
                        MOREADDRESS VARCHAR (200),
                        PHONE1 INT,
                        PHONE2 INT,
                        PHONE3 INT,
                        TIME DATE
);
CREATE TABLE NOTICE_BOARD (
                     ID VARCHAR (10) NOT NULL,
                     BIGHEADTITLE VARCHAR (30) NOT NULL,
                     HEADTITLE VARCHAR (30) NOT NULL,
                     TITLE VARCHAR (50) NOT NULL,
                     CONTENTS VARCHAR (1000),
                     NAME VARCHAR (20) NOT NULL,
                     NUMBER INT UNIQUE NOT NULL,
                     TIME DATE,
                     FOREIGN KEY (ID,NAME) REFERENCES MEMBER (ID,NAME)
);

CREATE SEQUENCE NUMBER_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;