package com.example.raghunat.worddroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    protected void registerClick(View view) {
        // validate the form
        EditText usernameField = (EditText)findViewById(R.id.register_username);
        EditText passwordField = (EditText)findViewById(R.id.register_password);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        // TODO Register a user, and if successful
        try {
            UserHelper.CreateUser(username, password);
            // Close intent, if not, Toast error
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
