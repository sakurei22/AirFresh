INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@ww', '123','테스트3','01011232123','19120102',12345,'서울특별시 강남구','1층',0);

INSERT INTO MEMBERS(mem_id, mem_pw, mem_name, mem_cell, mem_birth,
mem_addr1, mem_addr2, mem_addr3, mem_auth)
VALUES('test@w', '123','테스트1','01011232123','19120102',12345,'서울특별시 중랑구','1층',0);

select * from MEMBERS


INSERT INTO MODELLIST(prd_index, prd_name, prd_model_name, prd_price)
VALUES(MODELLIST_SEQ.NEXTVAL, '','',0);

select * from MODELLIST

INSERT INTO purchase(pur_index, mem_id, prd_index, pur_date, ins_date,
order_num, review, order_auth)
VALUES(PURCHASE_SEQ.NEXTVAL, '', 0, TO_DATE('','YYYY/MM/DD'), TO_DATE('','YYYY/MM/DD'),
        1, 0, 0);

select * from purchase     
        
        
INSERT INTO install(ins_index, pur_index, ins_date, comp_date, mgr_index, ins_state)
VALUES( INSTALL_SEQ.nextval, purIndex, TO_DATE('','YYYY/MM/DD'), TO_DATE('','YYYY/MM/DD'),
        null, 0);

select * from install          
        
INSERT INTO orderreview(re_index, mem_id, pur_index, wdate, 
order_re_title, order_re_content, order_re_img_path, readcount, rating, re_auth)
VALUES( ORDERREVIEW_SEQ.nextval, mem_id, pur_index, TO_DATE('','YYYY/MM/DD'),
        '', '', '', 0, 0, 0);
        
select * from orderreview            
        

INSERT INTO asReview (as_re_index, mem_id, as_index, wdate, as_re_title, as_re_content, as_re_img_path,
readcount, rating, as_auth)
VALUES(ASREVIEW_SEQ.nextval,)

select * from asReview   


INSERT INTO asApplication(as_index, mem_id, wdate, req_date, mgr_index, as_title, as_content,
as_img_path, pur_index)
VALUES(asApplication_SEQ.nextval,)

select * from asApplication

INSERT INTO noticebbs(noti_index, noti_title, noti_content, noti_catagory, noti_writer, noti_wdate,
filename, tempfile, readcount, noti_del)
VALUES(NOTICEBBS_SEQ.nextval,)


select * from noticebbs

INSERT INTO managerMember(mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_del)
VALUES(managerMember_SEQ.nextval,)

select * from managerMember


INSERT INTO qnaBbs(qna_index, mem_id, qna_title, qna_content, wdate, qna_secret, re_content, re_date,
readcount, depth, qna_del)
VALUES(QNABBS_SEQ.nextval,)

select * from qnaBbs
