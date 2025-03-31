package com.mvc.beans;

public class categoryBean {

	/*
	 * @author : Athira Unnikrishnan
	 * @date : 25/3/2025
	 * @version : 1.0
	 * @purpose : Bean/Model/POJO class for category Table
	 * 
	 */
	
	private int caId;
	private String caName;
	private float price;
	
	public void setCaId(int caId) {
		this.caId = caId;
	}
	public int getCaId() {
		return caId;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	
	public String getCaName() {
		return caName;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	
	
	
	
}
