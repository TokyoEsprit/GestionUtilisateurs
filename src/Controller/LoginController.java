
package Controller;

import Entity.User;
import Utlis.Database;
import Utlis.PasswordUtils;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static sun.rmi.transport.TransportConstants.Version;
        
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

            PasswordUtils crypt = new PasswordUtils();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, crypt.hashPassword(password));
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.err.println("Wrong Logins --///");
                return "Error";

            } else {
                System.out.println("login successfull");
                return "success";
            }

      

    }
    
    public void getAccessTokenfb()
    {
        String accessToken = "EAAAAK7ZBPyU8BAGFZBwGZCPcMVkvhgw8AYa9iK4sZAAmaZBMrd8fPdgbjH4i51orTOGDpmvLyCpGt72BStvfrXoZC135ZB7dTr9ecp1EcgPSz4p5B1osowCjjsOryWM0BZBjUldZApvw0ZBGfZBgGeL7Fo67FPjqTiUIHrV3qeDnqZBbvYNM5Xo16ChSlCzAsYVXaPPAnUwsw51GZAD4EqY9tQrRRHzVPGrNZCZCxo8GYb4BmQadkJLIAqaPq7i";
        com.restfb.Version VERSION_2_5 = null;
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, VERSION_2_5);
        User me = fbClient.fetchObject("me", User.class);
        
        System.out.println(me.getFirstname());
    }

}
