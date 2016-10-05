package com.example.raghunat.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    // LIST ITEMS
    ArrayList<String> itemList = new ArrayList<String>();

    // Handle the Listitems into the list view
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // restore activity state
        super.onCreate(savedInstanceState);
        // use the xml layout
        setContentView(R.layout.activity_list_view);
        // create the adapter for the list view
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, itemList);

        // add some default items
        itemList.add("Converse");
        itemList.add("Coach");
        itemList.add("Guiseppes");
        itemList.add("Nike");
        itemList.add("Toes");

        // grab the list view
        ListView lv = (ListView)findViewById(R.id.kicks);
        // make it use our new adapter
        lv.setAdapter(adapter);
    }
}
