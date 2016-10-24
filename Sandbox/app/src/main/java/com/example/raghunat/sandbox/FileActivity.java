package com.example.raghunat.sandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
    }

    protected void listFiles(View view) {
        // TODO List all internal files
        File internal = getFilesDir();
        // TODO List all cache files
        File cache = getCacheDir();
        // TODO List all external files
        File external = getExternalFilesDir(null);
        // TODO Create TV's and insert into scroll view
        String[] cacheList = cache.list();
        LinearLayout ll = (LinearLayout)  findViewById(R.id.files_list);
        for (int i = 0; i < cacheList.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(cacheList[i]);
            ll.addView(tv);
        }
     }
}
