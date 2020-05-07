package Dto;

import java.io.Serializable;

public class PurchaseDto implements Serializable {
	//제품 렌탈 dto
	private int pur_index;					//주문번호
	private String mem_id;					//회원id
	private int prd_index;					//제품번호
	private String pur_date;				//결제일
	private String ins_date;				//설치희망일
	private int order_num;					//구매수량
	private int review;						//후기유무
	private int order_auth;					//주문취소유무
	
	public PurchaseDto() {
		
	}

	public PurchaseDto(int pur_index, String mem_id, int prd_index, String pur_date, String ins_date, int order_num,
			int review, int order_auth) {
		super();
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_index = prd_index;
		this.pur_date = pur_date;
		this.ins_date = ins_date;
		this.order_num = order_num;
		this.review = review;
		this.order_auth = order_auth;
	}

	public PurchaseDto(String mem_id, int prd_index, String ins_date, int order_num) {
		super();
		this.mem_id = mem_id;
		this.prd_index = prd_index;
		this.ins_date = ins_date;
		this.order_num = order_num;
	}
	
	
	
	
	public PurchaseDto(int pur_index, String ins_date) {
		super();
		this.pur_index = pur_index;
		this.ins_date = ins_date;
	}

	@Override
	public String toString() {
		return "PurchaseDto [pur_index=" + pur_index + ", mem_id=" + mem_id + ", prd_index=" + prd_index + ", pur_date="
				+ pur_date + ", ins_date=" + ins_date + ", order_num=" + order_num + ", review=" + review
				+ ", order_auth=" + order_auth + "]";
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


	

}
