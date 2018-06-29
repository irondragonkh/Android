package dragon.worldadventure.Base_Dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import dragon.worldadventure.Objects.Villan;

public class VillanDBTable implements BaseColumns {
    public static final String TABLE_NAME="VILLAN";
    public static final String DB_COLUMN_NAME="VILLANNAME";
    public static final String DB_COLUMN_HP="HP";
    public static final String DB_COLUMN_ATK="ATK";
    public static final String DB_COLUMN_LUCK="LUCK";
    public static final String DB_COLUMN_DEFENSE="DEFENSE";

    public static final String[] ALL_FIELDS = {
            _ID,
            DB_COLUMN_NAME,
            DB_COLUMN_HP,
            DB_COLUMN_ATK,
            DB_COLUMN_DEFENSE,
            DB_COLUMN_LUCK

    };
    private SQLiteDatabase db;

    public VillanDBTable(SQLiteDatabase db){this.db=db;}

    public void create(){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DB_COLUMN_NAME + " TEXT NOT NULL, "
                + DB_COLUMN_HP + " INTEGER NOT NULL, "
                + DB_COLUMN_ATK + " INTEGER NOT NULL, "
                + DB_COLUMN_DEFENSE + " INTEGER NOT NULL, "
                + DB_COLUMN_LUCK + " INTEGER NOT NULL "
                +")");
    }
    public Cursor query (String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
        return cursor;
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String orderBy){
        return db.query(TABLE_NAME,projection,selection,selectionArgs,null,null,orderBy);
    }
    public Cursor querySingle(String[] projection,String id){
        return query(projection,_ID + "=?",new String[]{id},null);
    }

    public static Villan getCurrentVillanFromCursor(Cursor cursor) {
        final int posId = cursor.getColumnIndex(_ID);
        final int posName = cursor.getColumnIndex(DB_COLUMN_NAME);
        final int posHP = cursor.getColumnIndex(DB_COLUMN_HP);
        final int posATK = cursor.getColumnIndex(DB_COLUMN_ATK);
        final int posDEF = cursor.getColumnIndex(DB_COLUMN_DEFENSE);
        final int posLuck = cursor.getColumnIndex(DB_COLUMN_LUCK);

        Villan villan = new Villan();

        villan.setId(cursor.getLong(posId));
        villan.setVillanname(cursor.getString(posName));
        villan.setHp(cursor.getDouble(posHP));
        villan.setAtk(cursor.getDouble(posATK));
        villan.setDefense(cursor.getDouble(posDEF));
        villan.setLuck(cursor.getDouble(posLuck));

        return villan;
    }

    //CRUD

    public int delete(String id){
        return db.delete(TABLE_NAME,_ID + "=?",new String[]{id});
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }

    public long insert(ContentValues contentValues){
        return db.insert(TABLE_NAME,null,contentValues);
    }

    //ponho aqui o update apesar de que esta tabela nao pode fazer updates so insert e delete
    public int update(ContentValues contentValues, String id){
        return db.update(TABLE_NAME,contentValues,_ID + "=?",new String[]{id});
    }
    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }


    public void seed(){
        insert(new Villan("Whitewash",5,5,5,3).getContentValues());
        insert(new Villan("Mutilator",5,11,2,3).getContentValues());
        insert(new Villan("Genesis",7,3,7,3).getContentValues());
        insert(new Villan("Longshot",3,7,5,7).getContentValues());
        insert(new Villan("Flood",7,3,7,7).getContentValues());
    }
}

