package com.internousdev.alatanapizza.dto;

public class FavoriteDTO {

	private String id;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String msizePrice;
	private String lsizePrice;
	private String price;
	private String productId;
	private int categoryId;

	//ゲッター・セッター
	//--------------------------------------

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	//--------------------------------------

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	//--------------------------------------

	public String getProductNameKana(){
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana){
		this.productNameKana= productNameKana;
	}
	//--------------------------------------

	public String getImageFilePath(){
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}
	//--------------------------------------

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	//--------------------------------------

	public String getMsizePrice() {
		return msizePrice;
	}
	public void setMsizePrice(String msizePrice) {
		this.msizePrice = msizePrice;
	}
	//--------------------------------------

	public String getLsizePrice() {
		return lsizePrice;
	}
	public void setLsizePrice(String lsizePrice) {
		this.lsizePrice = lsizePrice;
	}
	//--------------------------------------

	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price= price;
	}
	//--------------------------------------

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	//--------------------------------------

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	//--------------------------------------



}
