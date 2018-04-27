package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	private String itemName;
	private String totalPrice;
	private String totalCount;
	private String totalpoint;
	private String payment;
	private String deleteFlg;

	public String execute() throws SQLException {

		System.out.println(itemName);
		System.out.println(totalPrice);
		System.out.println(totalCount);
		System.out.println(totalpoint);
		System.out.println(payment);

		String[] itemNameList = itemName.split(", ", 0);
		String[] totalPriceList = totalPrice.split(", ", 0);
		String[] totalCountList = totalCount.split(", ", 0);
		String[] totalPointList = totalpoint.split(", ", 0);
		String[] paymentList = payment.split(", ", 0);

		for (int i = 0; i < itemNameList.length; i++) {

			buyItemCompleteDAO.buyItemeInfo(itemNameList[i].toString(), Integer.parseInt(totalPriceList[i].toString()),
					Integer.parseInt(totalCountList[i].toString()), session.get("login_user_id").toString(),
					paymentList[i].toString(), Integer.parseInt(totalPointList[i].toString()));
		}


			String user_master_id = session.get("login_user_id").toString();
			buyItemCompleteDAO.buyItemHistoryDelete(user_master_id);

		String result = SUCCESS;
		return result;}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalpoint() {
		return totalpoint;
	}

	public void setTotalpoint(String totalpoint) {
		this.totalpoint = totalpoint;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
