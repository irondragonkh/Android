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

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.UserDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab1;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab2;
import dragon.worldadventure.Class_Interface.HeroSelectionTabs.Tab3;
import dragon.worldadventure.Objects.AppData;
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

        cursorcheckexistance = userHeroesDBTable.queryCheckExistance(AppData.user.getId());

        if(cursorcheckexistance.moveToNext()){
         cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),1);
         if (cursorchecktab.moveToNext()){
             //meter na app data userhero1 dados
         }
            cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),2);
            if (cursorchecktab.moveToNext()){
                //meter na app data userhero2 dados
            }
            cursorchecktab = userHeroesDBTable.queryCheckTab(AppData.user.getId(),3);
            if (cursorchecktab.moveToNext()){
                //meter na app data userhero3 dados
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



    public void Delete_Hero1(View view) {
    }

    public void Delete_Hero2(View view) {
    }

    public void Delete_Hero3(View view) {
    }

    public void Create_NewHero(View view){

    }

    public void StartAdventure(View view) {
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
