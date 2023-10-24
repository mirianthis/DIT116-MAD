package com.example.daoapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao {
    @Query("SELECT * FROM CONTACTS")
    public List<Contact> getAllContacts();

    @Query("SELECT * FROM CONTACTS WHERE NAME LIKE :name")
    public Contact getPhoneByName(String name);

    @Insert
    public void insertContacts(Contact...contacts);
}
