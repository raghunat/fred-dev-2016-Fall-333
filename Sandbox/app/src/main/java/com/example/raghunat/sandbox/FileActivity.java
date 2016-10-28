package com.example.raghunat.sandbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
    }

    protected void createFile(View view) {
        // Create a file in the internal storage
        String fileName = "example.txt";
        String content = "I am inside the file!";
        FileOutputStream stream;

        try {
            // Open/create the "file"
            stream = openFileOutput(fileName, Context.MODE_PRIVATE);
            stream.write(content.getBytes());
            stream.close();
        } catch(Exception e) {
            Log.e("Error", e.getMessage());
        }
    }

    public void startCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0); // 0 is my id for this intent
    }
    // RUNs on Intent Results from this activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) { // 0 is the camera intent
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            String photoName = "My photo.jpg";
            FileOutputStream stream;

            try {
                stream = openFileOutput(photoName, Context.MODE_PRIVATE);
                photo.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                stream.flush();
                stream.close();
            } catch(Exception e) {
                Log.e("Error", e.getMessage());
            }
        }
    }






    protected void listFiles(View view) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.files_list);
        ll.removeAllViews();
        // TODO List all internal files
        File internal = getFilesDir();
        // TODO List all cache files
        File cache = getCacheDir();
        // TODO List all external files
        File external = getExternalFilesDir(null);
        // Create TV's and insert into scroll view
        // EXAMPLE FOR CACHE
        //        String[] cacheList = cache.list();
        //        LinearLayout ll = (LinearLayout)  findViewById(R.id.files_list);
        //        for (int i = 0; i < cacheList.length; i++) {
        //            TextView tv = new TextView(this);
        //            tv.setText(cacheList[i]);
        //            ll.addView(tv);
        //        }

        String[] files = internal.list();
        final Context context = this;
        for (int i = 0; i < files.length; i++) {
            TextView tv = new TextView(this); // create TextView
            tv.setText(files[i]); // set file name
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get the text view
                    TextView tv = (TextView)v;
                    // Get the file and its content
                    File clickedFile = new File(getFilesDir() + "/" + tv.getText());
                    String content = "";
                    try {
                        FileInputStream stream = new FileInputStream(clickedFile);
                        StringBuilder sb = new StringBuilder();
                        while(stream.available() > 0) {
                            sb.append((char)stream.read());
                        }
                        content = sb.toString();
                    } catch (Exception e) {

                    }
                    // Make a toast!
                    Toast toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            // Text view is created, add it to the activity's view
            ll.addView(tv);
        }
     }
}
