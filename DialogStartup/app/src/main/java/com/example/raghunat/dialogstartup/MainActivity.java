package com.example.raghunat.dialogstartup;

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

        // Add the button listener
        meltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dialog API comes in the factory/builder pattern

                // Instantiate
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                // Define
                dialog
                    .setTitle("You're a bad bad person")
                    .setMessage("Click MELT to thwart them.")
                    .setCancelable(false)
                    .setPositiveButton("MELT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface d, int id) {
                            // if this button is clicked, do something
                            // Close the app
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("BE NICE", new DialogInterface.OnClickListener() {
                        public void onClick (DialogInterface d, int id){
                            // Close the popup
                            d.cancel();
                        }
                    });

                // Use
                dialog.create().show();
            }
        });


    }
}
