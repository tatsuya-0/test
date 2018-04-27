package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object>session;
	ArrayList<BuyItemDTO> buyItemDTOList=new  	ArrayList<BuyItemDTO>();
BuyItemDAO buyitemDAO=new BuyItemDAO();
	public String execute(){
		buyItemDTOList = buyitemDAO.getBuyItemInfo();

		return SUCCESS;
	}


	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}


	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}


	public Map<String,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
