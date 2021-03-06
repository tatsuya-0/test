package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{



	public Map<String, Object> session;
	private CartDAO cartDAO = new CartDAO();

	private ArrayList<MyPageDTO> CartList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	private String id;
	private String checklist;



	public String execute() throws SQLException {

		String result = SUCCESS;
		result = SUCCESS;
		System.out.println(id);

		String[] idList=id.split(",",0);

		for(int i=0; i<idList.length; i++){
	 cartDAO.buyItemHistoryDelete(Integer.parseInt(idList[i].toString()));

		}
		return result;}
	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	public String getChecklist() {
		return checklist;
	}
	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
}
