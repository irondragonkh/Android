package dragon.worldadventure.Class_Interface;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.HeroDBTable;
import dragon.worldadventure.Base_Dados.StatsDBTable;
import dragon.worldadventure.Base_Dados.UserDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Class_Interface.CreateHeroTabs.Tab1;
import dragon.worldadventure.Class_Interface.CreateHeroTabs.Tab2;
import dragon.worldadventure.Class_Interface.CreateHeroTabs.Tab3;
import dragon.worldadventure.Class_Interface.CreateHeroTabs.Tab4;
import dragon.worldadventure.Class_Interface.CreateHeroTabs.Tab5;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Hero;
import dragon.worldadventure.Objects.Level;
import dragon.worldadventure.Objects.Stats;
import dragon.worldadventure.Objects.User;
import dragon.worldadventure.Objects.UserHero;
import dragon.worldadventure.R;


/**
 * Aqui criasse um heroi na tab correspondente
 *
 * AppDatas utilizadas
 *  -herotab
 *  -userhero
 *  -obejcto singular stats(nao e o stats1,2,ou 3) usado apenas para se criar o campo na tabela stats
 *  -warrior,mage,priest,archer,paladin
 *
 *
 *
 *
 *  Criar valores na tabela stats, criar valores na tabela userhero
 */
public class CreateHero extends AppCompatActivity {

