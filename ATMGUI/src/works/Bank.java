package works;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.sql.SQLException;

import GUIs.BalanceNotEnoughException;
import GUIs.PasswordNotRightException;
public class Bank {
	public static MySQLwork mysql = new MySQLwork();
    public Bank(){}

    public void login(long id,String Password) throws PasswordNotRightException, SQLException{
    	if(Password.equals("")){
    		throw new PasswordNotRightException(Password);
    	}
    	if(mysql.querypassword(id).equals(Password)){
    		return;
    	}else{
    		throw new PasswordNotRightException(Password);
    	}
    }

    public void register(String Password,String name,String email,String personid,String acctype) throws SQLException{
    	if(acctype.equals("CreditAccount")){
    		mysql.creditadd(Password, name, personid, email, acctype, 0, 0, 0, 10000);
    	}else{
    		mysql.savingadd(Password, name, personid, email, acctype, 0, 0);
    	}
    }
    
    public void withdraw(long id,Double money) throws SQLException,BalanceNotEnoughException{
    	if(mysql.querybalance(id)>=money){
    		mysql.updateBalance(id, mysql.querybalance(id)-money);
    	}else if(mysql.querybalance(id)<money && money<=mysql.querybalance(id)+mysql.creditquerytotalcreditamount(id)){
    		mysql.creditupdateCreditamount(id, money-mysql.querybalance(id));
    		mysql.updateBalance(id, 0);
    	}else{
    		throw new BalanceNotEnoughException(-1);
    	}
	}
    

    public void deposit(long id,Double money) throws SQLException{
    	mysql.updateBalance(id, mysql.querybalance(id)+money);
	}
    
    public void transfer(long from,long to,double money) throws SQLException{
    	mysql.updateBalance(from, mysql.querybalance(from)-money);
    	mysql.updateBalance(to, mysql.querybalance(to)+money);
    }
    

    public void paycredit(long nowid, Double money) throws SQLException{
		mysql.creditupdateCreditamount(nowid, mysql.creditquerycreditamount(nowid)-money);
	}
    

    public void loanmoney(long nowid, Double money) throws SQLException{
		mysql.updateLoanmoney(nowid, money);
	}
    

    public void payloan(long nowid, Double money) throws SQLException{
    	mysql.updateLoanmoney(nowid,mysql.queryloanmoney(nowid)-money);
	}
    
//    public void upDate() {   //DAO
//        FileOutputStream fos=null;
//        ObjectOutputStream oos=null;
//        try{
//            fos=new FileOutputStream(dataFile);
//            oos=new ObjectOutputStream(fos);
//            oos.writeObject(this.database);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try{
//                oos.close();
//                fos.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//   public void readData() {  //DAO
//       FileInputStream fis=null;
//       ObjectInputStream ois=null;
//       try{
//           fis=new FileInputStream(dataFile);
//           ois=new ObjectInputStream(fis);
//           this.database=(ArrayList) ois.readObject();
////           this.accountsNum=this.accounts.size();
//       }catch (Exception e){
//           e.printStackTrace();
//       }finally {
//           try{
//               ois.close();
//               fis.close();
//           }catch (Exception e){
//               e.printStackTrace();
//           }
//       }
//   }
//
//   	public void showinfo(long nowid){
//   		for(Account each : database){
//   			if(each.getId()==nowid){
//   				System.out.println(each.getId());
//   				System.out.println(each.getName());
//   				System.out.println(each.getPassword());
//   			}
//   		}
//   	}
//   	public void PrintTotal() {
//		// TODO Auto-generated method stub
//		for(Account each : database){
//			System.out.println(each.getId());
//			System.out.println(each.getPassword());
//			System.out.println(each.getName());
//			System.out.println(each.getBalance());
//			System.out.println(each.getPersonid());
//			System.out.println(each.getAccountType());
//			System.out.println("--------------------");
//		}
//	}
//   	
//   	public long getmaxid(){
//   		long mx = -1;
//   		for(Account each : database){
//   			if(mx<each.getId()){
//   				mx = each.getId();
//   			}
//   		}
//   		return mx;
//   	}
	public static void main(String[] args) throws SQLException {
		
//		Bank bank  = new Bank();
//		bank.register(100001, "1", "1", "1","1","SavingAccount");
//		bank.upDate();
		

	}
	
}
