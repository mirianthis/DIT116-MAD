package com.example.sqliteapplication;

public class DbContract {
    static public String DB_NAME = "CONTACTS_DB";
    static public int DB_VERSION = 1;
    static public String TABLE_NAME = "CONTACTS";
    static public String FIELD_1 = "NAME";
    static public String FIELD_2 = "PHONE_NUMBER";
    static public String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ('"+FIELD_1+"' TEXT, '"+FIELD_2+"' TEXT);";
    static public String AUTHORITY = "com.example.sqliteapplication";
    static public String PATH = DbContract.TABLE_NAME;
}
