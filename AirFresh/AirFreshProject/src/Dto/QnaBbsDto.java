/*
DROP TABLE qnaBbs 
CASCADE CONSTRAINTS;

DROP SEQUENCE qnaBbs_SEQ;

CREATE SEQUENCE qnaBbs_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TABLE qnaBbs
(
    qna_index      NUMBER(6)         NOT NULL, 
    mem_id        VARCHAR2(50)            NULL, 
    qna_title      VARCHAR2(200)      NULL, 
    qna_content    VARCHAR2(4000)      NULL, 
    wdate          DATE              NULL, 
    qna_secret 	   NUMBER(1)		 NULL,
    re_content     VARCHAR2(4000)    NULL, 
    re_date        DATE              NULL, 
    readcount      NUMBER(10)        NULL, 
    depth          NUMBER(2)         NULL, 
    qna_del         NUMBER(1)         NULL, 
    CONSTRAINT QNABBS_PK PRIMARY KEY (qna_index)
);

ALTER TABLE qnaBbs
    ADD CONSTRAINT FK_qnaBbs_mem_id_members_mem_i FOREIGN KEY (mem_id)
        REFERENCES members (mem_id);
         
 */


package Dto;

import java.io.Serializable;

public class QnaBbsDto implements Serializable {
	private int qna_index;
	private String mem_id;
	private String qna_title;
	private String qna_content;
	private String wdate;
	private int readcount;
	private int qna_secret;
	
	private String re_content;
	private String re_date;
	private int depth;
	
	private int qna_del;
	
	public QnaBbsDto() {
	}

	public int getQna_index() {
		return qna_index;
	}

	public void setQna_index(int qna_index) {
		this.qna_index = qna_index;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getQna_secret() {
		return qna_secret;
	}

	public void setQna_secret(int qna_secret) {
		this.qna_secret = qna_secret;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public String getRe_date() {
		return re_date;
	}

	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getQna_del() {
		return qna_del;
	}

	public void setQna_del(int qna_del) {
		this.qna_del = qna_del;
	}

	public QnaBbsDto(int qna_index, String mem_id, String qna_title, String qna_content, String wdate, int readcount,
			int qna_secret, String re_content, String re_date, int depth, int qna_del) {
		super();
		this.qna_index = qna_index;
		this.mem_id = mem_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.wdate = wdate;
		this.readcount = readcount;
		this.qna_secret = qna_secret;
		this.re_content = re_content;
		this.re_date = re_date;
		this.depth = depth;
		this.qna_del = qna_del;
	}

	public QnaBbsDto(String mem_id, String qna_title, String qna_content, int qna_secret) {
		super();
		this.mem_id = mem_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_secret = qna_secret;
	}
	
	public QnaBbsDto(int qna_index, String qna_title, String qna_content, int qna_secret) {
		super();
		this.qna_index = qna_index;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_secret = qna_secret;
	}

	public QnaBbsDto(int qna_index, String qna_title, String qna_content, int qna_secret, String re_content) {
		super();
		this.qna_index = qna_index;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_secret = qna_secret;
		this.re_content = re_content;
	}
	
	
}
