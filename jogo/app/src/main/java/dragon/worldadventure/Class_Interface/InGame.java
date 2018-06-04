package dragon.worldadventure.Class_Interface;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.LevelDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Class_Interface.InGameTabs.Battle;
import dragon.worldadventure.Class_Interface.InGameTabs.Preferences;
import dragon.worldadventure.Class_Interface.InGameTabs.Profile;
import dragon.worldadventure.Class_Interface.InGameTabs.Stats;
import dragon.worldadventure.Class_Interface.InGameTabs.Travel;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.R;

public class InGame extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  View navHeader;
    final DBHandler dbHandler=new DBHandler(this);
    public Cursor cursor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);


        navHeader = navigationView.getHeaderView(0);
        TextView textView = (TextView) navHeader.findViewById(R.id.TextViewNavBarLevel);
        ProgressBar progressBarEXP = (ProgressBar) navHeader.findViewById(R.id.ProgressBarEXP);
        ProgressBar progressBarHP = (ProgressBar) navHeader.findViewById(R.id.ProgressBarHP);

        if(AppData.selectedherotab1){
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero1.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                textView.setText("Level " + level);
            }

        }else if(AppData.selectedherotab2){
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero2.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                textView.setText("Level " + level);
            }
        }else{
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero3.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                textView.setText("Level " + level);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.in_game, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_travel) {
            // Handle the camera action
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Travel()).commit();
        } else if (id == R.id.nav_battle) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Battle()).commit();
        } else if (id == R.id.nav_profile) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Profile()).commit();
        } else if (id == R.id.nav_preferences) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Preferences()).commit();
        } else if (id == R.id.nav_stats) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Stats()).commit();
        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
