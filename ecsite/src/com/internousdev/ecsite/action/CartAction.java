package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private CartDAO cartDAO = new CartDAO();

	private ArrayList<MyPageDTO> CartList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	private String id;
	private Collection<String> checklist;


	public String execute() throws SQLException {

		String result = SUCCESS;
		result = SUCCESS;



		if (checklist == null) {
			String user_master_id = session.get("login_user_id").toString();
			CartList = cartDAO.getCartUserInfo( user_master_id);
		} else  {
			delete(checklist);
		}

		return result;
	}
	void delete(Collection<String> checklist) throws SQLException {
System.out.println(checklist);
		for(String check:checklist){
		int res = cartDAO.buyItemHistoryDelete( Integer.parseInt(check));

		if (res > 0) {
			CartList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public Collection<String> getChecklist() {
		return checklist;
	}
	public void setChecklist(Collection<String> checklist) {
		this.checklist = checklist;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setCartList(ArrayList<MyPageDTO> cartList) {
		CartList = cartList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getCartList() {
		return this.CartList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
