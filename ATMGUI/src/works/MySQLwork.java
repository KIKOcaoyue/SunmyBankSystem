package works;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLwork {
	DAO dao = new DAO();
	Connection connection = DAO.getConnection();  //连接数据库
	
	
	public void savingadd(String password,String name,String personid,String email,String accountType,double balance,double loanmoney) throws SQLException{
		String insert = "insert into account(password, name, personid, email, accounttype, balance, loanmoney, creditamount, totalcreditamount) values(\""+password+"\",\""+name+"\",\""+personid+"\",\""+email+"\",\""+accountType+"\","+balance+","+loanmoney+")";
		//String insert = "insert into account values("+id+",\""+password+"\",\""+name+"\",\""+personid+"\",\""+email+"\",\""+accountType+"\","+balance+","+loanmoney+")";
		PreparedStatement sqlinsert = connection.prepareStatement(insert);
		sqlinsert.execute();
	}
	
	public void savingdel(long id) throws SQLException{
		String delete = "delete from account where id = "+id;
		PreparedStatement sqldelete = connection.prepareStatement(delete);
		sqldelete.execute();
	}
	
	public String queryname(long id) throws SQLException{
		String query = "select name from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Name = result.getString("name");
		return Name;
	}
	
	public String querypassword(long id) throws SQLException{
		String query = "select password from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Password = result.getString("password");
		System.out.println(Password);
		return Password;
	}
	
	public String querypersonid(long id) throws SQLException{
		String query = "select personid from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Personid = result.getString("personid");
		return Personid;
	}
	
	public String queryemail(long id) throws SQLException{
		String query = "select email from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Email = result.getString("email");
		return Email;
	}
	
	public String queryaccounttype(long id) throws SQLException{
		String query = "select accounttype from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Accounttype = result.getString("accounttype");
		return Accounttype;
	}
	
	public double querybalance(long id) throws SQLException{
		String query = "select balance from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Balance = result.getString("balance");
		return Double.valueOf(Balance);
	}
	
	public double queryloanmoney(long id) throws SQLException{
		String query = "select loanmoney from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Loanmoney = result.getString("loanmoney");
		return Double.valueOf(Loanmoney);
	}
	
	public void updateBalance(long id,double balance) throws SQLException{
		String update = "update account set balance = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public void updateLoanmoney(long id,double balance) throws SQLException{
		String update = "update account set loanmoney = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public void creditadd(String password,String name,String personid,String email,String accountType,double balance,double loanmoney,double creditamount,double totalcreditamount) throws SQLException{
		//String insert = "insert into creditaccount values("+id+", "+password+","+name+","+personid+","+email+","+accountType+","+balance+","+loanmoney+","+creditamount+","+totalcreditamount+")";
		String insert = "insert into account(password, name, personid, email, accounttype, balance, loanmoney, creditamount, totalcreditamount) values(\""+password+"\",\""+name+"\",\""+personid+"\",\""+email+"\",\""+accountType+"\","+balance+","+loanmoney+","+creditamount+","+totalcreditamount+")";
		PreparedStatement sqlinsert = connection.prepareStatement(insert);
		sqlinsert.execute();
	}
	
	public void creditdel(long id) throws SQLException{
		String delete = "delete from creditaccount where id = "+id;
		PreparedStatement sqldelete = connection.prepareStatement(delete);
		sqldelete.execute();
	}
	
	public String creditqueryname(long id) throws SQLException{
		String query = "select name from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Name = result.getString("name");
		return Name;
	}
	
	
	public String creditquerypersonid(long id) throws SQLException{
		String query = "select personid from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Personid = result.getString("personid");
		return Personid;
	}
	
	public String creditqueryemail(long id) throws SQLException{
		String query = "select email from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Email = result.getString("email");
		return Email;
	}
	
	public String creditqueryaccounttype(long id) throws SQLException{
		String query = "select accounttype from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Accounttype = result.getString("accpunttype");
		return Accounttype;
	}
	
	public double creditquerybalance(long id) throws SQLException{
		String query = "select balance from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Balance = result.getString("balance");
		return Double.valueOf(Balance);
	}
	
	public double creditqueryloanmoney(long id) throws SQLException{
		String query = "select loanmoney from account where id = "+id;
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Loanmoney = result.getString("loanmoney");
		return Double.valueOf(Loanmoney);
	}
	
	public double creditquerycreditamount(long id) throws SQLException{
		String query = "select creditamount from account where id = "+id;
		System.out.println(query);
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Creditamount = result.getString("creditamount");
		return Double.valueOf(Creditamount);
	}
	
	public double creditquerytotalcreditamount(long id) throws SQLException{
		String query = "select totalcreditamount from account where id = "+id;
		System.out.println(query);
		PreparedStatement sqlquery = connection.prepareStatement(query);
		ResultSet result = sqlquery.executeQuery();
		result.next();
		String Totalcreditamount = result.getString("totalcreditamount");
		return Double.valueOf(Totalcreditamount);
	}
	
	public void creditupdateBalance(long id,double balance) throws SQLException{
		String update = "update account set balance = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public void creditupdateLoanmoney(long id,double balance) throws SQLException{
		String update = "update account set loanmoney = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public void creditupdateCreditamount(long id,double balance) throws SQLException{
		String update = "update account set creditamount = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public void creditupdateTotalcreditamount(long id,double balance) throws SQLException{
		String update = "update account set totalcreditamount = "+balance+" where id = "+id;
		PreparedStatement sqlupdate = connection.prepareStatement(update);
		sqlupdate.execute();
	}
	
	public long getlastid() throws SQLException{
		String get_last_id = "select last_insert_id()";
		PreparedStatement getidpst = connection.prepareStatement(get_last_id);
		ResultSet result = getidpst.executeQuery();
		result.next();
		String id = result.getString(1);
		return Long.valueOf(id);
	}
}
