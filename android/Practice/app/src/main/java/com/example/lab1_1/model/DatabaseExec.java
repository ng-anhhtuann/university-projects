package com.example.lab1_1.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseExec extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ShirtOrders.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "orders";
    private static final String COL_ID = "id";
    private static final String COL_FULL_NAME = "full_name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PHONE = "phone";
    private static final String COL_ADDRESS = "address";
    private static final String COL_SIZE = "size";
    private static final String COL_COLOR = "color";
    private static final String COL_QUANTITY = "quantity";
    private static final String COL_INSTRUCTIONS = "instructions";

    public DatabaseExec(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FULL_NAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PHONE + " TEXT, " +
                COL_ADDRESS + " TEXT, " +
                COL_SIZE + " TEXT, " +
                COL_COLOR + " TEXT, " +
                COL_QUANTITY + " INTEGER, " +
                COL_INSTRUCTIONS + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOrder(String fullName, String email, String phone, String address, String size, String color, int quantity, String instructions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FULL_NAME, fullName);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PHONE, phone);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_SIZE, size);
        contentValues.put(COL_COLOR, color);
        contentValues.put(COL_QUANTITY, quantity);
        contentValues.put(COL_INSTRUCTIONS, instructions);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getFirstOrder() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " LIMIT 1", null);
    }
}
