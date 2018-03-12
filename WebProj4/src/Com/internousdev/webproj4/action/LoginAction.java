package Com.internousdev.webproj4.action;

import com.opensymphony.xwork2.ActionSupport;

import Com.internousdev.webproj4.dao.LoginDAO;
import Com.internousdev.webproj4.dto.LoginDTO;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private LoginDTO DTO = new LoginDTO();

	public String execute() {
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

		DTO = dao.select(username, password);

		if (this.username.equals(DTO.getUsername())
				&& this.password.equals(DTO.getPassword())) {
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
