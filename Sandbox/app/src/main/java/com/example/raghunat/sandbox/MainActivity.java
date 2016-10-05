package com.example.raghunat.sandbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void startListViewActivity(View view) {
        //TODO
        // 1. Create intent of that activity
        Intent intent = new Intent(this, ListViewActivity.class);
        // 2. Start that activity for a result
        startActivityForResult(intent, 1);
    }
}
