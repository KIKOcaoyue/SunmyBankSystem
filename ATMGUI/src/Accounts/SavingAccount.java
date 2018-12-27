package Accounts;

public class SavingAccount extends Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7959669837782614758L;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(long id, String password, String name, String personid, String email,String accountType, double balance,double loanmoney) {
		super(id, password, name, personid, email,accountType, balance,loanmoney);
		// TODO Auto-generated constructor stub
	}

	public void withdraw(double money){
		
		if(money>this.getBalance()){
			double needs = money-this.getBalance();
		// throw new BalanceNotEnoughException(needs);
		}else{
			this.setBalance(this.getBalance()-money);
		}
	}


}
