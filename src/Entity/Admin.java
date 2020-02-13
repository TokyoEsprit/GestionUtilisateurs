/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author musta
 */
public class Admin extends User {
    
    private String location;

    public Admin(String location, String login, String password, String lastname, String firstname) {
        super(login, password, lastname, firstname);
        this.location = location;
    }

    public Admin(String location) {
        this.location = location;
    }

    public Admin(String location, String lastname, String firstname, String role) {
        super(lastname, firstname, role);
        this.location = location;
    }

    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Admin{" + "location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.location);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
