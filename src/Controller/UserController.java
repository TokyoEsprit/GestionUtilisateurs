
package Controller;

import Entity.User;
import Utlis.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserController {
    
        Connection con;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

    public UserController() {
        con =Database.getInstance().getConnection();

    }
    
    
    
     private Statement ste;
  public void Add(User u) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `user` (`id`, `login`, `pwd`, `lastName`, `firstName`, `role`) VALUES (NULL, ?,?,?,?,?);");
    pre.setString(1, u.getLogin());
    pre.setString(2, u.getPassword());
    pre.setString(3, u.getLastname());
    pre.setString(4, u.getFirstname());
    pre.setString(5, "client");

    pre.executeUpdate();
    }
      
     public List<User> readAll() throws SQLException {
    List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user");
     while (rs.next()) { 
               
               String lastname=rs.getString("lastName");
               String firstname=rs.getString("firstName");
               String role=rs.getString("role");
               User u=new User(lastname,firstname,role);
     arr.add(u);
     }
    return arr;
    }

    public boolean delete(User u) throws SQLException {
        ste = con.createStatement();
        String requeteDelete ="DELETE FROM  `test1`.`user` WHERE `user` . login ='"+u.getLogin()+"'";
        return ste.executeUpdate(requeteDelete)==1;
 
    }

  
    public boolean update(User u) throws SQLException {
        String query  ="UPDATE `test1`.`user` SET `firstName`=?  WHERE login =?";
        con.setAutoCommit(false);
        preparedStatement = con.prepareStatement(query);        
        preparedStatement.setString(1, u.getFirstname());
        preparedStatement.setString(2, u.getLogin());
        return preparedStatement.executeUpdate()==1;
        
        
    }
}
