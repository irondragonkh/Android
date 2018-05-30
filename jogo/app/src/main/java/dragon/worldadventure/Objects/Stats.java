package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.StatsDBTable;


public class Stats {
    private long id;
    public double hp;
    public double atk;
    public double luck;
    public double defense;



    public Stats(Cursor cursor){
        this.id=cursor.getLong(cursor.getColumnIndex(StatsDBTable._ID));
        this.hp = cursor.getDouble(cursor.getColumnIndex(StatsDBTable.DB_COLUMN_HP));
        this.atk = cursor.getDouble(cursor.getColumnIndex(StatsDBTable.DB_COLUMN_ATK));
        this.luck = cursor.getDouble(cursor.getColumnIndex(StatsDBTable.DB_COLUMN_LUCK));
        this.defense = cursor.getDouble(cursor.getColumnIndex(StatsDBTable.DB_COLUMN_DEFENSE));
    }

    //construtor----------------------------------------------------------------------------------------

    public Stats(){

    }

    public Stats(double hp, double atk, double defense, double luck){
        this.id=-1;
        this.hp=hp;
        this.atk=atk;
        this.luck=luck;
        this.defense=defense;
    }
    //--------------------------------------------------------------------------------------------------

    //sets e gets--------------------------------------------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }
    //---------------------------------------------------------------------------------------------------

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();

        contentValues.put(StatsDBTable.DB_COLUMN_HP,hp);
        contentValues.put(StatsDBTable.DB_COLUMN_DEFENSE,defense);
        contentValues.put(StatsDBTable.DB_COLUMN_LUCK,luck);
        contentValues.put(StatsDBTable.DB_COLUMN_ATK,atk);
        return contentValues;
    }

}