    final DBHandler dbHandler=new DBHandler(this);
    public Cursor cursor;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hero);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final HeroDBTable heroDBTable= new HeroDBTable(db);


        cursor=heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+1);
        if(cursor.moveToNext()){
            AppData.warrior = new Hero(cursor);
        }
        cursor=heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+2);
        if(cursor.moveToNext()){
            AppData.mage = new Hero(cursor);
        }
        cursor=heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+3);
        if(cursor.moveToNext()){
            AppData.paladin = new Hero(cursor);
        }
        cursor=heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+4);
        if(cursor.moveToNext()){
            AppData.archer = new Hero(cursor);
        }
        cursor=heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+5);
        if(cursor.moveToNext()){
            AppData.priest = new Hero(cursor);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_hero, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CreateHero1(View view) {
        //warrior

        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);

        if(AppData.createtab1){
            AppData.userHero1 = new UserHero();
            AppData.userHero1.setUserheroname(AppData.warrior.getHeroname());
            AppData.userHero1.setHeroid(AppData.warrior.getId());
            AppData.userHero1.setUserid(AppData.user.getId());
            AppData.userHero1.setLevelid(1);
            AppData.userHero1.setTab(1);
            userHeroesDBTable.insert(AppData.userHero1.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.warrior.getHp(),AppData.warrior.getAtk(),AppData.warrior.getDefense(),AppData.warrior.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab1=false;


        }else if(AppData.createtab2){
            AppData.userHero2 = new UserHero();
            AppData.userHero2.setUserheroname(AppData.warrior.getHeroname());
            AppData.userHero2.setHeroid(AppData.warrior.getId());
            AppData.userHero2.setUserid(AppData.user.getId());
            AppData.userHero2.setLevelid(1);
            AppData.userHero2.setTab(2);
            userHeroesDBTable.insert(AppData.userHero2.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.warrior.getHp(),AppData.warrior.getAtk(),AppData.warrior.getDefense(),AppData.warrior.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab2=false;

        }else{
            AppData.userHero3 = new UserHero();
            AppData.userHero3.setUserheroname(AppData.warrior.getHeroname());
            AppData.userHero3.setHeroid(AppData.warrior.getId());
            AppData.userHero3.setUserid(AppData.user.getId());
            AppData.userHero3.setLevelid(1);
            AppData.userHero3.setTab(3);
            userHeroesDBTable.insert(AppData.userHero3.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.warrior.getHp(),AppData.warrior.getAtk(),AppData.warrior.getDefense(),AppData.warrior.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab3=false;

        }

        Intent intent = new Intent(this, HeroSelection.class);
        startActivity(intent);
        finish();
    }
    public void CreateHero2(View view) {
        //mage
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);

        if(AppData.createtab1){
            AppData.userHero1 = new UserHero();
            AppData.userHero1.setUserheroname(AppData.mage.getHeroname());
            AppData.userHero1.setHeroid(AppData.mage.getId());
            AppData.userHero1.setUserid(AppData.user.getId());
            AppData.userHero1.setLevelid(1);
            AppData.userHero1.setTab(1);
            userHeroesDBTable.insert(AppData.userHero1.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.mage.getHp(),AppData.mage.getAtk(),AppData.mage.getDefense(),AppData.mage.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab1=false;


        }else if(AppData.createtab2){
            AppData.userHero2 = new UserHero();
            AppData.userHero2.setUserheroname(AppData.mage.getHeroname());
            AppData.userHero2.setHeroid(AppData.mage.getId());
            AppData.userHero2.setUserid(AppData.user.getId());
            AppData.userHero2.setLevelid(1);
            AppData.userHero2.setTab(2);
            userHeroesDBTable.insert(AppData.userHero2.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.mage.getHp(),AppData.mage.getAtk(),AppData.mage.getDefense(),AppData.mage.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab2=false;

        }else{
            AppData.userHero3 = new UserHero();
            AppData.userHero3.setUserheroname(AppData.mage.getHeroname());
            AppData.userHero3.setHeroid(AppData.mage.getId());
            AppData.userHero3.setUserid(AppData.user.getId());
            AppData.userHero3.setLevelid(1);
            AppData.userHero3.setTab(3);
            userHeroesDBTable.insert(AppData.userHero3.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.mage.getHp(),AppData.mage.getAtk(),AppData.mage.getDefense(),AppData.mage.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab3=false;

        }

        Intent intent = new Intent(this, HeroSelection.class);
        startActivity(intent);
        finish();
    }
    public void CreateHero3(View view) {
        //paladin
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);

        if(AppData.createtab1){
            AppData.userHero1 = new UserHero();
            AppData.userHero1.setUserheroname(AppData.paladin.getHeroname());
            AppData.userHero1.setHeroid(AppData.paladin.getId());
            AppData.userHero1.setUserid(AppData.user.getId());
            AppData.userHero1.setLevelid(1);
            AppData.userHero1.setTab(1);
            userHeroesDBTable.insert(AppData.userHero1.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.paladin.getHp(),AppData.paladin.getAtk(),AppData.paladin.getDefense(),AppData.paladin.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab1=false;


        }else if(AppData.createtab2){
            AppData.userHero2 = new UserHero();
            AppData.userHero2.setUserheroname(AppData.paladin.getHeroname());
            AppData.userHero2.setHeroid(AppData.paladin.getId());
            AppData.userHero2.setUserid(AppData.user.getId());
            AppData.userHero2.setLevelid(1);
            AppData.userHero2.setTab(2);
            userHeroesDBTable.insert(AppData.userHero2.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.paladin.getHp(),AppData.paladin.getAtk(),AppData.paladin.getDefense(),AppData.paladin.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab2=false;

        }else{
            AppData.userHero3 = new UserHero();
            AppData.userHero3.setUserheroname(AppData.paladin.getHeroname());
            AppData.userHero3.setHeroid(AppData.paladin.getId());
            AppData.userHero3.setUserid(AppData.user.getId());
            AppData.userHero3.setLevelid(1);
            AppData.userHero3.setTab(3);
            userHeroesDBTable.insert(AppData.userHero3.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.paladin.getHp(),AppData.paladin.getAtk(),AppData.paladin.getDefense(),AppData.paladin.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab3=false;

        }

        Intent intent = new Intent(this, HeroSelection.class);
        startActivity(intent);
        finish();
    }
    public void CreateHero4(View view) {
        //priest
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);

        if(AppData.createtab1){
            AppData.userHero1 = new UserHero();
            AppData.userHero1.setUserheroname(AppData.priest.getHeroname());
            AppData.userHero1.setHeroid(AppData.priest.getId());
            AppData.userHero1.setUserid(AppData.user.getId());
            AppData.userHero1.setLevelid(1);
            AppData.userHero1.setTab(1);
            userHeroesDBTable.insert(AppData.userHero1.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.priest.getHp(),AppData.priest.getAtk(),AppData.priest.getDefense(),AppData.priest.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab1=false;


        }else if(AppData.createtab2){
            AppData.userHero2 = new UserHero();
            AppData.userHero2.setUserheroname(AppData.priest.getHeroname());
            AppData.userHero2.setHeroid(AppData.priest.getId());
            AppData.userHero2.setUserid(AppData.user.getId());
            AppData.userHero2.setLevelid(1);
            AppData.userHero2.setTab(2);
            userHeroesDBTable.insert(AppData.userHero2.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.priest.getHp(),AppData.priest.getAtk(),AppData.priest.getDefense(),AppData.priest.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab2=false;

        }else{
            AppData.userHero3 = new UserHero();
            AppData.userHero3.setUserheroname(AppData.priest.getHeroname());
            AppData.userHero3.setHeroid(AppData.priest.getId());
            AppData.userHero3.setUserid(AppData.user.getId());
            AppData.userHero3.setLevelid(1);
            AppData.userHero3.setTab(3);
            userHeroesDBTable.insert(AppData.userHero3.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.priest.getHp(),AppData.priest.getAtk(),AppData.priest.getDefense(),AppData.priest.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab3=false;

        }

        Intent intent = new Intent(this, HeroSelection.class);
        startActivity(intent);
        finish();
    }
    public void CreateHero5(View view) {
        //archer
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);

        if(AppData.createtab1){
            AppData.userHero1 = new UserHero();
            AppData.userHero1.setUserheroname(AppData.archer.getHeroname());
            AppData.userHero1.setHeroid(AppData.archer.getId());
            AppData.userHero1.setUserid(AppData.user.getId());
            AppData.userHero1.setLevelid(1);
            AppData.userHero1.setTab(1);
            userHeroesDBTable.insert(AppData.userHero1.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.archer.getHp(),AppData.archer.getAtk(),AppData.archer.getDefense(),AppData.archer.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab1=false;


        }else if(AppData.createtab2){
            AppData.userHero2 = new UserHero();
            AppData.userHero2.setUserheroname(AppData.archer.getHeroname());
            AppData.userHero2.setHeroid(AppData.archer.getId());
            AppData.userHero2.setUserid(AppData.user.getId());
            AppData.userHero2.setLevelid(1);
            AppData.userHero2.setTab(2);
            userHeroesDBTable.insert(AppData.userHero2.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.archer.getHp(),AppData.archer.getAtk(),AppData.archer.getDefense(),AppData.archer.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab2=false;

        }else{
            AppData.userHero3 = new UserHero();
            AppData.userHero3.setUserheroname(AppData.archer.getHeroname());
            AppData.userHero3.setHeroid(AppData.archer.getId());
            AppData.userHero3.setUserid(AppData.user.getId());
            AppData.userHero3.setLevelid(1);
            AppData.userHero3.setTab(3);
            userHeroesDBTable.insert(AppData.userHero3.getContentValues());

            cursor = db.rawQuery("select last_insert_rowid()",null);
            if(cursor.moveToFirst()){
                long id= cursor.getLong(0);
                AppData.stats= new Stats(AppData.archer.getHp(),AppData.archer.getAtk(),AppData.archer.getDefense(),AppData.archer.getLuck(),0,id);
                statsDBTable.insert(AppData.stats.getContentValues());
            }

            AppData.createtab3=false;

        }

        Intent intent = new Intent(this, HeroSelection.class);
        startActivity(intent);
        finish();
    }


    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
           switch (position)
           {
               case 0:
                   Tab1 tab1 = new Tab1();
                   return tab1;
               case 1:
                   Tab2 tab2 = new Tab2();
                   return tab2;
               case 2:
                   Tab3 tab3 = new Tab3();
                   return tab3;
               case 3:
                   Tab4 tab4 = new Tab4();
                   return tab4;
               case 4:
                   Tab5 tab5 = new Tab5();
                   return tab5;
                   default:
                       return null;
           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }
    }
}
