package com.example.raghunat.sandbox;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        responseTextView = (TextView)findViewById(R.id.response_text_view);
    }

    protected void getPosts(View view) {
        // do the http request in the background
        new RetrieveFeedTask().execute();
    }


    ///////////////////////////////
    // INSIDE THE ACTIVITY CLASS //
    ///////////////////////////////
    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {
        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseTextView.setText("");
        }
        protected String doInBackground(Void... urls) {
            try {
                String urlString = "http://jsonplaceholder.typicode.com/posts";
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                // Open the internet connection
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()
                        )
                );

                // Create a string builder
                StringBuilder builder = new StringBuilder();

                // Line placeholder
                String line;

                // Get each line of text/packets and build together
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                // close reader
                reader.close();
                return builder.toString();
            } catch(Exception e) {
                // Log error if it occurs
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }
        // task is all done
        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }

            // hide the loader
            progressBar.setVisibility(View.GONE);

            // Update the text view
            responseTextView.setText(response);
        }

    }


}