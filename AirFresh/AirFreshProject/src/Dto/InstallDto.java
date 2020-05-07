package Dto;

import java.io.Serializable;

public class InstallDto implements Serializable{
	
	private int ins_index;	//제품 설치 인덱스
	private int pur_index;	//렌탈 인덱스
	private String ins_date;  // 설치희망일 
	private String comp_date;  // 설치완료일
	private int mgr_index; //매니저(직원)인덱스
	private int ins_state;  //처리상태
	private String prd_model_name; //모델명
	private String mem_id;	//회원아이디
	private String mem_name; // 회원이름
	private String mem_cell; //회원 전화번호
	private String pur_date; // 구매일자
	private String mgr_name; //직원이름
	private int mgr_loc; //직원 근무지
	private String mgr_cell; //직원 핸드폰 번호 
	private String mem_addr1; //회원 주소 1
	private String mem_addr2; //회원 주소2
	private String mem_addr3; //회원 주소3
	private String rating; // 별점
	
	
	public InstallDto(int ins_index, String comp_date, String prd_model_name) {
		super();
		this.ins_index = ins_index;
		this.comp_date = comp_date;
		this.prd_model_name = prd_model_name;
	}


	public InstallDto() {
		
	}

	
	public InstallDto(int pur_index, String ins_date) {
		super();
		this.pur_index = pur_index;
		this.ins_date = ins_date;
	}

	public InstallDto(int ins_index, int pur_index, String ins_date, String comp_date, int mgr_index, int ins_state,
			String prd_model_name, String mem_id, String mem_name, String mem_cell, String pur_date, String mgr_name,
			int mgr_loc, String mgr_cell, String mem_addr1, String mem_addr2, String mem_addr3) {
		super();
		this.ins_index = ins_index;
		this.pur_index = pur_index;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.mgr_index = mgr_index;
		this.ins_state = ins_state;
		this.prd_model_name = prd_model_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.pur_date = pur_date;
		this.mgr_name = mgr_name;
		this.mgr_loc = mgr_loc;
		this.mgr_cell = mgr_cell;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
	}


	public InstallDto(int ins_index, int pur_index, String ins_date, String comp_date, int mgr_index, int ins_state,
			String prd_model_name, String mem_id, String mem_name, String pur_date, String mgr_name, int mgr_loc,
			String mgr_cell, String mem_addr1, String mem_addr2, String mem_addr3, String mem_cell) {
		super();
		this.ins_index = ins_index;
		this.pur_index = pur_index;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.mgr_index = mgr_index;
		this.ins_state = ins_state;
		this.prd_model_name = prd_model_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.pur_date = pur_date;
		this.mgr_name = mgr_name;
		this.mgr_loc = mgr_loc;
		this.mgr_cell = mgr_cell;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.mem_cell = mem_cell;
	}
		

	public InstallDto(int ins_index, int pur_index, String ins_date, String comp_date, int mgr_index, int ins_state) {
		super();
		this.ins_index = ins_index;
		this.pur_index = pur_index;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.mgr_index = mgr_index;
		this.ins_state = ins_state;
	}
	
	public InstallDto(int ins_index, int pur_index, String ins_date, String comp_date, int mgr_index, int ins_state,
			String prd_model_name, String mem_id, String mem_name, String pur_date, String mem_addr1, String mem_addr2,
			String mem_addr3, String mem_cell, String rating) {
		super();
		this.ins_index = ins_index;
		this.pur_index = pur_index;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.mgr_index = mgr_index;
		this.ins_state = ins_state;
		this.prd_model_name = prd_model_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.pur_date = pur_date;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.mem_cell = mem_cell;
		this.rating = rating;
	}
	
	public InstallDto(int ins_index, int pur_index, String ins_date, String comp_date, int mgr_index, int ins_state,
			String prd_model_name, String mem_id, String mem_name, String pur_date, String mem_addr1, String mem_addr2,
			String mem_addr3, String mem_cell) {
		super();
		this.ins_index = ins_index;
		this.pur_index = pur_index;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.mgr_index = mgr_index;
		this.ins_state = ins_state;
		this.prd_model_name = prd_model_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.pur_date = pur_date;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.mem_cell = mem_cell;
	}





	public int getIns_index() {
		return ins_index;
	}





	public void setIns_index(int ins_index) {
		this.ins_index = ins_index;
	}





	public int getPur_index() {
		return pur_index;
	}





	public void setPur_index(int pur_index) {
		this.pur_index = pur_index;
	}





	public String getIns_date() {
		return ins_date;
	}





	public void setIns_date(String ins_date) {
		this.ins_date = ins_date;
	}





	public String getComp_date() {
		return comp_date;
	}





	public void setComp_date(String comp_date) {
		this.comp_date = comp_date;
	}





	public int getMgr_index() {
		return mgr_index;
	}





	public void setMgr_index(int mgr_index) {
		this.mgr_index = mgr_index;
	}





	public int getIns_state() {
		return ins_state;
	}





	public void setIns_state(int ins_state) {
		this.ins_state = ins_state;
	}





	public String getPrd_model_name() {
		return prd_model_name;
	}





	public void setPrd_model_name(String prd_model_name) {
		this.prd_model_name = prd_model_name;
	}





	public String getMem_id() {
		return mem_id;
	}





	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}





	public String getMem_name() {
		return mem_name;
	}





	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}





	public String getPur_date() {
		return pur_date;
	}





	public void setPur_date(String pur_date) {
		this.pur_date = pur_date;
	}





	public String getMgr_name() {
		return mgr_name;
	}





	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}





	public int getMgr_loc() {
		return mgr_loc;
	}





	public void setMgr_loc(int mgr_loc) {
		this.mgr_loc = mgr_loc;
	}





	public String getMgr_cell() {
		return mgr_cell;
	}





	public void setMgr_cell(String mgr_cell) {
		this.mgr_cell = mgr_cell;
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

	



	public String getMem_cell() {
		return mem_cell;
	}


	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}
	

}
