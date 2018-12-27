package Accounts;

import GUIs.BalanceNotEnoughException;

public class CreditAccount extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5820151312322519210L;
	private double creditamount;
	private double totalcreditamount;
	public CreditAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}
	
	public CreditAccount(long id, String password, String name, String personid, String email,String accountType, double balance,double loanmoney,double creditamount,double totalcreditamount) {
		super(id, password, name, personid, email,accountType, balance,loanmoney);
		this.creditamount = creditamount;
		this.totalcreditamount = totalcreditamount;
		// TODO Auto-generated constructor stub
	}

	public double getCreditamount() {
		return creditamount;
	}

	public double getTotalcreditamount(){
		return this.totalcreditamount;
	}
	public void setCreditamount(double creditamount) {
		this.creditamount = creditamount;
	}
	
	public void withdraw(double money) throws Exception{
		if(money<0 || money>this.getBalance()+this.getCreditamount())
		{
			throw new Exception();
		}
		if(money<=this.getBalance()){
			this.setBalance(this.getBalance()-money);
		}
		if(money>this.getBalance() && money<=this.getBalance()+this.getCreditamount()){
			this.setBalance(0);
			this.setCreditamount(this.getCreditamount()-money+this.getBalance());
		}
	}
	
	public CreditAccount paycredit(double money) throws BalanceNotEnoughException{
		if(money<0){
			throw new BalanceNotEnoughException(money);
		}else{
			this.setCreditamount(this.getCreditamount()-money);
			return this;
		}
	}
	
}
