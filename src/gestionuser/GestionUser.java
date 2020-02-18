
package gestionuser;

import Controller.LoginController;
import Controller.UserController;
import Entity.User;
import Utlis.MailUtils;
import java.sql.SQLException;
import java.util.List;
import Utlis.sendSMS;

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
        MailUtils mail = new MailUtils();
        User u1 = new User("admin","system","mustapha","kerrou");
        //User u2 = new User("admin","system","mustapha","kerrou");
        //User u3 = new User("toupa","toupa","toupa","toupa");
        //service.Add(u1);
        //service.Add(u2);
        //ser.logIn("admin","system");
        //ser.logIn("amine22","amine227");
        /*if(service.delete(u1) == true)
            System.out.println("deleted");
        else
            System.out.println("not deleted");
        */
        /*if(service.RechercherParId(11))
            System.out.println("user trouvée");
        else
            System.out.println("non trouvée");*/
        //List<User> list = service.readAll();
        //System.out.println(list); 
        //u1.setFirstname("ttt");
        //service.update(u1);
        //sendSMS sms = new sendSMS();
        //System.out.println(sms.sendSms());
        //LoginController fb = new LoginController();
        //fb.getAccessTokenfb();
        mail.mail();
        
        
        
        
       }   

}
    

