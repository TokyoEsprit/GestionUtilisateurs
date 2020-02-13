
package Controller;

import Utlis.Database;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class LoginController {
    
    
    Connection con ;
    PreparedStatement preparedStatement;
    ResultSet resultSet ;
    
    
      public LoginController() {
        con =Database.getInstance().getConnection();

    }
    
    

    
    public String logIn(String login,String password) throws SQLException {

      
        //query
        String sql = "SELECT * FROM user Where login = ? and pwd = ?";

      
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.err.println("Wrong Logins --///");
                return "Error";

            } else {
                if ("admin".equals(login))
                
                {System.out.println("Successfull Login as admin");
                }
                else 
                {
                    System.out.println("Successfull Login");
                }
                return "Success";
            }

      

    }

}
