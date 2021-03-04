DROP TABLE NOTICE_BOARD;
DROP TABLE MEMBER;


CREATE TABLE MEMBER (
                        ID VARCHAR(10) PRIMARY KEY NOT NULL,
                        PASSWORD VARCHAR(16),
                        NAME VARCHAR (20) NOT NULL,
                        ADMIN VARCHAR (5) NOT NULL
);
CREATE TABLE NOTICE_BOARD (
                     ID VARCHAR (10) NOT NULL,
                     BIGHEADTITLE VARCHAR (30) NOT NULL,
                     HEADTITLE VARCHAR (30) NOT NULL,
                     TITLE VARCHAR (50) NOT NULL,
                     CONTENTS VARCHAR (1000),
                     NAME VARCHAR (20) NOT NULL,
                     NUMBER INT NOT NULL,
                     TIME VARCHAR (100),
                     FOREIGN KEY (ID,NAME) REFERENCES MEMBER (ID,NAME)
);