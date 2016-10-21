package com.example.raghunat.sandbox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0); // 0 is my id for this intent
    }
    // RUNs on Intent Results from this activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) { // 0 is the camera intent
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView iv = (ImageView)findViewById(R.id.camera_image_view);
            iv.setImageBitmap(photo);
        }
    }
}
