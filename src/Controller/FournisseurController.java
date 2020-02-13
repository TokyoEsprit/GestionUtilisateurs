/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Fournisseur;
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
public class FournisseurController {
    
    Connection con;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

    public FournisseurController() {
        con =Database.getInstance().getConnection();

    }
    
    
    
     private Statement ste;
  public void Add(Fournisseur u) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `Fournisseur` (`id`, `login`, `pwd`, `lastName`, `firstName`, `role` , 'boutique') VALUES (NULL, ?,?,?,?,?,?);");
    pre.setString(1, u.getLogin());
    pre.setString(2, u.getPassword());
    pre.setString(3, u.getLastname());
    pre.setString(4, u.getFirstname());
    pre.setString(5, "Fournisseur");
    pre.setString(6,u.getBoutique());

    pre.executeUpdate();
    }
      
     public List<Fournisseur> readAll() throws SQLException {
    List<Fournisseur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Fournisseur");
     while (rs.next()) { 
               
               String lastname=rs.getString("lastName");
               String firstname=rs.getString("firstName");
               String role=rs.getString("role");
               String boutique = rs.getString("location");
               Fournisseur u=new Fournisseur(lastname,firstname,role,boutique);
     arr.add(u);
     }
    return arr;
    }

    public boolean delete(Fournisseur u) throws SQLException {
        ste = con.createStatement();
        String requeteDelete ="DELETE FROM  `test1`.`Fournisseur` WHERE `Fournisseur` . login ='"+u.getLogin()+"'";
        return ste.executeUpdate(requeteDelete)==1;
 
    }

  
    public boolean update(Fournisseur u) throws SQLException {
        String query  ="UPDATE `test1`.`Fournisseur` SET `firstName`=?  WHERE login =?";
        con.setAutoCommit(false);
        preparedStatement = con.prepareStatement(query);        
        preparedStatement.setString(1, u.getFirstname());
        preparedStatement.setString(2, u.getLogin());
        return preparedStatement.executeUpdate()==1;
        
        
    }
}
    

