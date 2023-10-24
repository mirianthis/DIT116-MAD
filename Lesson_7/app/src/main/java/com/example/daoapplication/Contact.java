package com.example.daoapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CONTACTS")
public class Contact {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "NAME")
    public String name;

    @ColumnInfo(name = "PHONE_NUMBER")
    public String phone_number;
}
