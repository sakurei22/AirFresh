/*
 DROP TABLE noticeBbs 
CASCADE CONSTRAINTS;

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
 

CREATE SEQUENCE noticeBbs_SEQ
START WITH 1
INCREMENT BY 1;
 */

package Dto;

import java.io.Serializable;

public class NoticeBbsDto implements Serializable {
	private int noti_index;
	private String noti_title;
	private String noti_content;
	private int noti_catagory;
	private String noti_writer;
	private String wdate;
	private String filename;
	private String tempfile;
	private int readcount;
	private int noti_del;
	
	public NoticeBbsDto() {
	}

	@Override
	public String toString() {
		return "NoticeBbsDto [noti_index=" + noti_index + ", noti_title=" + noti_title + ", noti_content="
				+ noti_content + ", noti_catagory=" + noti_catagory + ", noti_writer=" + noti_writer + ", wdate="
				+ wdate + ", filename=" + filename + ", tempfile=" + tempfile + ", readcount=" + readcount
				+ ", noti_del=" + noti_del + "]";
	}

	public NoticeBbsDto(int noti_index, String noti_title, String noti_content, int noti_catagory, String noti_writer,
			String wdate, String filename, String tempfile, int readcount, int noti_del) {
		super();
		this.noti_index = noti_index;
		this.noti_title = noti_title;
		this.noti_content = noti_content;
		this.noti_catagory = noti_catagory;
		this.noti_writer = noti_writer;
		this.wdate = wdate;
		this.filename = filename;
		this.tempfile = tempfile;
		this.readcount = readcount;
		this.noti_del = noti_del;
	}

	public NoticeBbsDto(String noti_title, String noti_content, int noti_catagory, String filename, String tempfile) {
		super();
		this.noti_title = noti_title;
		this.noti_content = noti_content;
		this.noti_catagory = noti_catagory;
		this.filename = filename;
		this.tempfile = tempfile;
	}

	public int getNoti_index() {
		return noti_index;
	}

	public void setNoti_index(int noti_index) {
		this.noti_index = noti_index;
	}

	public String getNoti_title() {
		return noti_title;
	}

	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}

	public String getNoti_content() {
		return noti_content;
	}

	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}

	public int getNoti_catagory() {
		return noti_catagory;
	}

	public void setNoti_catagory(int noti_catagory) {
		this.noti_catagory = noti_catagory;
	}

	public String getNoti_writer() {
		return noti_writer;
	}

	public void setNoti_writer(String noti_writer) {
		this.noti_writer = noti_writer;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTempfile() {
		return tempfile;
	}

	public void setTempfile(String tempfile) {
		this.tempfile = tempfile;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getNoti_del() {
		return noti_del;
	}

	public void setNoti_del(int noti_del) {
		this.noti_del = noti_del;
	}
	
	
}
