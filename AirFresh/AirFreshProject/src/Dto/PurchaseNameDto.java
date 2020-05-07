package Dto;

import java.io.Serializable;

public class PurchaseNameDto implements Serializable {
	// 구매내역 보기 Purchase + Modellist + install + orderreview합치기

	private int re_index; //re_index
	private int pur_index;
	private String mem_id;
	private int prd_index;
	private String prd_name;
	private String prd_model_name;
	private String pur_date;
	private String ins_date;
	private int order_num; // 수량
	private int review;
	private int order_auth;
	private int ins_state; // 설치완료1 미설치0

	public PurchaseNameDto() {

	}


	

	public PurchaseNameDto(int re_index, int pur_index, String mem_id, int prd_index, String prd_name,
			String prd_model_name, String pur_date, String ins_date, int order_num, int review, int order_auth,
			int ins_state) {
		super();
		this.re_index = re_index;
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_index = prd_index;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.order_num = order_num;
		this.review = review;
		this.order_auth = order_auth;
		this.ins_state = ins_state;
	}




	public PurchaseNameDto(int pur_index, String mem_id, int prd_index, String prd_name, String prd_model_name,
			String pur_date, String ins_date, int order_num, int review, int order_auth) {
		super();
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_index = prd_index;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.order_num = order_num;
		this.review = review;
		this.order_auth = order_auth;
	}




	public PurchaseNameDto(int pur_index, String mem_id, int prd_index, String prd_name, String prd_model_name,
			String pur_date, String ins_date, int order_num, int review, int order_auth, int ins_state) {
		super();
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_index = prd_index;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.order_num = order_num;
		this.review = review;
		this.order_auth = order_auth;
		this.ins_state = ins_state;
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

	public int getPur_index() {
		return pur_index;
	}

	public void setPur_index(int pur_index) {
		this.pur_index = pur_index;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getPrd_index() {
		return prd_index;
	}

	public void setPrd_index(int prd_index) {
		this.prd_index = prd_index;
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

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getOrder_auth() {
		return order_auth;
	}

	public void setOrder_auth(int order_auth) {
		this.order_auth = order_auth;
	}




	@Override
	public String toString() {
		return "PurchaseNameDto [pur_index=" + pur_index + ", mem_id=" + mem_id + ", prd_index=" + prd_index
				+ ", prd_name=" + prd_name + ", prd_model_name=" + prd_model_name + ", pur_date=" + pur_date
				+ ", ins_date=" + ins_date + ", order_num=" + order_num + ", review=" + review + ", order_auth="
				+ order_auth + ", ins_state=" + ins_state + "]";
	}

	
}
