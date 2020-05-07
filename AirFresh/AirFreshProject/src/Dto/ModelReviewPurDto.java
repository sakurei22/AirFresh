package Dto;

import java.io.Serializable;

public class ModelReviewPurDto implements Serializable {
	// modellist , orderrivew, purchase
	
	private int re_index;
	private String wdate;		//리뷰작성일
	private int prd_index;
	private int pur_index;							
	private String mem_id;							
	private String prd_name;
	private String pur_date;
	private String order_re_title;
	private String order_re_content;
	private String order_re_img_path;
	private int rating;
	private int readcount;
	private int re_auth;
	private int review;
	
	public ModelReviewPurDto() {
		
	}




	public ModelReviewPurDto(int re_index, String wdate, int prd_index, int pur_index, String mem_id, String prd_name,
			String pur_date, String order_re_title, String order_re_content, String order_re_img_path, int rating,
			int readcount, int re_auth, int review) {
		super();
		this.re_index = re_index;
		this.wdate = wdate;
		this.prd_index = prd_index;
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_name = prd_name;
		this.pur_date = pur_date;
		this.order_re_title = order_re_title;
		this.order_re_content = order_re_content;
		this.order_re_img_path = order_re_img_path;
		this.rating = rating;
		this.readcount = readcount;
		this.re_auth = re_auth;
		this.review = review;
	}




	public ModelReviewPurDto(int re_index, int pur_index, String mem_id, String order_re_title, String order_re_content,
			String order_re_img_path, int rating) {
		super();
		this.re_index = re_index;
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.order_re_title = order_re_title;
		this.order_re_content = order_re_content;
		this.order_re_img_path = order_re_img_path;
		this.rating = rating;
	}




	public ModelReviewPurDto(String mem_id, String prd_name, String pur_date, String order_re_title,
			String order_re_content, String order_re_img_path, int rating) {
		super();
		this.mem_id = mem_id;
		this.prd_name = prd_name;
		this.pur_date = pur_date;
		this.order_re_title = order_re_title;
		this.order_re_content = order_re_content;
		this.order_re_img_path = order_re_img_path;
		this.rating = rating;
	}




	public ModelReviewPurDto(String order_re_title, String order_re_content, String order_re_img_path, int rating) {
		super();
		this.order_re_title = order_re_title;
		this.order_re_content = order_re_content;
		this.order_re_img_path = order_re_img_path;
		this.rating = rating;
	}




	public ModelReviewPurDto(int re_index, String wdate, int prd_index, int pur_index, String mem_id, String prd_name,
			String pur_date, String order_re_title, String order_re_content, String order_re_img_path, int rating, int re_auth,
			int readcount) {
		super();
		this.re_index = re_index;
		this.wdate = wdate;
		this.prd_index = prd_index;
		this.pur_index = pur_index;
		this.mem_id = mem_id;
		this.prd_name = prd_name;
		this.pur_date = pur_date;
		this.order_re_title = order_re_title;
		this.order_re_content = order_re_content;
		this.order_re_img_path = order_re_img_path;
		this.rating = rating;
		this.re_auth=re_auth;
		this.readcount = readcount;
	}


	public int getReview() {
		return review;
	}


	public void setReview(int review) {
		this.review = review;
	}

	public int getPrd_index() {
		return prd_index;
	}




	public void setPrd_index(int prd_index) {
		this.prd_index = prd_index;
	}




	public int getRe_index() {
		return re_index;
	}


	public void setRe_index(int re_index) {
		this.re_index = re_index;
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


	public String getPrd_name() {
		return prd_name;
	}


	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}


	public String getPur_date() {
		return pur_date;
	}


	public void setPur_date(String pur_date) {
		this.pur_date = pur_date;
	}


	public String getOrder_re_title() {
		return order_re_title;
	}


	public void setOrder_re_title(String order_re_title) {
		this.order_re_title = order_re_title;
	}


	public String getOrder_re_content() {
		return order_re_content;
	}


	public void setOrder_re_content(String order_re_content) {
		this.order_re_content = order_re_content;
	}


	public String getOrder_re_img_path() {
		return order_re_img_path;
	}


	public void setOrder_re_img_path(String order_re_img_path) {
		this.order_re_img_path = order_re_img_path;
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
		return "ModelReviewPurDto [re_index=" + re_index + ", wdate=" + wdate + ", prd_index=" + prd_index
				+ ", pur_index=" + pur_index + ", mem_id=" + mem_id + ", prd_name=" + prd_name + ", pur_date="
				+ pur_date + ", order_re_title=" + order_re_title + ", order_re_content=" + order_re_content
				+ ", order_re_img_path=" + order_re_img_path + ", rating=" + rating + ", readcount=" + readcount + "]";
	}







	

}
