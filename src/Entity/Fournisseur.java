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
public class Fournisseur extends User {
    
    private String boutique;

    public Fournisseur(String boutique, String login, String password, String lastname, String firstname) {
        super(login, password, lastname, firstname);
        this.boutique = boutique;
    }

    public Fournisseur(String boutique) {
        this.boutique = boutique;
    }

    public Fournisseur(String boutique, String lastname, String firstname, String role) {
        super(lastname, firstname, role);
        this.boutique = boutique;
    }

    public String getBoutique() {
        return boutique;
    }

    public void setBoutique(String boutique) {
        this.boutique = boutique;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "boutique=" + boutique + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.boutique);
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
        final Fournisseur other = (Fournisseur) obj;
        if (!Objects.equals(this.boutique, other.boutique)) {
            return false;
        }
        return true;
    }
    
    
    
}
