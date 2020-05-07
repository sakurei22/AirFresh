package Dto;

import java.io.Serializable;

public class RentalDetailDto implements Serializable {
	// modellist, purchase, members, install , orderreivew테이블의 합친 dto

	private int re_index; //re_index
	private int pur_index; // 렌탈 index
	private int prd_price; // 제품 가격
	private int prd_index; // 상품index
	private String mem_id; // 아이디
	private String mem_name; // 이름
	private String mem_cell; // 연락처
	private int mem_addr1; // 주소1
	private String mem_addr2; // 주소2
	private String mem_addr3; // 주소3
	private String prd_name; // 상품명
	private String prd_model_name; // 모델명
	private String pur_date; // 구매일
	private String ins_date; // 설치희망일
	private String comp_date; // 설치완료일
	private int review; // 리뷰상태
	private int ins_state; // 설치상태 완료1 미완료0

	public RentalDetailDto() {

	}

	

	public RentalDetailDto(int re_index, int pur_index, int prd_price, int prd_index, String mem_id, String mem_name,
			String mem_cell, int mem_addr1, String mem_addr2, String mem_addr3, String prd_name, String prd_model_name,
			String pur_date, String ins_date, String comp_date, int review, int ins_state) {
		super();
		this.re_index = re_index;
		this.pur_index = pur_index;
		this.prd_price = prd_price;
		this.prd_index = prd_index;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.review = review;
		this.ins_state = ins_state;
	}



	public RentalDetailDto(int pur_index, int prd_price, int prd_index, String mem_id, String mem_name, String mem_cell,
			int mem_addr1, String mem_addr2, String mem_addr3, String prd_name, String prd_model_name, String pur_date,
			String ins_date, String comp_date, int review, int ins_state) {
		super();
		this.pur_index = pur_index;
		this.prd_price = prd_price;
		this.prd_index = prd_index;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.review = review;
		this.ins_state = ins_state;
	}

	public RentalDetailDto(int pur_index, int prd_price, int prd_index, String mem_id, String mem_name, String mem_cell,
			int mem_addr1, String mem_addr2, String mem_addr3, String prd_name, String prd_model_name, String pur_date,
			String ins_date, String comp_date, int review) {
		super();
		this.pur_index = pur_index;
		this.prd_price = prd_price;
		this.prd_index = prd_index;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_cell = mem_cell;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_addr3 = mem_addr3;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.comp_date = comp_date;
		this.review = review;
	}

	
	
	public int getRe_index() {
		return re_index;
	}


	public void setRe_index(int re_index) {
		this.re_index = re_index;
	}


	public int getIns_state() {
		return ins_state;
	}

	public void setIns_state(int ins_state) {
		this.ins_state = ins_state;
	}

	public int getPrd_index() {
		return prd_index;
	}

	public void setPrd_index(int prd_index) {
		this.prd_index = prd_index;
	}

	public int getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
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

	public String getMem_cell() {
		return mem_cell;
	}

	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}

	public int getMem_addr1() {
		return mem_addr1;
	}

	public void setMem_addr1(int mem_addr1) {
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

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public String getPrd_model_name() {
		return prd_model_name;
	}

	public void setPrd_model_name(String prd_model_name) {
		this.prd_model_name = prd_model_name;
	}

	public String getPur_date() {
		return pur_date;
	}

	public void setPur_date(String pur_date) {
		this.pur_date = pur_date;
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

	public int getPur_index() {
		return pur_index;
	}

	public void setPur_index(int pur_index) {
		this.pur_index = pur_index;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "RentalDetailDto [ pur_index=" + pur_index + ", prd_price=" + prd_price
				+ ", prd_index=" + prd_index + ", mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_cell="
				+ mem_cell + ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2 + ", mem_addr3=" + mem_addr3
				+ ", prd_name=" + prd_name + ", prd_model_name=" + prd_model_name + ", pur_date=" + pur_date
				+ ", ins_date=" + ins_date + ", comp_date=" + comp_date + ", review=" + review + ", ins_state="
				+ ins_state + "]";
	}

	
}
