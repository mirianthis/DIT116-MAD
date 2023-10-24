package com.example.it219119;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "GeofenceBroadcastReceiv";

    @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context, "Geofence triggered...", Toast.LENGTH_SHORT).show();

        NotificationHelper notificationHelper = new NotificationHelper(context);

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if (geofencingEvent.hasError()) {
            Log.d(TAG, "onReceive: Error receiving geofence event...");
            return;
        }

        List<Geofence> geofenceList = geofencingEvent.getTriggeringGeofences();
        for (Geofence geofence : geofenceList) {
            Log.d(TAG, "onReceive: " + geofence.getRequestId());
        }

        Location location = geofencingEvent.getTriggeringLocation();
        int transitionType = geofencingEvent.getGeofenceTransition();


        switch (transitionType) {
            case Geofence.GEOFENCE_TRANSITION_ENTER:
                Users user = new Users();
                user.timestamp = (String.valueOf(location.getTime()));
                //user.setTimestamp((String.valueOf(location.getTime())));
                user.lat = (String.valueOf(location.getLatitude()));
                user.lot = (String.valueOf(location.getLongitude()));
                user.action = ("Enter");
                //System.out.println("Timestamp:" + user.timestamp + " + " + user.lot + " + " + user.lat + " + " + user.action);
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MapsActivity.usersDao.insertUsers(user);
                    }
                });
                t1.start();

                //System.out.println("lat: " + location.getLatitude() + " lot: " + location.getLongitude() + " timestamp: " + location.getTime());
                Toast.makeText(context, "GEOFENCE_TRANSITION_ENTER", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEOFENCE_TRANSITION_ENTER", "", MapsActivity.class);
                break;
                /*
            case Geofence.GEOFENCE_TRANSITION_DWELL:

                Users user1 = new Users();
                user1.timestamp = (String.valueOf(location.getTime()));
                user1.lat = (String.valueOf(location.getLatitude()));
                user1.lot = (String.valueOf(location.getLongitude()));
                user1.action = ("Dwell");
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MapsActivity.usersDao.insertUsers(user1);
                    }
                });
                t2.start();

                //System.out.println("lat: " + location.getLatitude() + " lot: " + location.getLongitude() + " timestamp: " + location.getTime());
                Toast.makeText(context, "GEOFENCE_TRANSITION_DWELL", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEOFENCE_TRANSITION_DWELL", "", MapsActivity.class);
                break;
                */
            case Geofence.GEOFENCE_TRANSITION_EXIT:

                Users user2 = new Users();
                user2.setTimestamp(String.valueOf(location.getTime()));
                user2.setLat(String.valueOf(location.getLatitude()));
                user2.setLot(String.valueOf(location.getLongitude()));
                user2.setAction("Exit");


                Thread t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MapsActivity.usersDao.insertUsers(user2);
                    }
                });
                t3.start();

                /*
                Thread t4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Cursor cursor = MapsActivity.usersDao.getAllUsers();
                        if (cursor.moveToFirst()) {
                            do {
                                Log.d("Cursor", "Timestamp: " + cursor.getString(0) + " Lat: " + cursor.getString(1) +
                                                         " Lot:" + cursor.getString(2) + " Action: " + cursor.getString(3));
                            } while (cursor.moveToNext());
                        }
                    }
                });
                t4.start();
                */


                Thread t5 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ContentProvider();
                    }
                });
                t5.start();


                //System.out.println(" lat: " + location.getLatitude() + " lot: " + location.getLongitude() + " timestamp: " + location.getTime());
                Toast.makeText(context, "GEOFENCE_TRANSITION_EXIT", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification("GEOFENCE_TRANSITION_EXIT", "", MapsActivity.class);

                break;
        }


    }

    public void ContentProvider() {

        Uri uri = Uri.parse("content://" + Users.AUTHORITY + "/" + Users.PATH);
        Cursor cursor = MapsActivity.resolver.query(uri,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                Log.d("Cursor", "Timestamp: " + cursor.getString(0) + " Lat: " + cursor.getString(1) +
                        " Lot:" + cursor.getString(2) + " Action: " + cursor.getString(3));
            } while (cursor.moveToNext());
        }
    }

    public void getLocation(){

    }

}