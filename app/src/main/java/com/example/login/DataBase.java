package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public static final String DatabaseName="login.db";
    public DataBase(Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE login (email TEXT primary key,password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS login");
        onCreate(sqLiteDatabase);
    }
    public void insert_data(String e,String p){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",e);
        contentValues.put("password",p);
        long result=sqLiteDatabase.insert("login",null,contentValues);
    }
    public ArrayList GetDataName(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM login",null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            arrayList.add(c.getString(0));
            c.moveToNext();
        }
        return arrayList;
    }
    public ArrayList GetDataPassword(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM login",null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            arrayList.add(c.getString(1));
            c.moveToNext();
        }
        return arrayList;
    }

}
