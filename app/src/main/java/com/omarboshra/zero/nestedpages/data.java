package com.omarboshra.zero.nestedpages;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zero on 23/03/2017.
 */
public class data extends SQLiteOpenHelper {

    public static final int version = 1;
    public static final String database_name ="notes data";
    public static final String Table2 ="Table2";
    public static final String title2 ="title2";
    public static final String data2 ="data2";
    public static final String usageid ="usageid";
    public static final String formats ="formats";
    public static final String tagid  ="id";
    public static final String id2  ="id2";
    public static final String serial2 = "serial2";
    public static final String Table3 = "Table3";
    public static final String serial = "serial";
    public static final String color = "color";
    public static final String type = "type";
    public static final String trash = "trash";

    public data(Context context) {
        super(context, database_name,null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String t2 = "CREATE TABLE " +Table2 + "("+
                title2 +" TEXT,"+
                formats +" TEXT,"+
                trash +" TEXT,"+
                id2 +" TEXT NOT NULL DEFAULT '',"+
                tagid +" INTEGER,"+
                usageid +" INTEGER,"+
                color +" INTEGER,"+
                type +" INTEGER,"+
                serial +" INTEGER PRIMARY KEY,"+
                data2 +" TEXT "+")";
        final String t3 = "CREATE TABLE " +Table3 + "("+
               serial2 +" TEXT "+")";

        db.execSQL(t2);
        db.execSQL(t3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Table1");
        onCreate(db);
    }
}

