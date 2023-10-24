package com.example.daoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactsDatabase database = Room.databaseBuilder(MainActivity.this,ContactsDatabase.class,"CONTACTS_DB").build();
        ContactsDao contactsDao = database.ContactsDao();
        findViewById(R.id.buttonInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idET = findViewById(R.id.editTextTextID);
                EditText nameET = findViewById(R.id.editTextName);
                EditText phoneET = findViewById(R.id.editTextPhone);

                Contact contact = new Contact();
                contact.id = Integer.parseInt(idET.getText().toString());
                contact.name = nameET.getText().toString();
                contact.phone_number = phoneET.getText().toString();

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        contactsDao.insertContacts(contact);
                    }
                });
                t.start();
            }
        });

        findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Contact> contacts = contactsDao.getAllContacts();
                        Log.d("DAO",contacts.toString());
                    }
                });
                t.start();


            }
        });
    }
}