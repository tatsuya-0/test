package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
public class MasterDAO {


		private DBConnector dbConnector=new DBConnector();

		private Connection connection=dbConnector.getConnection();






		public void itemUpdate(int stock,int id) throws SQLException{
			String sql="UPDATE item_info_transaction SET item_stock = ? WHERE id = ?";
			try{
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, stock);
				preparedStatement.setInt(2, id);

				preparedStatement.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
		}






		public int itemDeletes(int check) {
			String sql="DELETE FROM item_info_transaction WHERE id=?";
			PreparedStatement preparedStatement;
			int result=0;
			try{
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, check);
				result=preparedStatement.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;

		}
	}



