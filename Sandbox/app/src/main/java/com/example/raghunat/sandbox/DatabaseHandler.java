package com.example.raghunat.sandbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghunat on 10/12/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "";
    private static final String TABLE_ORDERS = "";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        * CREATE TABLE orders (
        *   id INTEGER PRIMARY KEY,
         *  orderedAt DATETIME,
         *  isDelivery BOOLEAN,
         *  isPounded BOOLEAN,
         *  price double,
         *  hasFries BOOLEAN,
         *  hasDrink BOOLEAN,
         *  sauceType TEXT,
         *  calzoneType TEXT
        * )
        *
        *
        * */
        db.execSQL("CREATE TABLE orders (\n" +
                "  id INTEGER PRIMARY KEY,\n" +
                "  orderedAt DATETIME,\n" +
                "  isDelivery BOOLEAN,\n" +
                "  isPounded BOOLEAN,\n" +
                "  price double,\n" +
                "  hasFries BOOLEAN,\n" +
                "  hasDrink BOOLEAN,\n" +
                "  sauceType TEXT,\n" +
                "  calzoneType TEXT\n" +
                " )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS orders");

        // Create table again
        onCreate(db);
    }
    // Adds a new order to the database
    public void newOrder(Order order) {
        // get writeable instance
        SQLiteDatabase db = this.getWritableDatabase();
        // Prepare values
        ContentValues cv = new ContentValues();
        cv.put("calzoneType", order._calzoneType);
        cv.put("isPounded", order._isPounded);
        // .....

        //Insert
        db.insert("orders", null, cv);
        db.close();
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<Order>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders", null);
        if(cursor.moveToFirst()) {
            do {
                Order order = new Order();
                order._calzoneType = cursor.getString(7);
                order._isPounded = cursor.getInt(3) == 0 ? false : true;
                orderList.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orderList;
    }
}
