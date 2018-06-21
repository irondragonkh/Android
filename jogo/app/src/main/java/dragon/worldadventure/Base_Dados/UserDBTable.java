package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.User;

public class UserDBTable implements BaseColumns {
    public static final String TABLE_NAME="USER";
    public static final String DB_COLUMN_USERNAME="USERNAME";
    public static final String DB_COLUMN_PASSWORD="PASSWORD";

    public static final String[] ALL_FIELDS = {
            _ID,
            DB_COLUMN_USERNAME,
            DB_COLUMN_PASSWORD
    };
    private SQLiteDatabase db;

    public UserDBTable(SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DB_COLUMN_USERNAME + " TEXT NOT NULL, " + DB_COLUMN_PASSWORD + " TEXT NOT NULL " +")");
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String orderBy){
        return db.query(TABLE_NAME,projection,selection,selectionArgs,null,null,orderBy);
    }
    public Cursor querySingle(String [] projection, String username) {
        return query(projection, DB_COLUMN_USERNAME + "=?", new String[]{username}, null);
    }

    public Cursor querySinglePassword(String [] projection, String password) {
        return query(projection, DB_COLUMN_USERNAME + "=?", new String[]{password}, null);
    }

    //CRUD

    public int delete(String id){
        return db.delete(TABLE_NAME,_ID + "=?",new String[]{id});
    }

    public long insert(ContentValues contentValues){
        return db.insert(TABLE_NAME,null,contentValues);
    }

    //ponho aqui o update apesar de que esta tabela nao pode fazer updates so insert e delete
    public int update(ContentValues contentValues, String id){
        return db.update(TABLE_NAME,contentValues,_ID + "=?",new String[]{id});
    }

    public void seed(){
        insert(new User("manzarra","qwerty").getContentValues());
    }
}

