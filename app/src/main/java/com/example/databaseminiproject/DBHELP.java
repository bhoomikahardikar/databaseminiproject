package com.example.databaseminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHELP extends SQLiteOpenHelper {
    public DBHELP(Context context) {
        super(context, "user.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table UserDetails(Id Text primary key, UserName Text,Phone_number Text, UserAge Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists UserDetails");
    }

    public void insertdata(User user) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("Id", user.getId());
            cv.put("UserName", user.getName());
            cv.put("Phone_number", user.getUPhone());
            cv.put("UserAge", user.getAge());
            database.insert("UserDetails",null,cv);
        }
        catch (Exception E){

        }
    }

    public void deletedata(User user) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery("Select * from UserDetails where UserName= ?", new String[]{user.getName()});
            if (cursor.getCount() > 0) {
                database.delete("UserDetails", "UserName=?", new String[]{user.getName()});
            }
        }
        catch (Exception E){

        }

    }

    public void updatedata(User user) {
        try{
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Phone_number", user.getUPhone());
        cv.put("UserAge", user.getAge());

        Cursor cursor = database.rawQuery("Select * from UserDetails where UserName = ?", new String[]{user.getName()});
        if (cursor.getCount() > 0)
            database.update("UserDetails", cv, "UserName=?", new String[]{user.getName()});

        }
        catch (Exception E){

        }
    }
    public Cursor getdata() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from UserDetails",null);
        return cursor;

    }
}
