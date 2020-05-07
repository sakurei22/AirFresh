----------------------------------------------------------------------------------------------------------------------
--		manager insert
--		0 : 왕어드민 1부어드민 2: 매니저 	3 : 설치기사ㅏ
----------------------------------------------------------------------------------------------------------------------

insert into managerMember (mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, MGR_JOINDATE, mgr_delDate, mgr_del)
values (managerMember_SEQ.NEXTVAL, 0, 'k_admin', '1234', '최고관리자', 3, 01012341234, TO_DATE('2018-06-20','YYYY-MM-DD'), null, 0);

insert into managerMember (mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, MGR_JOINDATE, mgr_delDate, mgr_del)
values (managerMember_SEQ.NEXTVAL, 0, 'qwe', 'qwe', '최고관리자', 3, 01012341234, SYSDATE, null, 0);

insert into managerMember (mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, MGR_JOINDATE, mgr_delDate, mgr_del)
values (managerMember_SEQ.NEXTVAL, 1, 'J_admin', '1234', '부메니저', 1, 01012341234, TO_DATE('2015-10-20','YYYY-MM-DD'), null, 0);


insert into managerMember (mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, MGR_JOINDATE, mgr_delDate, mgr_del)
values (managerMember_SEQ.NEXTVAL, 2, '123', '123', '김철근', 2, 01012341234, TO_DATE('2012-11-23','YYYY-MM-DD'), null, 0);

insert into managerMember (mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, MGR_JOINDATE, mgr_delDate, mgr_del)
values (managerMember_SEQ.NEXTVAL, 3, '456', '456', '김공사', 1, 01012341234,   TO_DATE('2012-11-23','YYYY-MM-DD'), null,0);


SELECT * FROM managerMember;


UPDATE managerMember
SET
mgr_id='qwe',
mgr_pw='qwe'
WHERE
mgr_index=60000;




UPDATE managerMember
SET
mgr_id='k_admin',
mgr_pw='1234'
WHERE
mgr_index=60001;


UPDATE managerMember  
SET mgr_name=?, 
mgr_cell=?, 
WHERE mgr_index=?;


----------------------------------------------------------------------------------------------------------------------
--		members insert
----------------------------------------------------------------------------------------------------------------------
INSERT INTO MEMBERS (MEM_ID, MEM_PW, MEM_NAME, MEM_CELL, MEM_BIRTH, MEM_ADDR1, MEM_ADDR2, MEM_ADDR3, MEM_AUTH)
VALUES('a@naver.com', 'aaa111!', '이이이', 01000000000, '19900112', 13483, '경기도 성남시', '분당구 판교동', 3);

INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@w', '123','테스트1','01011232123','19120102',12345,'서울특별시 강남구','1층',0);

INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@ww', '123','테스트2','01011232123','19120102',12345,'서울특별시 중랑구','1층',0);

INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@www', '123','테스트3','01011232123','19120102',12345,'서울특별시 성동구','1층',0);

INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@wwww', '123','테스트4','01011232123','19120102',12345,'서울특별시 강동구','1층',0);

SELECT * FROM MEMBERS;








----------------------------------------------------------------------------------------------------------------------
--		MODELLIST insert
----------------------------------------------------------------------------------------------------------------------

INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '모션공기청정기', 'ACL141MASKWH', 34900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, 'Air Purifier', 'ACLV16BRTLWH', 27900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '인공지능 슈퍼 L 청정기', 'ACLV15HRTLWH', 29900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, 'U필터 공기청정기', 'ACL120UASKCG', 32900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '미니언즈 공기청정기', 'ACL121CZSKYL', 25900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '공기청정기 MINI', 'ACLV12BRTLWH', 23900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, 'AI 공기청정기 32평형', 'ACLV32BRTLWH', 49900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '공기청정기 R11', 'ACLR11BRTLWH', 21900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '코어 공기청정기 21평형', 'ACL211Z0SKGR', 58900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, '가습청정기 MINI 9평형', 'ACLV09HRTLWH', 25900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES(modelList_SEQ.NEXTVAL, 'AI 공기청정기 20평형', 'ACLV20BRTLSL', 31900);
INSERT INTO MODELLIST (PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE) VALUES (modelList_SEQ.NEXTVAL, '20년 형 AI 공기청정기', 'ACL201VASKWH', 31900);

