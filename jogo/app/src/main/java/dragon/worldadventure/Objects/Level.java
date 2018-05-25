package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.LevelDBTable;


public class Level {
    private long id;
    public int level;
    public double xp;

    public Level(Cursor cursor) {
        this.id = cursor.getLong(cursor.getColumnIndex(LevelDBTable._ID));
        this.level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
        this.xp = cursor.getDouble(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
    }

    //construtores----------------------------------------------------------------------------
    public Level(){
        //construtor vazio
    }

    public Level(int level, double xp){
        this.id = -1;
        this.level = level;
        this.xp = xp;
    }
    //----------------------------------------------------------------------------------------

    // todos os gets e sets das variaveis------------------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    //-------------------------------------------------------------------------------------------------

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();

        contentValues.put(LevelDBTable.DB_COLUMN_LEVEL,level);
        contentValues.put(LevelDBTable.DB_COLUMN_XP,xp);

        return contentValues;
    }
}
