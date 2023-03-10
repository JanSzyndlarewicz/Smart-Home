package User;

import Home.Home;
import Hub.Hub;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    private String phoneNumber;
    private String email;
    private Home home;
    private Hub hub;


    public User(String login,
                String password,
                String label) {
        this.login = login;
        this.password = password;
        this.phoneNumber = "";
        this.email = "";
        this.home = new Home(label);
        this.hub = new Hub();
    }

    public User(String login,
                String password,
                String phoneNumber,
                String email,
                String label) {
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.home = new Home(label);
        this.hub = new Hub();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Home getHome() {
        return home;
    }

    public Hub getHub() {
        return hub;
    }

    public void setHub(Hub hub) {
        this.hub = hub;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
