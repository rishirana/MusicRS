package info.rishi.musicrs;

import java.util.ArrayList;
import java.util.List;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    String password;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String TABLE_REGISTER = "register";
    public static final String COL1 = "id";
    public static final String COL2 = "name";
    public static final String COL3 = "phone";
    public static final String COL4 = "password";
    public static final String CREATE_TABLE = "CREATE_TABLE" + TABLE_REGISTER + "(" +
            COL1 + "INTEGER PRIMARY KEY AUTOINCREMENT" + COL2 + "TEXT" +
            COL3 + "TEXT" + COL4 + "TEXT" + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_REGISTER);
        onCreate(db);

    }

    void addregister(Registerdata registerdata) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1, registerdata.getName());
        values.put(COL2, registerdata.getPhone());
        values.put(COL3, registerdata.getPassword());

        //inserting rows
        db.insert(TABLE_REGISTER, null, values);
        db.close();

    }

    //get register
    String getregister(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery = "SELECT * FROM TABLE_REGISTER";
        Cursor cursor = db.query(TABLE_REGISTER, null, "phone=?", new String[]
                {username}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "not exist";

        } else if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            password=cursor.getString(cursor.getColumnIndex(COL4));
            cursor.close();
        }
        return password;
    }

    public String getDatabaseName(){
        return DATABASE_NAME;

    }
    public static String getKeyId(){
        return COL1;

    }

    public static String  getTableContacts(){
        return TABLE_REGISTER;

    }
    public static int getDatabaseVersion(){
        return DATABASE_VERSION;
    }

}
