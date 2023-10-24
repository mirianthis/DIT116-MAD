package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(MainActivity.this);

        findViewById(R.id.insert_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET = findViewById(R.id.name);
                EditText phoneET = findViewById(R.id.phone_number);
                String name = nameET.getText().toString();
                String phone = phoneET.getText().toString();

                Contact contact = new Contact(name, phone, MainActivity.this);
                try {
                    long result = contact.persist();
                    Toast.makeText(MainActivity.this, result + "", Toast.LENGTH_SHORT).show();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Contact> contacts = Contact.getAllContacts(MainActivity.this);
                Toast.makeText(MainActivity.this, "" + contacts.get(0).getUser(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.CPbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://"+DbContract.AUTHORITY+"/"+DbContract.PATH+"/6");
                Cursor cursor = resolver.query(uri,null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        Log.d("Cursor",cursor.getString(0));
                    }while(cursor.moveToNext());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}