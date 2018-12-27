package GUIs;

public class BalanceNotEnoughException extends Exception {
	private double amount;
	public BalanceNotEnoughException(double amount){
		this.amount = amount;
	}
	public double getAmount(){
		return this.amount;
	}

}
