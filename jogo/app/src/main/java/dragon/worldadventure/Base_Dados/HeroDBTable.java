package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.Hero;

public class HeroDBTable implements BaseColumns {
    public static final String TABLE_NAME=" HERO ";
    public static final String DB_COLUMN_NAME=" HERONAME ";
    public static final String DB_COLUMN_CLASS=" CLASS ";
    public static final String DB_COLUMN_HP=" HP ";
    public static final String DB_COLUMN_ATK=" ATK ";
    public static final String DB_COLUMN_LUCK=" LUCK ";
    public static final String DB_COLUMN_DEFENSE=" DEFENSE ";

    public static final String[] ALL_FIELDS = {
            _ID,
            DB_COLUMN_NAME,
            DB_COLUMN_CLASS,
            DB_COLUMN_HP,
            DB_COLUMN_ATK,
            DB_COLUMN_DEFENSE,
            DB_COLUMN_LUCK

    };
    private SQLiteDatabase db;

    public HeroDBTable(SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DB_COLUMN_NAME + " TEXT NOT NULL, "
                + DB_COLUMN_CLASS + " TEXT NOT NULL, "
                + DB_COLUMN_HP + " INTEGER NOT NULL, "
                + DB_COLUMN_ATK + " INTEGER NOT NULL, "
                + DB_COLUMN_DEFENSE + " INTEGER NOT NULL, "
                + DB_COLUMN_LUCK + " INTEGER NOT NULL "
                +")");
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
        insert(new Hero("Elalynn","Warrior",5,5,5,3).getContentValues());
        insert(new Hero("Ygqora","Mage",3,7,2,3).getContentValues());
        insert(new Hero("Duncan","Paladin",7,3,7,3).getContentValues());
        insert(new Hero("Faryil","Archer",3,7,3,7).getContentValues());
        insert(new Hero("Areradon","Priest",7,3,7,7).getContentValues());
    }
}

