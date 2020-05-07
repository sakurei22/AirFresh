

DROP TABLE orderReview 
CASCADE CONSTRAINTS;
DROP TABLE purchase 
CASCADE CONSTRAINTS;
DROP TABLE modelList 
CASCADE CONSTRAINTS;
DROP TABLE noticeBbs 
CASCADE CONSTRAINTS;
DROP TABLE qnaBbs 
CASCADE CONSTRAINTS;
DROP TABLE asApplication 
CASCADE CONSTRAINTS;
DROP TABLE asReview 
CASCADE CONSTRAINTS;
DROP TABLE members 
CASCADE CONSTRAINTS;
DROP TABLE managerMember 
CASCADE CONSTRAINTS;
DROP TABLE INSTALL
CASCADE CONSTRAINTS;




DROP SEQUENCE asReview_SEQ; 
DROP SEQUENCE managerMember_SEQ;
DROP SEQUENCE noticeBbs_SEQ;
DROP SEQUENCE qnaBbs_SEQ;
DROP SEQUENCE orderReview_SEQ;
DROP SEQUENCE purchase_SEQ;
DROP SEQUENCE modelList_SEQ;
DROP SEQUENCE asApplication_SEQ;
DROP SEQUENCE INSTALL_SEQ;




CREATE SEQUENCE modelList_SEQ
START WITH 10000
INCREMENT BY 1
MAXVALUE 19999
NOCYCLE;

CREATE SEQUENCE purchase_SEQ
START WITH 20000
INCREMENT BY 1
MAXVALUE 29999
NOCYCLE;
 
CREATE SEQUENCE orderReview_SEQ
START WITH 30000
INCREMENT BY 1
MAXVALUE 39999
NOCYCLE;
 

CREATE SEQUENCE qnaBbs_SEQ
START WITH 1
INCREMENT BY 1;
 
CREATE SEQUENCE noticeBbs_SEQ
START WITH 1
INCREMENT BY 1;
 
CREATE SEQUENCE managerMember_SEQ
START WITH 60000
INCREMENT BY 1
MAXVALUE 69999
NOCYCLE;
 

CREATE SEQUENCE asReview_SEQ
START WITH 40000
INCREMENT BY 1
MAXVALUE 49999
NOCYCLE;
 
CREATE SEQUENCE asApplication_SEQ
START WITH 50000
INCREMENT BY 1
MAXVALUE 59999
NOCYCLE;

CREATE SEQUENCE INSTALL_SEQ
START WITH 70000
INCREMENT BY 1
MAXVALUE 79999
NOCYCLE;

-- members Table Create SQL

-- 날짜 : 2020-02-12
-- 수정자 : 이지예 
-- MEM_CELL 컬럼 타입 변경 : NUMBER -> VARCHAR2(12)

-- 날짜 : 2020-02-17
-- 수정자 : 이지예 
-- MEM_IN_DATE, MEM_OUT_DATE 컬럼 추가 : DATE
-- MEM_DELETE 컬럼추가 : NUMBER(1)

-- 날짜 : 2020-02-18
-- 수정자 : 이지예 
-- MEM_ADDR1 컬럼 타입 변경 : NUMBER -> VARCHAR2(20)

CREATE TABLE members
(
    mem_id       VARCHAR2(50)     NOT NULL, 
    mem_pw       VARCHAR2(20)     NULL, 
    mem_name     VARCHAR2(20)     NULL, 
    mem_cell     VARCHAR2(12)       NULL, 
    mem_birth    VARCHAR2(20)     NULL, 
    mem_addr1    VARCHAR2(20)      NULL, 
    mem_addr2    VARCHAR2(100)    NULL, 
    mem_addr3    VARCHAR2(50)     NULL, 
    mem_in_date	 DATE			  NULL,
    mem_out_date DATE			  NULL,
    mem_auth     NUMBER(1)        NULL, 
    mem_delete 	 NUMBER(1)		  NULL,
    CONSTRAINT MEMBERS_PK PRIMARY KEY (mem_id)
    
);
 

-- members Table Create SQL

