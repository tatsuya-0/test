package com.internousdev.ecsite.dto;

public class MyPageDTO {
	public String itemName;
	public int totalPrice;
	public int totalCount;
	public String payment;
	public String userName;
	public int id;
	public String insert_date;
	public int totalpoint;
	public int ItemId;

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotalPrice() {
		return totalPrice;
	}


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalpoint() {
		return totalpoint;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	public int getTotalpoint(int totalpoint) {
		return totalpoint;
	}

	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}

}
