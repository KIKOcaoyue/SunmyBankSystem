package works;
import java.sql.*;

public class DAO {
    private static String BaseURL = "jdbc:mysql://xxx.xx.xx.xx/Sunmydatabase?";
    private static String UserName = "xxxxxx";
    private static String Password = "xxxxxx";
    private static Connection connection = null;
    
    static{
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        try {
            String link = BaseURL + 
                    "user=" + UserName + "&password=" + Password + "&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
            System.out.println("link:" + link);
            connection = DriverManager.getConnection(link);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(){
        if(connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
