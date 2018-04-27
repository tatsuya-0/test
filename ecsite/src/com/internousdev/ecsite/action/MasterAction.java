package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.MasterDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport implements SessionAware {

	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	public Map<String, Object> session;
	private int stock;
	private String id;
	private String stockFlg;

	MasterDAO dao = new MasterDAO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	Collection<String> checkList;

	public String execute() throws SQLException {
		String result = ERROR;

		if (stockFlg != null) {
			result = this.update(stock, id);
		}


		buyItemDTOList = buyItemDAO.getBuyItemInfo();
		return result;
	}

	private String update(int stock, String id) throws NumberFormatException, SQLException {
		String result = SUCCESS;
		dao.itemUpdate(stock, Integer.parseInt(id));
		return result;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockFlg() {
		return stockFlg;
	}

	public void setStockFlg(String stockFlg) {
		this.stockFlg = stockFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
