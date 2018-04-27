package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	public CartDAO cartDAO = new CartDAO();
	private ArrayList<MyPageDTO> CartList = new ArrayList<MyPageDTO>();
	private String result;

	public String execute() throws SQLException {
		String user_master_id = session.get("login_user_id").toString();
		CartList = cartDAO.getCartUserInfo(user_master_id);
		result = SUCCESS;
		return result;
	}

	public ArrayList<MyPageDTO> getCartList() {
		return CartList;
	}
	public void setCartList(ArrayList<MyPageDTO> cartList) {
		CartList = cartList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
