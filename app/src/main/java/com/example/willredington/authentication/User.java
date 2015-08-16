package com.example.willredington.authentication;

/**
 * Created by willredington on 8/15/15.
 */
public class User {

    private long id;
    private String username;
    private String password;
    private static boolean isLoggedIn = false;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        User.isLoggedIn = isLoggedIn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
