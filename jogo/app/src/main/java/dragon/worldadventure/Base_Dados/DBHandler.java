package dragon.worldadventure.Base_Dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

   public static final int DATABASE_VERSION=1;

    public static final String DATABASE_NAME="WorldAdventure.db";

   public static final boolean TEST_VERSION=true;

    public DBHandler(Context context)
    {super(context,DATABASE_NAME,null, DATABASE_VERSION);}



    @Override
    public void onCreate(SQLiteDatabase db) {
        final UserDBTable userDBTable = new UserDBTable(db);
        final HeroDBTable heroDBTable = new HeroDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);
        final WeaponDBTable weaponDBTable = new WeaponDBTable(db);
        final ArmorDBTable armorDBTable = new ArmorDBTable(db);
        final UserHeroesDBTable userHeroesDBTable = new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);
        final VillanDBTable villanDBTable = new VillanDBTable(db);
        userDBTable.create();
        heroDBTable.create();
        levelDBTable.create();
        weaponDBTable.create();
        armorDBTable.create();
        userHeroesDBTable.create();
        statsDBTable.create();
        villanDBTable.create();
        villanDBTable.seed();
        heroDBTable.seed();
        levelDBTable.seed();



    }



    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            new UserDBTable(db).create();
            new HeroDBTable(db).create();
            new LevelDBTable(db).create();
            new WeaponDBTable(db).create();
            new ArmorDBTable(db).create();
            new UserHeroesDBTable(db).create();
            new StatsDBTable(db).create();
            new VillanDBTable(db).create();
        }
    }
}
