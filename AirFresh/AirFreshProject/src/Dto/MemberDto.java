package Dto;

import java.io.Serializable;

public class MemberDto implements Serializable {
	
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_cell;
	private String mem_birth;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_addr3;
	private String mem_in_date;
	private String mem_out_date;
	private int mem_auth;
	private int mem_delete;
	
	public MemberDto() {		
	}	

	public MemberDto(String mem_id, String mem_pw, String mem_cell, String mem_addr1, String mem_addr2, String mem_addr3) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_cell = mem_cell;		
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
	}
	
	
	public MemberDto(String mem_id, String mem_pw, String mem_name, String mem_cell, String mem_birth, String mem_addr1,
			String mem_addr2, String mem_addr3, String mem_in_date, String mem_out_date, int mem_auth, int mem_delete) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_birth = mem_birth;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.mem_in_date = mem_in_date;
		this.mem_out_date = mem_out_date;
		this.mem_auth = mem_auth;
		this.mem_delete = mem_delete;
	}

	public MemberDto(String mem_id, String mem_name, String mem_cell, String mem_birth, String mem_addr1, String mem_addr2,
			String mem_addr3) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_birth = mem_birth;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
	}

	public MemberDto(String mem_id, String mem_name, String mem_cell, String mem_birth, String mem_addr1, String mem_addr2,
			String mem_addr3, int mem_auth) {	// , String mem_in_date, String mem_out_date
		super();
		this.mem_id = mem_id;		
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_birth = mem_birth;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;		
		this.mem_auth = mem_auth;
	}
	//this.mem_in_date = mem_in_date;
	//this.mem_out_date = mem_out_date;
	//TODO this.mem_delete = mem_delete;
	public MemberDto(String mem_id, String mem_pw, String mem_name, String mem_cell, String mem_birth, String mem_addr1,
			String mem_addr2, String mem_addr3, int mem_auth) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_birth = mem_birth;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.mem_auth = mem_auth;
	}	//TODO this.mem_delete = mem_delete;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_cell() {
		return mem_cell;
	}

	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_addr1() {
		return mem_addr1;
	}

	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}

	public String getMem_addr2() {
		return mem_addr2;
	}

	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}

	public String getMem_addr3() {
		return mem_addr3;
	}

	public void setMem_addr3(String mem_addr3) {
		this.mem_addr3 = mem_addr3;
	}

	public String getMem_in_date() {
		return mem_in_date;
	}
	
	public void setMem_in_date(String mem_in_date) {
		this.mem_in_date = mem_in_date;
	}
	
	public String getMem_out_date() {
		return mem_out_date;
	}
	
	public void setMem_out_date(String mem_out_date) {
		this.mem_out_date = mem_out_date;
	}
	
	public int getMem_auth() {
		return mem_auth;
	}

	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}

	public int getMem_delete() {
		return mem_delete;
	}
	
	public void setMem_delete(int mem_delete) {
		this.mem_delete = mem_delete;
	}

	@Override
	public String toString() {
		return "MemberDto [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_cell="
				+ mem_cell + ", mem_birth=" + mem_birth + ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2
				+ ", mem_addr3=" + mem_addr3 + ", mem_in_date=" + mem_in_date + ", mem_out_date=" + mem_out_date
				+ ", mem_auth=" + mem_auth + ", mem_delete=" + mem_delete + "]";
	}
	
	
}//end class
