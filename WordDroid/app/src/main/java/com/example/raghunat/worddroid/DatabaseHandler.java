package com.example.raghunat.worddroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raghunat on 11/4/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "WordDroid", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // users table
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY, " +
                "username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public User getUserByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = '" + name + "'", null);
        if(cursor.moveToFirst()) {
            User user = new User(cursor.getString(1), cursor.getString(2));
            return user; // Found user
        }
        return null; // No user found
    }

    public void createUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);

        // Write to database
        db.insert("users", null, cv);
        db.close();
    }
}
