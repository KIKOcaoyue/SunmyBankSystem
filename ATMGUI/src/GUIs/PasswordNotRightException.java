package GUIs;

public class PasswordNotRightException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	
	public PasswordNotRightException(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
}
