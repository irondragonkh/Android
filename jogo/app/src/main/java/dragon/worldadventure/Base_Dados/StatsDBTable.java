package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.Hero;

public class StatsDBTable implements BaseColumns {
    public static final String TABLE_NAME="STATS";
    public static final String DB_COLUMN_HP="HP";
    public static final String DB_COLUMN_ATK="ATK";
    public static final String DB_COLUMN_LUCK="LUCK";
    public static final String DB_COLUMN_DEFENSE="DEFENSE";
    public static final String DB_COLUMN_CURRENTXP="CURRENTXP";
    public static final String DB_COLUMN_ID_USERHERO="USERHEROID";

    public static final String[] ALL_FIELDS = {
            _ID,
            DB_COLUMN_HP,
            DB_COLUMN_ATK,
            DB_COLUMN_DEFENSE,
            DB_COLUMN_LUCK,
            DB_COLUMN_CURRENTXP,
            DB_COLUMN_ID_USERHERO

    };
    private SQLiteDatabase db;

    public StatsDBTable(SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DB_COLUMN_HP + " INTEGER , "
                + DB_COLUMN_ATK + " INTEGER , "
                + DB_COLUMN_DEFENSE + " INTEGER , "
                + DB_COLUMN_LUCK + " INTEGER , "
                + DB_COLUMN_CURRENTXP + " INTEGER , "
                + DB_COLUMN_ID_USERHERO + " INTEGER,  "
                + " FOREIGN KEY ( " + DB_COLUMN_ID_USERHERO +" ) REFERENCES " + UserHeroesDBTable.TABLE_NAME + " ( "+ UserHeroesDBTable._ID +" ) "
                +" ) ");
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String orderBy){
        return db.query(TABLE_NAME,projection,selection,selectionArgs,null,null,orderBy);
    }
    public Cursor querySingle(String[] projection,String id){
        return query(projection,DB_COLUMN_ID_USERHERO + "=?",new String[]{id},null);
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

    }
}

