/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


public class User    
{

    private String login;

    private String password;

    private String lastname;

    private String firstname;
    
    private String role;
    

    public User(String login, String password, String lastname, String firstname) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public User() {
    }

    public User(String lastname, String firstname, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + ", lastname=" + lastname + ", firstname=" + firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
    
    
    

}