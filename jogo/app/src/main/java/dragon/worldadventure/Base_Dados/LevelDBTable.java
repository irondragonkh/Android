package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.Level;


public class LevelDBTable implements BaseColumns {
    public static final String TABLE_NAME=" Level ";
    public static final String DB_COLUMN_LEVEL=" Level ";
    public static final String DB_COLUMN_XP=" XP ";

    public static final String[] ALL_FIELDS = {
            _ID,
            DB_COLUMN_LEVEL,
            DB_COLUMN_XP
    };
    private SQLiteDatabase db;

    public LevelDBTable(SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DB_COLUMN_LEVEL + " INTEGER NOT NULL, " + DB_COLUMN_XP + " INTEGER NOT NULL " +")");
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String orderBy){
        return db.query(TABLE_NAME,projection,selection,selectionArgs,null,null,orderBy);
    }
    public Cursor querySingle(String[] projection,String id){
        return query(projection,_ID + "=?",new String[]{id},null);
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
        insert(new Level(1,50).getContentValues());
        insert(new Level(2,80).getContentValues());
        insert(new Level(3,110).getContentValues());
        insert(new Level(4,140).getContentValues());
        insert(new Level(5,170).getContentValues());
        insert(new Level(6,220).getContentValues());
        insert(new Level(7,270).getContentValues());
        insert(new Level(8,320).getContentValues());
        insert(new Level(9,370).getContentValues());
        insert(new Level(10,460).getContentValues());
        insert(new Level(11,550).getContentValues());
        insert(new Level(12,640).getContentValues());
        insert(new Level(13,730).getContentValues());
        insert(new Level(14,820).getContentValues());
        insert(new Level(15,910).getContentValues());
        insert(new Level(16,1060).getContentValues());
        insert(new Level(17,1210).getContentValues());
        insert(new Level(18,1360).getContentValues());
        insert(new Level(19,1510).getContentValues());
        insert(new Level(20,1660).getContentValues());
    }
}

