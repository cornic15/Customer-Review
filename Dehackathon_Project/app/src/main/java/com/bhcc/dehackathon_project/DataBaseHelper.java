package com.bhcc.dehackathon_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_AGE_RANGE = "AGE_RANGE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SERVICE_CAT = "SERVICE_CAT";
    public static final String COLUMN_FEEDBACK = "FEEDBACK";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_AGE_RANGE + " TEXT, " +
                COLUMN_SERVICE_CAT + " TEXT, " + COLUMN_FEEDBACK + " TEXT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_AGE_RANGE, customerModel.getAge_range());
        cv.put(COLUMN_SERVICE_CAT, customerModel.getService_cat());
        cv.put(COLUMN_FEEDBACK, customerModel.getFeedback());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
