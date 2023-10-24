package com.example.it219119;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteQuery;

public class UsersProvider extends ContentProvider {

    private static UriMatcher uriMatcher;
    private static final String AUTHORITY = "com.example.it219119";
    public static final String CONTENT_URI = "content://"+AUTHORITY;
    public static UsersDatabase database;
    public static UsersDao usersDao;


    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Users.AUTHORITY,Users.PATH,1);
    }


    @Override
    public boolean onCreate() {
        database = Room.databaseBuilder(getContext(),UsersDatabase.class,"USERS_DB").build();
        usersDao = database.UsersDao();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor result = null;

        switch (uriMatcher.match(uri)) {
            case 1:
                //select * from USERS
                result = usersDao.getAllUsers();
                break;
        }
        return result;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