SELECT * FROM MODELLIST;





----------------------------------------------------------------------------------------------------------------------
--		Purchase insert
----------------------------------------------------------------------------------------------------------------------


INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, 'test@w', 10000, sysdate, TO_DATE('2020/02/18','YYYY/MM/DD'), 
        1, 0, 0);

INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, 'test@w', 10001, sysdate, TO_DATE('2020/02/18','YYYY/MM/DD'), 
        1, 0, 0);        
        
INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, 'test@ww', 10002, sysdate, TO_DATE('2020/02/18','YYYY/MM/DD'), 
        1, 0, 0);

INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, 'test@www', 10003, sysdate, TO_DATE('2020/02/18','YYYY/MM/DD'), 
        1, 0, 0);

INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, 'test@wwww', 10004, sysdate, TO_DATE('2020/02/18','YYYY/MM/DD'), 
        1, 0, 0);


        
select * from PURCHASE;

----------------------------------------------------------------------------------------------------------------------
--	Install	 insert
----------------------------------------------------------------------------------------------------------------------


INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, 20000, TO_DATE('2020/02/18','YYYY/MM/DD'), NULL,
        null, 0);

INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, 20001, TO_DATE('2020/02/18','YYYY/MM/DD'), NULL,
        null, 0);

INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, 20002, TO_DATE('2020/02/18','YYYY/MM/DD'), NULL,
        null, 0);

INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, 20003, TO_DATE('2020/02/18','YYYY/MM/DD'), NULL, NULL, 0);        

INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, 20004, TO_DATE('2020/02/18','YYYY/MM/DD'), NULL, NULL, 0);          

select * from install;



----------------------------------------------------------------------------------------------------------------------
--	orderReview	 insert
----------------------------------------------------------------------------------------------------------------------

INSERT INTO orderreview(re_index, mgr_index, pur_index, wdate, 
order_re_title, order_re_content, order_re_img_path, readcount, rating, re_auth)
VALUES( ORDERREVIEW_SEQ.nextval, 'test@w', 20000, sysdate, '테스트용리뷰1', '테스트1', null, 0, null, 1);

INSERT INTO orderreview(re_index, mem_id, pur_index, wdate, 
order_re_title, order_re_content, order_re_img_path, readcount, rating, re_auth)
VALUES( ORDERREVIEW_SEQ.nextval, 'test@w', 20001, null, null, null, null, 0, null, 0);

INSERT INTO orderreview(re_index, mem_id, pur_index, wdate, 
order_re_title, order_re_content, order_re_img_path, readcount, rating, re_auth)
VALUES( ORDERREVIEW_SEQ.nextval, 'test@ww', 20002, sysdate, '테스트용리뷰3', '테스트3', null, 0, null, 1);

INSERT INTO orderreview(re_index, mem_id, pur_index, wdate, 
order_re_title, order_re_content, order_re_img_path, readcount, rating, re_auth)
VALUES( ORDERREVIEW_SEQ.nextval, 'test@www', 20003, sysdate, '테스트용리뷰4', '테스트4', null, 0, null, 1);

select * from ORDERREVIEW;


----------------------------------------------------------------------------------------------------------------------
--		noticebbs insert
----------------------------------------------------------------------------------------------------------------------

INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',2, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',1, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',2, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',1, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',2, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',1, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',2, '관리자', sysdate, null, null, 0, 0);
INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval, '렌탈', '냉무',1, '관리자', sysdate, null, null, 0, 0);

select * from noticebbs;


----------------------------------------------------------------------------------------------------------------------
--		QnaBbs insert
----------------------------------------------------------------------------------------------------------------------
--INSERT INTO qnaBbs(qna_index, mem_id, qna_title, qna_content, wdate, qna_secret, re_content, re_date,
--readcount, depth, qna_del)
--VALUES(QNABBS_SEQ.nextval,)

select * from qnaBbs;

----------------------------------------------------------------------------------------------------------------------
--		 insert
----------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------------------------
--		 insert
----------------------------------------------------------------------------------------------------------------------

