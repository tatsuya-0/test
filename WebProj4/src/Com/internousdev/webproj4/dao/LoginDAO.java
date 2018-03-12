package Com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.internousdev.webproj4.dto.LoginDTO;
import Com.internousdev.webproj4.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;
	private LoginDTO dto = new LoginDTO();

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public LoginDTO select(String username, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select*from users where user_name=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
