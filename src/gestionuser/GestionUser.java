/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionuser;

import Controller.LoginController;
import Controller.UserController;
import Entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public class GestionUser {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        
        LoginController ser = new LoginController();
        UserController service = new UserController();
        User u1 = new User("toupa","pwd","mustapha","kerrou");
        //User u2 = new User("admin","system","mustapha","kerrou");
        //User u3 = new User("toupa","toupa","toupa","toupa");
        //service.Add(u1);
        //service.Add(u2);
        //ser.logIn("admin","system");
        //ser.logIn("amine22","amine227");
        /*if(service.delete(u3) == true)
            System.out.println("deleted");
        else
            System.out.println("not deleted");
        */
        List<User> list = service.readAll();
        System.out.println(list); 
        u1.setFirstname("ttt");
        service.update(u1);
       }   

}
    

