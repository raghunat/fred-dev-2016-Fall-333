package com.example.raghunat.sandbox;

import java.util.Date;

/**
 * Created by raghunat on 10/10/2016.
 */
public class Order {

    // Private stuff
    String _calzoneType;
    Date _orderedAt;
    Boolean _isDelivery;
    Boolean _isPounded;
    double _price;
    Boolean _hasFries;
    Boolean _hasDrink;
    String _sauceType;

    // Constructor
    public Order() {
        this._calzoneType = "Custom";
        this._isDelivery = false;
        this._isPounded = false;
        this._price = 1.00;
        this._hasDrink = false;
        this._hasFries = false;
        this._sauceType ="Marinara";
    }

    // Description helper method
    public String getDescription() {
        return this._calzoneType + " with sauce of " + this._sauceType;
    }
}
