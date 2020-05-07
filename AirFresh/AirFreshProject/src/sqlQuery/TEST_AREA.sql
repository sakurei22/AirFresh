
SELECT * FROM MODELLIST;

SELECT * FROM managerMember;


SELECT * FROM MEMBERS;


SELECT * FROM managerMember;




SELECT * FROM MANAGERMEMBER
WHERE mgr_index=60001 


SELECT * FROM MANAGERMEMBER  WHERE mgr_index=60005 


update managerMember set mgr_del=1 where mgr_index=60005;

     
SELECT *
FROM managerMember

update



비밀번호
이름
휴대전화

UPDATE managerMember
SET
mgr_pw='123123',
mgr_name='나최고',
mgr_cell='01012341234',
WHERE
mgr_index=60000;




--update 

UPDATE managerMember
SET
-- 입력될 데이터 60000 k_admin 최고관리자 1 1012341234 0 0
mgr_auth=1,
mgr_id='k_admin',
mgr_pw='123123',
mgr_name='나최고',
mgr_loc=1,
mgr_cell='01012341234',
mgr_delDate=TO_DATE('2020-01-01','YYYY-MM-DD'),
mgr_del=1
WHERE
mgr_index=60000;

SELECT * FROM managerMember;
