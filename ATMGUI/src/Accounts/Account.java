package Accounts;
import java.io.Serializable;

public abstract class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7750293504313610680L;
	
	private long id;
    private String password;
    private String name;
    private String personid;
    private String email;
    private String accountType;
    private double balance;
    private double loanmoney;
    public Account(long id, String password, String name, String personid, String email,String accountType, double balance,double loanmoney) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.personid = personid;
        this.email = email;
        this.accountType = accountType;
        this.balance = balance;
        this.loanmoney = loanmoney;
    }

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPersonid() {
        return personid;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
    public double getLoanmoney(){
    	return loanmoney;
    }

    public void setLoanmoney(double money){
    	this.loanmoney = money;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double money) throws Exception;
    
    public Account deposit(double money){
		try{
	    	if(money<0){
				throw new Exception();
			}else{
				this.setBalance(this.getBalance()+money);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}

	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean withdraw() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
