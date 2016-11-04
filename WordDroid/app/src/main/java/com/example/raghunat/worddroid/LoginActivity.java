package com.example.raghunat.worddroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserHelper.openDB(this); // Open/instantiate the DB
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
        }
    }

    protected void startRegisterActivity(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, 1);
    }

    protected void login(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username_field);
        EditText passwordField = (EditText) findViewById(R.id.password_field);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if(UserHelper.AuthenticateUser(username, password)) {
            Intent profile = new Intent(this, ProfileActivity.class);
            startActivity(profile);
        } else {
            Toast.makeText(this, "Hmm those credentials don't work.", Toast.LENGTH_SHORT).show();
        }
    }
}
