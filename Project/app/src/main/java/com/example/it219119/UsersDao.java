package com.example.it219119;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM USERS")
    public Cursor getAllUsers();

    @Insert
    public void insertUsers(Users...users);

}
