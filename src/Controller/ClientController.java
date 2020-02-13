/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Client;
import Utlis.Database;
import java.sql.Connection;
import java.sql.Date;
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
public class ClientController {
    
Connection con;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

    public ClientController() {
        con =Database.getInstance().getConnection();

    }
    
    
    
     private Statement ste;
  public void Add(Client u) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `Client` (`id`, `login`, `pwd`, `lastName`, `firstName`, `role` , 'DateInscription') VALUES (NULL, ?,?,?,?,?,?);");
    pre.setString(1, u.getLogin());
    pre.setString(2, u.getPassword());
    pre.setString(3, u.getLastname());
    pre.setString(4, u.getFirstname());
    pre.setString(5, "Client");
    pre.setDate(6,u.getDateInscription());

    pre.executeUpdate();
    }
      
     public List<Client> readAll() throws SQLException {
    List<Client> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Client");
     while (rs.next()) { 
               
               Date dateInscription = rs.getDate("DateInscription");
               String lastname=rs.getString("lastName");
               String firstname=rs.getString("firstName");
               String role=rs.getString("role");
               String location = rs.getString("location");
               Client u=new Client(dateInscription, lastname,firstname,role,location);
     arr.add(u);
     }
    return arr;
    }

    public boolean delete(Client u) throws SQLException {
        ste = con.createStatement();
        String requeteDelete ="DELETE FROM  `test1`.`Client` WHERE `Client` . login ='"+u.getLogin()+"'";
        return ste.executeUpdate(requeteDelete)==1;
 
    }

  
    public boolean update(Client u) throws SQLException {
        String query  ="UPDATE `test1`.`Client` SET `firstName`=?  WHERE login =?";
        con.setAutoCommit(false);
        preparedStatement = con.prepareStatement(query);        
        preparedStatement.setString(1, u.getFirstname());
        preparedStatement.setString(2, u.getLogin());
        return preparedStatement.executeUpdate()==1;
        
        
    }
}
    

