package com.example.raghunat.dialogstartup;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button from the layout
        Button meltButton = (Button)findViewById(R.id.melt_button);
        Button googleButton = (Button)findViewById(R.id.ask_google);
        // Add the button listener
        meltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dialog API comes in the factory/builder pattern
                DialogHelper.popup("MyTitle", "Yes", "No", "SomeMessage", false, context, MainActivity.this);
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogHelper.timePopup(context);
            }
        });


    }
}
