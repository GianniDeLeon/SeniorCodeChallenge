package com.leonlab.senircodechallenge.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import com.leonlab.senircodechallenge.model.Personaje;

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="DBXumak";
    private static final String CREATETABLE = "CREATE TABLE personaje (char_id INTEGER PRIMARY KEY, name TEXT)";
    private static  final int DB_VERSION = 1;

    public SqliteHelper(@Nullable Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATETABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personaje");
        db.execSQL(CREATETABLE);
    }

    public void addPersonaje(int char_id,String name){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            String query = "INSERT INTO personaje VALUES ('"+char_id+"','"+name+"')";
            try {
                db.execSQL(query);
                db.close();
            }catch (SQLiteConstraintException e){
                Log.i("SQLite",e.toString());
            }
            db.close();
        }
    }

    public void removePersonaje(int char_id){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            String query = "DELETE FROM personaje WHERE char_id = '"+char_id+"'";
            try {
                db.execSQL(query);
                db.close();
            }catch (SQLiteConstraintException e){
                Log.i("SQLite",e.toString());
            }
            db.close();
        }
    }

    public boolean getCharId(int char_id){
        SQLiteDatabase db = getReadableDatabase();
        if (db != null){
            String query = "SELECT * FROM personaje WHERE char_id = ?";
            Cursor cursor = db.rawQuery(query,new String[]{char_id+""});
            boolean favorito = cursor.moveToFirst();
            db.close();
            return favorito;
        }
        return false;
    }
}
