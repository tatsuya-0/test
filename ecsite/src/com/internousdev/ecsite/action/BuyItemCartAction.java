package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCartDAO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCartAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemCartDAO buyItemCartDAO = new BuyItemCartDAO();
	private String id;
	private String itemName;
	private int itemPrice;
	private String pay;
	private int count;
	private int totalPoint;
	private String Message;
	ArrayList<BuyItemDTO> buyItemDTOList=new  	ArrayList<BuyItemDTO>();
	BuyItemDAO buyitemDAO=new BuyItemDAO();

	public String execute() throws SQLException {
		buyItemDTOList = buyitemDAO.getBuyItemInfo();
		int totalPoint = (int) (itemPrice * count * 0.01);
		buyItemCartDAO.buyItemCartInfo(
				id,
				itemName,
				itemPrice,
				count,
				totalPoint,
				session.get("login_user_id").toString(),
				pay);
		this.Message="カートにいれました。";
		String result = SUCCESS;
		return result;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}


	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
