/*
 DROP TABLE modelList 
CASCADE CONSTRAINTS;

DROP SEQUENCE modelList_SEQ;

CREATE TABLE modelList
(
    prd_index         NUMBER(6)        NOT NULL, 
    prd_name          VARCHAR2(100)    NULL, 
    prd_model_name    VARCHAR2(20)     NULL, 
    prd_price         NUMBER(8)        NULL, 
    CONSTRAINT MODELLIST_PK PRIMARY KEY (prd_index)
);


CREATE SEQUENCE modelList_SEQ
START WITH 1
INCREMENT BY 1;
 */


package Dto;

import java.io.Serializable;

public class ModelDto implements Serializable {

	private int prd_index;					//번호
	private String prd_name;				//제품명
	private String prd_model_name;			//모델명
	private int prd_price;				//가격

	
	public ModelDto() {
	
	}


	public ModelDto(int prd_index, String prd_name, String prd_model_name, int prd_price) {
		super();
		this.prd_index = prd_index;
		this.prd_name = prd_name;
		this.prd_model_name = prd_model_name;
		this.prd_price = prd_price;
	}


	@Override
	public String toString() {
		return "ModelListDto [prd_index=" + prd_index + ", prd_name=" + prd_name + ", prd_model_name=" + prd_model_name
				+ ", prd_price=" + prd_price + "]";
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


	public int getPrd_price() {
		return prd_price;
	}


	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}


	
}
