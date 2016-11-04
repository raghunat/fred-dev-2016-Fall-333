package com.example.raghunat.worddroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghunat on 11/2/2016.
 */
public class UserHelper {

    public static List<String> usernames = new ArrayList<String>();
    public static List<String> passwords = new ArrayList<String>();

    public static DatabaseHandler db;

    public static void openDB(Context context) {
        if(db != null) {
            db = new DatabaseHandler(context);
        }
    }

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

    public static boolean AuthenticateUser(String username, String password) {
        User user = db.getUserByName(username);
        if(user != null && user.password.equals(password)) {
            return true;
        }
        return false;
    }
}
