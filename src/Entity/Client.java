/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author musta
 */
public class Client extends User {
    
    private Date dateInscription;

    public Client(Date dateInscription, String login, String password, String lastname, String firstname) {
        super(login, password, lastname, firstname);
        this.dateInscription = dateInscription;
    }

    public Client(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Client(Date dateInscription, String lastname, String firstname, String role) {
        super(lastname, firstname, role);
        this.dateInscription = dateInscription;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "Client{" + "dateInscription=" + dateInscription + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.dateInscription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.dateInscription, other.dateInscription)) {
            return false;
        }
        return true;
    }
    
    
    
}
