CREATE TABLE STUDENT (
	PERSON_ID varchar(50) NOT NULL,
	NAME varchar(50) NULL,
	ACCESS_TYPE varchar(16) NULL,
	EXAM_NO varchar(36) NULL,
	STUDENT_NO varchar(36) NULL,
	COLLEGE_CODE varchar(36) NULL,
	MAJOR_CODE varchar(36) NULL,
	MAJOR_NAME varchar(72) NULL,
	EDU_TYPE varchar(36) NULL,
	ADDRESS varchar(512) NULL,
	POST_CODE varchar(8) NULL,
	TEL_NO1 varchar(18) NULL,
	TEL_NO2 varchar(18) NULL,
	EMS varchar(512) NULL,
	UPDATE_TIME datetime NULL,
	COLLEGE_NAME varchar(128) NULL,
	CONSTRAINT PK_STUDENT PRIMARY KEY (PERSON_ID)
) GO


CREATE TABLE EXAM_RESULT (
	BMH nvarchar(36) NOT NULL,
	BKXXFSMC nvarchar(36) NULL,
	BKXXFS nvarchar(36) NULL,
	BKYXSM nvarchar(36) NULL,
	BKYXSMC nvarchar(128) NULL,
	BKZYDM nvarchar(36) NULL,
	BKZYMC nvarchar(128) NULL,
	KSBH nvarchar(128) NULL,
	XM nvarchar(128) NULL,
	ZJHM nvarchar(128) NULL,
	ZZLLM nvarchar(128) NULL,
	ZZLLMC nvarchar(128) NULL,
	ZZLL int NULL,
	WGYM nvarchar(128) NULL,
	WGYMC nvarchar(128) NULL,
	WGY int NULL,
	YWK1M nvarchar(128) NULL,
	YWK1MC nvarchar(128) NULL,
	YWK1 int NULL,
	YWK2M nvarchar(128) NULL,
	YWK2MC nvarchar(128) NULL,
	YWK2 int NULL,
	ZF int NULL,
	CONSTRAINT PK_EXAM_RESULT PRIMARY KEY (BMH)
) GO;

CREATE TABLE STUDENT_SUBJECT (
	ksbh varchar(100) NOT NULL,
	xm varchar(100) NULL,
	zjhm varchar(100) NULL,
	zzllm varchar(100) NULL,
	zzllmc varchar(100) NULL,
	wgym varchar(100) NULL,
	wgymc varchar(100) NULL,
	ywk1m varchar(100) NULL,
	ywk1mc varchar(100) NULL,
	ywk2m varchar(100) NULL,
	ywk2mc varchar(100) NULL,
	CONSTRAINT STUDENT_SUBJECT_MAP_PK PRIMARY KEY (ksbh)
) GO;


CREATE TABLE STU_EXAM_CHECK (
	ksbh varchar(100) NOT NULL,
	xm varchar(100) NULL,
	zjhm varchar(100) NULL,
	kcdm varchar(100) NOT NULL,
	kcmc varchar(100) NULL,
	sumit_time datetime NULL,
	original_result varchar(100) NULL,
	check_result varchar(100) NULL,
	tel_no varchar(100) NULL,
	CONSTRAINT STU_EXAM_CHECK_PK PRIMARY KEY (ksbh,kcdm)
) GO;

CREATE TABLE STUDENT_DOC (
	xhtxm varchar(36) NULL,
	xh varchar(36) NULL,
	xm varchar(128) NULL,
	zjhm varchar(128) NOT NULL,
	lqzymc varchar(256) NULL,
	lqyxsmc varchar(256) NULL,
	lqxxfsmc varchar(100) NULL,
	xz varchar(100) NULL,
	daszdw varchar(512) NULL,
	download_date datetime NULL,
	CONSTRAINT STUDENT_DOC_PK PRIMARY KEY (zjhm)
)

