/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Admin;
import Entity.Admin;
import Utlis.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author musta
 */
public class AdminController {
    
    
    Connection con;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

    public AdminController() {
        con =Database.getInstance().getConnection();

    }
    
    
    
     private Statement ste;
  public void Add(Admin u) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `Admin` (`id`, `login`, `pwd`, `lastName`, `firstName`, `role` , 'location') VALUES (NULL, ?,?,?,?,?,?);");
    pre.setString(1, u.getLogin());
    pre.setString(2, u.getPassword());
    pre.setString(3, u.getLastname());
    pre.setString(4, u.getFirstname());
    pre.setString(5, "Admin");
    pre.setString(6,u.getLocation());

    pre.executeUpdate();
    }
      
     public List<Admin> readAll() throws SQLException {
    List<Admin> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Admin");
     while (rs.next()) { 
               
               String lastname=rs.getString("lastName");
               String firstname=rs.getString("firstName");
               String role=rs.getString("role");
               String location = rs.getString("location");
               Admin u=new Admin(lastname,firstname,role,location);
     arr.add(u);
     }
    return arr;
    }

    public boolean delete(Admin u) throws SQLException {
        ste = con.createStatement();
        String requeteDelete ="DELETE FROM  `test1`.`Admin` WHERE `Admin` . login ='"+u.getLogin()+"'";
        return ste.executeUpdate(requeteDelete)==1;
 
    }

  
    public boolean update(Admin u) throws SQLException {
        String query  ="UPDATE `test1`.`Admin` SET `firstName`=?  WHERE login =?";
        con.setAutoCommit(false);
        preparedStatement = con.prepareStatement(query);        
        preparedStatement.setString(1, u.getFirstname());
        preparedStatement.setString(2, u.getLogin());
        return preparedStatement.executeUpdate()==1;
        
        
    }
}
    
