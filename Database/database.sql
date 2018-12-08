--------------------------------------------------------
--  File created - Saturday-December-08-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COURSES
--------------------------------------------------------

  CREATE TABLE "COURSES" 
   (	"COURSE_ID" NUMBER, 
	"DEPARTMENT" VARCHAR2(20 BYTE), 
	"DIVISION_ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"CODE" VARCHAR2(20 BYTE), 
	"LECTURE_HOURS" NUMBER, 
	"SECTION_HOURS" NUMBER, 
	"NUMBER_OF_INSTRUCTORS" NUMBER DEFAULT 1, 
	"TERM" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DIVISION
--------------------------------------------------------

  CREATE TABLE "DIVISION" 
   (	"DIVISION_ID" NUMBER, 
	"NUMBER_OF_STUDENTS" NUMBER, 
	"DIVISION_NAME" VARCHAR2(20 BYTE), 
	"GRADE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HALLS
--------------------------------------------------------

  CREATE TABLE "HALLS" 
   (	"HALL_ID" NUMBER, 
	"DEPARTMENT" NUMBER, 
	"CATEGORY" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"CAPACITY" NUMBER, 
	"CODE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PAGES
--------------------------------------------------------

  CREATE TABLE "PAGES" 
   (	"ID" NUMBER, 
	"PAGE_NAME" VARCHAR2(20 BYTE), 
	"ROLE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PERIODS
--------------------------------------------------------

  CREATE TABLE "PERIODS" 
   (	"PERIOD_ID" NUMBER, 
	"DAY" VARCHAR2(20 BYTE), 
	"PERIOD_NAME" VARCHAR2(20 BYTE), 
	"START_TIME" VARCHAR2(20 BYTE), 
	"END_TIME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PREFERENCES
--------------------------------------------------------

  CREATE TABLE "PREFERENCES" 
   (	"PREFERENCE_ID" NUMBER, 
	"USER_ID" NUMBER, 
	"COURSE_ID" NUMBER, 
	"PERIOD_ID" NUMBER, 
	"RANK" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RESULT
--------------------------------------------------------

  CREATE TABLE "RESULT" 
   (	"RESULT_ID" NUMBER, 
	"PREFERENCE_ID" NUMBER, 
	"HALL_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"USER_ID" NUMBER, 
	"EMAIL" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"FULL_NAME" VARCHAR2(20 BYTE), 
	"DATE_OF_EMPLOYMENT" VARCHAR2(20 BYTE), 
	"ACADEMIC_FIELD" VARCHAR2(20 BYTE), 
	"ROLE" VARCHAR2(20 BYTE), 
	"DEPARTMENT" VARCHAR2(20 BYTE), 
	"ACADEMIC_DEGREE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into COURSES
SET DEFINE OFF;
REM INSERTING into DIVISION
SET DEFINE OFF;
REM INSERTING into HALLS
SET DEFINE OFF;
REM INSERTING into PAGES
SET DEFINE OFF;
REM INSERTING into PERIODS
SET DEFINE OFF;
REM INSERTING into PREFERENCES
SET DEFINE OFF;
REM INSERTING into RESULT
SET DEFINE OFF;
REM INSERTING into USERS
SET DEFINE OFF;
