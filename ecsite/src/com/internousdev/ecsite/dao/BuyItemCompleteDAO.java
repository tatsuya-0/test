package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "INSERT INTO user_buy_item_transaction(item_name,total_price,total_count,user_master_id,pay,total_point,insert_date)VALUES(?,?,?,?,?,?,?)";


	public void buyItemeInfo(String item_name, int total_price, int total_count, String user_master_id,
			String pay, int total_point) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, total_price);
			preparedStatement.setInt(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setInt(6, total_point);
			preparedStatement.setString(7, dateUtil.getDate());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
		public int buyItemHistoryDelete( String user_master_id) throws SQLException {
		String sql = "DELETE FROM user_buy_cart_transaction WHERE user_master_id=?";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
return result;

		}

	}


