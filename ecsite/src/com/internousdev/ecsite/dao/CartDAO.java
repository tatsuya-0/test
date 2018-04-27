package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();




	public ArrayList<MyPageDTO> getCartUserInfo( String user_master_id) throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql = "SELECT id,item_transaction_id,item_name,total_price,total_count,total_point,pay FROM user_buy_cart_transaction   WHERE user_master_id  = ? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemId(resultSet.getInt("item_transaction_id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getInt("total_price"));
				dto.setTotalCount(resultSet.getInt("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setTotalpoint(resultSet.getInt("total_point"));
				myPageDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete( int check) throws SQLException {
		String sql = "DELETE FROM user_buy_cart_transaction WHERE id=?";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,check);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
