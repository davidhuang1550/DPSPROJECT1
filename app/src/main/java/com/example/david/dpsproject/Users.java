package com.example.david.dpsproject;

/**
 * Created by david on 2016-10-23.
 */
public class Users {

    private String userName;
    private String password;

    public  Users(){

    }
    public Users(String u, String p) {
        userName = u;
        password = p;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
