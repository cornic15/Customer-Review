package com.bhcc.dehackathon_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "customerdata";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_STAR_RATING = "[How was your experience in the store?]";
    public static final String COLUMN_QUESTION1 = "[Did you find our staff helpful and courteous?]";
    public static final String COLUMN_QUESTION2 = "[Were you served promptly?]";
    public static final String COLUMN_QUESTION3 = "[Are our products/services priced appropriately?]";
    public static final String COLUMN_QUESTION4 = "[Would you recommend this business to a friend?]";
    public static final String COLUMN_TELL_US = "[Tell us about]";



    public DataBaseHelper(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STAR_RATING + " TEXT, " +
                COLUMN_QUESTION1 + " TEXT, " + COLUMN_QUESTION2 + " TEXT, " + COLUMN_QUESTION3 + " TEXT, " + COLUMN_QUESTION4 + " TEXT, " + COLUMN_TELL_US + " TEXT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STAR_RATING, customerModel.getStar_rating());
        cv.put(COLUMN_QUESTION1, customerModel.getQuestion_1());
        cv.put(COLUMN_QUESTION2, customerModel.getQuestion_2());
        cv.put(COLUMN_QUESTION3, customerModel.getQuestion_3());
        cv.put(COLUMN_QUESTION4, customerModel.getQuestion_4());
        cv.put(COLUMN_TELL_US, customerModel.getTell_us_about());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        return insert != -1;
    }
}
