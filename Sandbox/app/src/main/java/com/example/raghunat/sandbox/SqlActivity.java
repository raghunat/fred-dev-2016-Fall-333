package com.example.raghunat.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SqlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        // create  a temporary order
        Order myOrder = new Order();

        // Show its description
        TextView tv = (TextView)findViewById(R.id.text_view);
        tv.setText(myOrder.getDescription());
    }
}
