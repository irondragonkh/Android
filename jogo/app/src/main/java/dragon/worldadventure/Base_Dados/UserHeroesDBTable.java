package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.Stats;
import dragon.worldadventure.Objects.UserHero;

public class UserHeroesDBTable implements BaseColumns {
    public static final String TABLE_NAME = "USERHERO";
    public static final String DB_COLUMN_USERHERONAME = "USERHERONAME";
    public static final String DB_COLUMN__ID_HERO = "ID_HERO" ;
    public static final String DB_COLUMN_ID_USER = "ID_USER";
    public static final String DB_COLUMN_ID_LEVEL = "LEVEL";
    public static final String DB_COLUMN_TAB = "TAB";
    public static final String DB_COLUMN_POINTS="POINTS";


    public static final String[] ALL_FIELDs = {
        _ID,
        DB_COLUMN_USERHERONAME,
        DB_COLUMN__ID_HERO,
        DB_COLUMN_ID_USER,
        DB_COLUMN_ID_LEVEL,
        DB_COLUMN_TAB,
        DB_COLUMN_POINTS
    };

    private SQLiteDatabase db;

    public UserHeroesDBTable (SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME
                       + " ( "
                       + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                       + DB_COLUMN_USERHERONAME + " TEXT, "
                       + DB_COLUMN_ID_LEVEL + " INTEGER NOT NULL, "
                       + DB_COLUMN__ID_HERO + " INTEGER NOT NULL, "
                       + DB_COLUMN_ID_USER + " INTEGER NOT NULL, "
                       + DB_COLUMN_POINTS + " INTEGER NOT NULL, "
                       + DB_COLUMN_TAB + " INTEGER NOT NULL, "
                       + " FOREIGN KEY ( " + DB_COLUMN__ID_HERO +" ) REFERENCES " + HeroDBTable.TABLE_NAME + "( " + HeroDBTable._ID + " ), "
                       + " FOREIGN KEY ( " + DB_COLUMN_ID_USER + " ) REFERENCES " + UserDBTable.TABLE_NAME + " ( " + UserDBTable._ID + "), "
                       + " FOREIGN KEY ( " + DB_COLUMN_ID_LEVEL +" ) REFERENCES " + LevelDBTable.TABLE_NAME + " ( "+ LevelDBTable._ID +" ) "
                        + " ) "
        );
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String orderBy){
        return db.query(TABLE_NAME,projection,selection,selectionArgs,null,null,orderBy);
    }
    public Cursor querySingle(String[] projection,String id){
        return query(projection,_ID + "=?",new String[]{id},null);
    }
    public Cursor querySingleUser(String[] projection,String id){
        return query(projection,DB_COLUMN_ID_USER + "=?",new String[]{id},null);
    }

    public Cursor queryCheckTab(String[] projection,String id,String tab){
        return query(projection,DB_COLUMN_ID_USER + "=? AND "+DB_COLUMN_TAB + "=?",new String[]{id,tab},null);
    }



    //CRUD

    public int delete(String id){
        return db.delete(TABLE_NAME,_ID + "=?",new String[]{id});
    }

    public long insert(ContentValues contentValues){
        return db.insert(TABLE_NAME,null,contentValues);
    }


    public int update(ContentValues contentValues, String id){
        return db.update(TABLE_NAME,contentValues,_ID + "=?",new String[]{id});
    }

    public void seed(){
    }


}

