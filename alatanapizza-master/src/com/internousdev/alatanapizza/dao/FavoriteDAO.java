package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.FavoriteDTO;
import com.internousdev.alatanapizza.util.DBConnector;
import com.internousdev.alatanapizza.util.DateUtil;

public class FavoriteDAO {

	private DateUtil dateUtil =new DateUtil();

	public ArrayList<FavoriteDTO> getFavoriteInfo(String loginId) throws SQLException {
		ArrayList<FavoriteDTO> favoriteDTO =new ArrayList<FavoriteDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();


		String sql = "SELECT pi.id as id, pi.product_id as product_id, pi.product_name as product_name,"
				+ "pi.product_name_kana as product_name_kana, pi.image_file_path as image_file_path,"
				+ "pi.image_file_name as image_file_name, pi.msize_price as msize_price, pi.lsize_price as lsize_price, pi.price as price,"
				+ "pi.category_id as category_id "
				+ "FROM product_info as pi  JOIN favorite_info as fi ON fi.product_id = pi.product_id "
				+ "WHERE fi.user_id = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps);

			while (rs.next()) {
				FavoriteDTO dto = new FavoriteDTO();
			dto.setProductId(rs.getString("id"));
			dto.setProductId(rs.getString("product_id"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setPrice(rs.getString("price"));
			dto.setMsizePrice(rs.getString("msize_price"));
			dto.setLsizePrice(rs.getString("lsize_price"));
			dto.setCategoryId(rs.getInt("category_id"));
			favoriteDTO.add(dto);
		}

	return favoriteDTO;
}

	//選択お気に入り削除
	public int deleteFavoriteInfo(String product_id, String userid) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "delete from favorite_info where user_id =? and product_id =?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, product_id);

			count = ps.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//全件お気に入り削除
	public int deleteAllFavoriteInfo(String userId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int result = 0;

		//当該ユーザーのお気に入り全てを削除
		String sql = "delete from favorite_info where user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//connectionを閉じる
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}








	//カートテーブルにInsertメソッド
	public int insertFavorite(String user_id, String product_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String insert = "INSERT INTO " + "favorite_info ("+ "user_id," + "product_id," + "regist_date) "
				+ "VALUES(?,?,?)";

		int count =0;
		try{
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1,user_id);
			ps.setString(2,product_id);
			ps.setString(3,dateUtil.getDate());


			count =ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return count;
	}

	}
