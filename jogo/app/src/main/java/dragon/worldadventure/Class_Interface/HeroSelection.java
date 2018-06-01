package dragon.worldadventure.Class_Interface;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
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

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.HeroDBTable;
import dragon.worldadventure.Base_Dados.LevelDBTable;
import dragon.worldadventure.Base_Dados.UserDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab1;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab2;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab3;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Hero;
import dragon.worldadventure.Objects.Level;
import dragon.worldadventure.Objects.UserHero;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class HeroSelection extends AppCompatActivity {

    final DBHandler dbHandler=new DBHandler(this);

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


    public Cursor cursorcheckexistance=null;
    public Cursor cursorchecktab=null;
    public Cursor cursorhero=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_selection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final HeroDBTable heroDBTable = new HeroDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);

        cursorcheckexistance = userHeroesDBTable.queryCheckExistance(AppData.user.getId());

        if(cursorcheckexistance.moveToNext()){
         cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),1);
         if (cursorchecktab.moveToNext()){
             AppData.userHero1=new UserHero(cursorchecktab);
             AppData.existstab1=true;

             cursorhero =  heroDBTable.querySingle(HeroDBTable.ALL_FIELDS,""+AppData.userHero1.getHeroid());
             if(cursorhero.moveToNext()){
                 AppData.herotab1 = new Hero(cursorhero);
             }
             cursorhero = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS, ""+AppData.userHero1.getLevelid());
             if(cursorhero.moveToNext()){
                 AppData.leveltab1 = new Level(cursorhero);
             }
         }
            cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),2);
            if (cursorchecktab.moveToNext()) {
                AppData.userHero2 = new UserHero(cursorchecktab);
                AppData.existstab2 = true;

                cursorhero = heroDBTable.querySingle(HeroDBTable.ALL_FIELDS, "" + AppData.userHero2.getHeroid());
                if (cursorhero.moveToNext()) {
                    AppData.herotab2 = new Hero(cursorhero);
                }
                cursorhero = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS, "" + AppData.userHero2.getLevelid());
                if (cursorhero.moveToNext()) {
                    AppData.leveltab2 = new Level(cursorhero);
                }
            }
            cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),3);
            if (cursorchecktab.moveToNext()) {
                AppData.userHero3 = new UserHero(cursorchecktab);
                AppData.existstab3 = true;

                cursorhero = heroDBTable.querySingle(HeroDBTable.ALL_FIELDS, "" + AppData.userHero3.getHeroid());
                if (cursorhero.moveToNext()) {
                    AppData.herotab3 = new Hero(cursorhero);
                }
                cursorhero = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS, "" + AppData.userHero3.getLevelid());
                if (cursorhero.moveToNext()) {
                    AppData.leveltab3 = new Level(cursorhero);
                }
            }


        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hero_selection, menu);
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

    public void Check_Hero_Inventory1(View view) {
    }

    public void Check_Hero_Inventory2(View view) {
    }

    public void Check_Hero_Inventory3(View view) {
    }



    public void Create_NewHero1(View view) {
        AppData.createtab1=true;
        Intent intent = new Intent(this, CreateHero.class);
        startActivity(intent);
        finish();
    }

    public void Create_NewHero2(View view) {
        AppData.createtab2=true;
        Intent intent = new Intent(this, CreateHero.class);
        startActivity(intent);
        finish();
    }

    public void Create_NewHero3(View view) {
        AppData.createtab3=true;
        Intent intent = new Intent(this, CreateHero.class);
        startActivity(intent);
        finish();
    }



    public void Delete_Hero1(View view) {
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        AppData.existstab1=false;

        userHeroesDBTable.delete(""+AppData.userHero1.getId());

        Intent intent = new Intent(this,HeroSelection.class);
        startActivity(intent);
        finish();
    }

    public void Delete_Hero2(View view) {
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);

        AppData.existstab2=false;

        userHeroesDBTable.delete(""+AppData.userHero2.getId());

        Intent intent = new Intent(this,HeroSelection.class);
        startActivity(intent);
        finish();
    }

    public void Delete_Hero3(View view) {
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);

        AppData.existstab3=false;

        userHeroesDBTable.delete(""+AppData.userHero3.getId());

        Intent intent = new Intent(this,HeroSelection.class);
        startActivity(intent);
        finish();
    }



    public void StartAdventure1(View view) {
        AppData.selectedherotab1=true;
        Intent intent = new Intent(this,InGame.class);
        startActivity(intent);
        finish();
    }

    public void StartAdventure2(View view) {
        AppData.selectedherotab2=true;
        Intent intent = new Intent(this,InGame.class);
        startActivity(intent);
        finish();
    }

    public void StartAdventure3(View view) {
        AppData.selectedherotab3=true;
        Intent intent = new Intent(this,InGame.class);
        startActivity(intent);
        finish();
    }




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
           //Returning the current tabs
            switch (position){
                case 0:
                    Tab1 tab1 = new Tab1();
                    return tab1;
                case 1:
                    Tab2 tab2 = new Tab2();
                    return tab2;
                case 2:
                    Tab3 tab3 = new Tab3();
                    return tab3;
                default:
                    return  null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

    }
}
