package Dto;

import java.io.Serializable;

public class OrderReviewDto implements Serializable {

	private int re_index;
	private String mem_id;
	private int pur_index;
	private int ins_index;
	private String wdate;
	private String order_title;
	private String order_content;
	private String order_img_path;
	private int readcount;
	private int rating;
	private int re_auth;
	
	public OrderReviewDto() {
	}
	
	
	public OrderReviewDto(int re_index, String mem_id, int pur_index, int ins_index, String wdate, String order_title,
			String order_content, String order_img_path, int readcount, int rating, int re_auth) {
		super();
		this.re_index = re_index;
		this.mem_id = mem_id;
		this.pur_index = pur_index;
		this.ins_index = ins_index;
		this.wdate = wdate;
		this.order_title = order_title;
		this.order_content = order_content;
		this.order_img_path = order_img_path;
		this.readcount = readcount;
		this.rating = rating;
		this.re_auth = re_auth;
	}
	
	public OrderReviewDto(String mem_id, int pur_index, String order_title, String order_content, String order_img_path,
			int rating) {
		super();
		this.mem_id = mem_id;
		this.pur_index = pur_index;
		this.order_title = order_title;
		this.order_content = order_content;
		this.order_img_path = order_img_path;
		this.rating = rating;
	}



	public OrderReviewDto(int re_index, String mem_id, int pur_index, String order_title, String order_content, String order_img_path,
			int rating) {
		super();
		this.re_index=re_index;
		this.mem_id = mem_id;
		this.pur_index = pur_index;
		this.order_title = order_title;
		this.order_content = order_content;
		this.order_img_path = order_img_path;
		this.rating = rating;
	}

	public int getRe_index() {
		return re_index;
	}
	public void setRe_index(int re_index) {
		this.re_index = re_index;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getPur_index() {
		return pur_index;
	}
	public void setPur_index(int pur_index) {
		this.pur_index = pur_index;
	}
	public int getIns_index() {
		return ins_index;
	}
	public void setIns_index(int ins_index) {
		this.ins_index = ins_index;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getOrder_title() {
		return order_title;
	}
	public void setOrder_title(String order_title) {
		this.order_title = order_title;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public String getOrder_img_path() {
		return order_img_path;
	}
	public void setOrder_img_path(String order_img_path) {
		this.order_img_path = order_img_path;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRe_auth() {
		return re_auth;
	}
	public void setRe_auth(int re_auth) {
		this.re_auth = re_auth;
	}


	@Override
	public String toString() {
		return "OrderReviewDto [re_index=" + re_index + ", mem_id=" + mem_id + ", pur_index=" + pur_index
				+ ", ins_index=" + ins_index + ", wdate=" + wdate + ", order_title=" + order_title + ", order_content="
				+ order_content + ", order_img_path=" + order_img_path + ", readcount=" + readcount + ", rating="
				+ rating + ", re_auth=" + re_auth + "]";
	}
	
	
	
}