--	날짜 : 2020 - 02 - 07
-- 	변경자 : 박지훈        
--  mgr_id 컬럼 -->  mgr_index 로 변경,  FK부여
--  model_name 컬럼 --> pur_index 로 변경 , FK 부여       
CREATE TABLE asApplication
(
    as_index       NUMBER(6)         NOT NULL, 
    mem_id         VARCHAR2(20)      NULL, 
    wdate          VARCHAR2(20)      NULL, 
    req_date       VARCHAR2(20)      NULL, 
    mgr_index      NUMBER(6)     	 NULL, 
    as_title       VARCHAR2(200)     NULL, 
    as_content     VARCHAR2(4000)    NULL, 
    as_img_path    VARCHAR2(100)     NULL, 
    pur_index      NUMBER(6)            NULL, 
    CONSTRAINT ASAPPLICATION_PK PRIMARY KEY (as_index)
);


        
        
-- members Table Create SQL
CREATE TABLE modelList
(
    prd_index         NUMBER(6)        NOT NULL, 
    prd_name          VARCHAR2(100)    NULL, 
    prd_model_name    VARCHAR2(20)     NULL, 
    prd_price         NUMBER(8)        NULL, 
    CONSTRAINT MODELLIST_PK PRIMARY KEY (prd_index)
);






-- purchase Table Create SQL

-- 날짜 : 2020-02-07
-- 수정자 : 박지훈 
-- 컬럼명 변경 :installation_date -->>>  ins_date  

-- 날짜 : 2020-02-07
-- 수정자 : 조지현
-- INS_DATE 컬럼 타입 변경 : DATE -> VARCHAR2(15) 

CREATE TABLE purchase
(
    pur_index        NUMBER(6)       NOT NULL, 
    mem_id             VARCHAR2(50)    NULL, 
    prd_index         NUMBER(6)       NULL, 
    pur_date             DATE            NULL, 
    ins_date    		VARCHAR2(15)            NULL, 
    order_num            NUMBER(3)       NULL, 
    review               NUMBER(1)       NULL, 
    order_auth           NUMBER(1)       NULL, 
    CONSTRAINT PURCHASE_PK PRIMARY KEY (pur_index)
);
 




-- members Table Create SQL

--작성자: 박지훈
--날짜 : 2020- 02 - 18
-- ins_index 추가  FK부여

CREATE TABLE orderReview
(
    re_index             NUMBER(6)         NOT NULL, 
    mem_id           	 VARCHAR2(50)        NOT NULL, 
    pur_index            NUMBER(6)         NULL,
    ins_index			 NUMBER(6)		   NULL,
    wdate                DATE              NULL, 
    order_re_title       VARCHAR2(200)     NULL, 
    order_re_content     VARCHAR2(4000)    NULL, 
    order_re_img_path    VARCHAR2(50)      NULL, 
    readcount            NUMBER(10)        NULL, 
    rating               NUMBER(1)         NULL, 
    re_auth              NUMBER(1)         NULL, 
    CONSTRAINT ORDERREVIEW_PK PRIMARY KEY (re_index)
);
 


--작성자: 박수진
--날짜 : 2020- 02 - 17
--기능 : qnabbs 비밀글 기능을 위한 qna_secret추가
--del -> qna_del로 컬럼명 변경
-- qnatitle 200으로 변경

-- qnaBbs Table Create SQL
CREATE TABLE qnaBbs
(
    qna_index      NUMBER(6)         NOT NULL, 
    mem_id        VARCHAR2(50)            NULL, 
    qna_title      VARCHAR2(200)      NULL, 
    qna_content    VARCHAR2(4000)      NULL, 
    wdate          DATE              NULL, 
    qna_secret	   NUMBER(1)		 NULL,
    re_content     VARCHAR2(4000)    NULL, 
    re_date        DATE              NULL, 
    readcount      NUMBER(10)        NULL, 
    depth          NUMBER(2)         NULL, 
    qna_del         NUMBER(1)         NULL, 
    CONSTRAINT QNABBS_PK PRIMARY KEY (qna_index)
);
 




-- noticeBbs Table Create SQL

-- 날짜 : 2020-02-10
-- 수정자 : 박수진
-- tempfile 컬럼 추가 : VARCHAR2(100) 
CREATE TABLE noticeBbs
(
    noti_index       NUMBER(6)         NOT NULL, 
    noti_title       VARCHAR2(200)     NULL, 
    noti_content     VARCHAR2(4000)    NULL, 
    noti_catagory    NUMBER(1)         NULL, 
    noti_writer      VARCHAR2(20)      NULL, 
    noti_wdate       DATE              NULL, 
    filename         VARCHAR2(100)     NULL,
    tempfile		 VARCHAR2(100)	   NULL,	
    readcount        NUMBER(10)        NULL, 
    noti_del         NUMBER(1)         NULL, 
    CONSTRAINT NOTICEBBS_PK PRIMARY KEY (noti_index)
);
 


