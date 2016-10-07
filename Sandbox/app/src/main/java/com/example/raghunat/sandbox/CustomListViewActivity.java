package com.example.raghunat.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomListViewActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        // Get the list view
        lv = (ListView)findViewById(R.id.custom_list_view);
        // Set a custom adapter, that can use our custom template
        lv.setAdapter(new CustomAdapter(
                this,
                new String[] { "Ember", "Angular 2", "React", "Backbone" },
                new int[] {
                        R.drawable.ember,
                        R.drawable.angular,
                        R.drawable.react,
                        R.drawable.backbone
                }
        ));
    }
}
