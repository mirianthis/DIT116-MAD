package com.example.it219119;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USERS")
public class Users {


    public static final String TABLE_NAME = "USERS";
    public static final String AUTHORITY = "com.example.it219119";
    public static final String PATH = TABLE_NAME;



    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "TIMESTAMP")
    public String timestamp;

    @ColumnInfo(name = "LAT")
    public String lat;

    @ColumnInfo(name = "LOT")
    public String lot;

    @ColumnInfo(name = "ACTION")
    public String action;






    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}