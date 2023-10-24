package com.example.projectsecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String AUTHORITY = "com.example.it219119";
    private static final String CONTENT_URI = "content://"+AUTHORITY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver = getContentResolver();

        findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                Uri uri = Uri.parse(CONTENT_URI+"/USERS");
                Cursor cursor = resolver.query(uri,null,null,null,null);


                if (cursor.moveToFirst()){
                    do {
                        Log.d("Cursor", "Timestamp: " + cursor.getString(0) + " Lat: " + cursor.getString(1) +
                             " Lot:" + cursor.getString(2) + " Action: " + cursor.getString(3));
                        Toast.makeText(MainActivity.this, cursor.getString(1), Toast.LENGTH_SHORT).show();
                    }while (cursor.moveToNext());
                }

            }
        });
    }
    }