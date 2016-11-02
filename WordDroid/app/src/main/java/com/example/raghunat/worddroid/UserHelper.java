package com.example.raghunat.worddroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghunat on 11/2/2016.
 */
public class UserHelper {

    public static List<String> usernames = new ArrayList<String>();
    public static List<String> passwords = new ArrayList<String>();

    // Creates a user with some logic, or throws the error
    public static void CreateUser(String username, String password) throws Exception {
        if(username.length() < 5) {
            throw new Exception("Username needs to be 5 chars long");
        } else if(password.length() < 4) {
            throw new Exception("Password needs to be 4 chars long");
        } else if(password.equals(username)) {
            throw new Exception("Password cannot be the username");
        }
        // TODO SAVE INTO DB
        usernames.add(username);
        passwords.add(password);
    }
}