-- members Table Create SQL
--  2020-02-18
--	김종현
--  mgr_delDate 맴버의 삭제 날짜를 남기기 위해서 칼럼추가. 
--  mgr_joinDate 맴버 입사일 추가.
CREATE TABLE managerMember
(
    mgr_index    NUMBER(6)       NOT NULL, 
    mgr_auth     NUMBER(1)       NULL, 
    mgr_id       VARCHAR2(50)    NULL, 
    mgr_pw       VARCHAR2(20)    NULL, 
    mgr_name     VARCHAR2(20)    NULL, 
    mgr_loc      NUMBER(3)       NULL, 
    mgr_cell     VARCHAR2(12)      NULL,
    mgr_joinDate DATE			NULL,
    mgr_delDate	 DATE			NULL,
    mgr_del      NUMBER(1)       NULL, 
    CONSTRAINT MANAGERMEMBER_PK PRIMARY KEY (mgr_index)
);
 
SELECT * FROM managerMember;



-- members Table Create SQL
CREATE TABLE asReview
(
    as_re_index       NUMBER            NOT NULL, 
    mem_id            VARCHAR2(50)      NULL, 
    as_index          NUMBER(6)         NULL, 
    wdate             DATE              NULL, 
    as_re_title       NVARCHAR2(200)    NULL, 
    as_re_content     VARCHAR2(4000)    NULL, 
    as_re_img_path    VARCHAR2(50)      NULL, 
    readcount         NUMBER(10)        NULL, 
    rating            NUMBER(1)         NULL, 
    as_auth           NUMBER(1)         NULL, 
    CONSTRAINT ASREVIEW_PK PRIMARY KEY (as_re_index)
);
 


--작성자: 박지훈
--날짜 : 2020- 02 - 07
--기능 : 설치신청을 저장하는 테이블

CREATE TABLE INSTALL(
	--제품설치 인덱스(PK)
	ins_index NUMBER(6) PRIMARY KEY,
	--제품렌탈 인덱스(FK)
	pur_index NUMBER(6) NOT NULL,
	--설치 희망일
	ins_date  DATE  NULL,
	--설치 완료일
	comp_date DATE  NULL,
	--매니저 인덱스(FK)
	mgr_index NUMBER(6)  NULL,
	--처리상태 (1/0)
	ins_state NUMBER(1)  NOT NULL

);

ALTER TABLE asApplication
    ADD CONSTRAINT FK_asApplication_mem_id_member FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);

ALTER TABLE asApplication
    ADD CONSTRAINT FK_asApplication_mrg_id_mgrMem FOREIGN KEY (mgr_index)
        REFERENCES managerMember(mgr_index);

ALTER TABLE asApplication
    ADD CONSTRAINT FK_asApplication_pur_index_pur FOREIGN KEY (pur_index)
        REFERENCES purchase(pur_index);




ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_prd_index_model FOREIGN KEY (prd_index)
        REFERENCES modelList (prd_index);
 

ALTER TABLE purchase
    ADD CONSTRAINT FK_purchase_mem_id_members_m FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);
 

ALTER TABLE asReview
    ADD CONSTRAINT FK_asReview_mem_id_members_mem FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);
 

ALTER TABLE asReview
    ADD CONSTRAINT FK_asReview_as_index_asApplica FOREIGN KEY (as_index)
        REFERENCES asApplication (as_index);


ALTER TABLE orderReview
    ADD CONSTRAINT FK_orderReview_pur_index_pur FOREIGN KEY (pur_index)
        REFERENCES purchase (pur_index);
 

ALTER TABLE orderReview
    ADD CONSTRAINT FK_orderReview_mem_id_members FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);
        
ALTER TABLE orderReview
    ADD CONSTRAINT FK_orderReview_ins_index_ins FOREIGN KEY (ins_index)
        REFERENCES install (ins_index);


ALTER TABLE qnaBbs
    ADD CONSTRAINT FK_qnaBbs_mem_id_members_mem_i FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);
         
        
ALTER TABLE INSTALL
ADD CONSTRAINTS FK_INSTALL_pur_index_purchase FOREIGN KEY(pur_index)
REFERENCES purchase(pur_index);

ALTER TABLE INSTALL
ADD CONSTRAINTS FK_INSTALL_mgr_index_purchase FOREIGN KEY(mgr_index)
REFERENCES managerMember(mgr_index);
 
-- commit;

--rollback;


