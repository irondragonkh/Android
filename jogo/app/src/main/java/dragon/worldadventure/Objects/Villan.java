package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.VillanDBTable;


public class Villan {
    private long id;
    public String villanname;
    public double hp;
    public double atk;
    public double luck;
    public double defense;



    public Villan(Cursor cursor){
        this.id=cursor.getLong(cursor.getColumnIndex(VillanDBTable._ID));
        this.hp = cursor.getDouble(cursor.getColumnIndex(VillanDBTable.DB_COLUMN_HP));
        this.atk = cursor.getDouble(cursor.getColumnIndex(VillanDBTable.DB_COLUMN_ATK));
        this.luck = cursor.getDouble(cursor.getColumnIndex(VillanDBTable.DB_COLUMN_LUCK));
        this.defense = cursor.getDouble(cursor.getColumnIndex(VillanDBTable.DB_COLUMN_DEFENSE));
        this.villanname = cursor.getString(cursor.getColumnIndex(VillanDBTable.DB_COLUMN_NAME));
    }

    //construtor----------------------------------------------------------------------------------------

    public Villan(){

    }

    public Villan(String villanname, double hp, double atk, double defense, double luck){
        this.id=-1;
        this.villanname=villanname;
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

    public String getVillanname() {
        return villanname;
    }

    public void setVillanname(String villanname) {
        this.villanname = villanname;
    }

    //---------------------------------------------------------------------------------------------------

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();

        contentValues.put(VillanDBTable.DB_COLUMN_NAME,villanname);
        contentValues.put(VillanDBTable.DB_COLUMN_HP,hp);
        contentValues.put(VillanDBTable.DB_COLUMN_DEFENSE,defense);
        contentValues.put(VillanDBTable.DB_COLUMN_LUCK,luck);
        contentValues.put(VillanDBTable.DB_COLUMN_ATK,atk);
        return contentValues;
    }

}
