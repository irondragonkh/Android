package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.HeroDBTable;


public class Hero {
    private long id;
    public String heroname;
    public String classe;
    public double hp;
    public double atk;
    public double luck;
    public double defense;



    public Hero(Cursor cursor){
        this.id=cursor.getLong(cursor.getColumnIndex(HeroDBTable._ID));
        this.hp = cursor.getDouble(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_HP));
        this.atk = cursor.getDouble(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_ATK));
        this.luck = cursor.getDouble(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_LUCK));
        this.defense = cursor.getDouble(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_DEFENSE));
        this.heroname = cursor.getString(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_NAME));
        this.classe = cursor.getString(cursor.getColumnIndex(HeroDBTable.DB_COLUMN_CLASS));
    }

    //construtor----------------------------------------------------------------------------------------

    public Hero(){

    }

    public Hero(String heroname, String classe, double hp, double atk, double defense, double luck){
        this.id=-1;
        this.heroname=heroname;
        this.classe=classe;
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

    public String getHeroname() {
        return heroname;
    }

    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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

        contentValues.put(HeroDBTable.DB_COLUMN_NAME,heroname);
        contentValues.put(HeroDBTable.DB_COLUMN_CLASS,classe);
        contentValues.put(HeroDBTable.DB_COLUMN_HP,hp);
        contentValues.put(HeroDBTable.DB_COLUMN_DEFENSE,defense);
        contentValues.put(HeroDBTable.DB_COLUMN_LUCK,luck);
        contentValues.put(HeroDBTable.DB_COLUMN_ATK,atk);
        return contentValues;
    }

}
