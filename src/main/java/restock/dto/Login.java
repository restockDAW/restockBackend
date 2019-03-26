package restock.dto;

public class Login implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;

	
	public Login() {
	}

	public Login(final Integer id) {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
