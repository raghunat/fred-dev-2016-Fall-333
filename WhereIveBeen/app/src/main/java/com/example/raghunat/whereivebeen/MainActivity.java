package com.example.raghunat.whereivebeen;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void getLoc(View view) {
        // Get the location manager for the device
        LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // create a listener for changes in location
        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                TextView tv = (TextView)findViewById(R.id.location_text_view);
                tv.setText(
                        "My Location is: " +
                                location.getLatitude() +
                                ", " +
                                location.getLongitude()
                );
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            @Override
            public void onProviderEnabled(String provider) {}
            @Override
            public void onProviderDisabled(String provider) {}
            };

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.i("Error", "FAILED PERMISSION CHECK");
                ActivityCompat.requestPermissions(
                        this,
                        new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        }, 1 // 1 = the permission request id to track
                );
                Toast.makeText(this, "Click again", Toast.LENGTH_SHORT).show();
                return;
            }

            // assign the listener to the manager
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0,
                    listener);
        }
    }