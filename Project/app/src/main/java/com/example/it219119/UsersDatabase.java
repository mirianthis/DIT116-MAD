package com.example.it219119;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class},version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UsersDao UsersDao();
}


