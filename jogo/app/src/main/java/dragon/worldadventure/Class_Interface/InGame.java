package dragon.worldadventure.Class_Interface;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import dragon.worldadventure.Algoritmos.SubirdeNivel;
import dragon.worldadventure.Algoritmos.TravelAdvanceAdventureTexts;
import dragon.worldadventure.Algoritmos.TravelXPRewards;
import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.LevelDBTable;
import dragon.worldadventure.Base_Dados.StatsDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Base_Dados.VillanDBTable;
import dragon.worldadventure.Class_Interface.InGameTabs.Preferences;
import dragon.worldadventure.Class_Interface.InGameTabs.Profile;
import dragon.worldadventure.Class_Interface.InGameTabs.Stats;
import dragon.worldadventure.Class_Interface.InGameTabs.Travel;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Level;
import dragon.worldadventure.Objects.Villan;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class InGame extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  View navHeader;
    final DBHandler dbHandler=new DBHandler(this);
    public Cursor cursor = null;
    public int currenthealth;
    private TravelXPRewards takeastep = new TravelXPRewards();
    private TravelAdvanceAdventureTexts textofstep = new TravelAdvanceAdventureTexts();
    private SubirdeNivel subirdeNivel = new SubirdeNivel();

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


      PrencherNavHeader();

        FragmentManager fragmentManager =getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new Travel()).commit();
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
            Intent intent = new Intent (this, VillanList.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_profile) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Profile()).commit();
        } else if (id == R.id.nav_preferences) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Preferences()).commit();
        } else if (id == R.id.nav_stats) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Stats()).commit();
        } else if (id == R.id.nav_logout) {
           AppData.existstab1=false;
            AppData.existstab2=false;
            AppData.existstab3=false;
            AppData.createtab1=false;
            AppData.createtab2=false;
            AppData.createtab3=false;
            AppData.enemy=false;
            AppData.levelup=false;
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void PrencherNavHeader(){
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navHeader = navigationView.getHeaderView(0);
        TextView textView = (TextView) navHeader.findViewById(R.id.TextViewNavBarLevel);
        ProgressBar progressBarEXP = (ProgressBar) navHeader.findViewById(R.id.ProgressBarEXP);
        ProgressBar progressBarHP = (ProgressBar) navHeader.findViewById(R.id.ProgressBarHP);
        GifImageView gifImageViewHero = (GifImageView) navHeader.findViewById(R.id.GifImageViewHero);
        TextView textViewHeroname = (TextView) navHeader.findViewById(R.id.TextViewHeroName);
        TextView textViewEXP = (TextView) navHeader.findViewById(R.id.TextViewEXP);
        TextView textViewHP = (TextView) navHeader.findViewById(R.id.TextViewCurrentHP);



            textViewHeroname.setText(AppData.selectedhero.getHeroname());
            // gifImageViewHero.setImageResource(R.drawable....);
            if(AppData.selectedhero.getId()==1){
                gifImageViewHero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.selectedhero.getId()==2){
                gifImageViewHero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.selectedhero.getId()==3){
                gifImageViewHero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.selectedhero.getId()==4){
                gifImageViewHero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.selectedhero.getId()==5){
                gifImageViewHero.setImageResource(R.drawable.priestheroicon);

            }
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.selectedusedhero.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                int currentxp = (int) AppData.selectedstats.getCurrentxp();
                int maxhealth = (int) AppData.selectedstats.getHp();
                currenthealth=maxhealth;
                textViewEXP.setText("EXP "+ currentxp +" / " + exptotal);
                textViewHP.setText("HP "+ currenthealth + " / " + maxhealth);
                textView.setText("Level " + level);
                progressBarEXP.setMax(exptotal);
                progressBarEXP.setProgress(currentxp);
                progressBarHP.setMax((maxhealth));
                progressBarHP.setProgress(maxhealth);
            }


    }

    public void AdventureStep(View view) {

        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);
        final VillanDBTable villanDBTable = new VillanDBTable(db);
        String steptext;

        TextView textViewAdventureText = (TextView)findViewById(R.id.TextViewAdventureText);
        CardView cardView = (CardView)findViewById(R.id.CardViewAdventureBonus);
        TextView textViewAdventureBonus = (TextView) findViewById(R.id.TextViewAdventureBonus);
        final Button button= (Button) findViewById(R.id.ButtonAdvanceAdventure);
        takeastep.TaketheStep();
        steptext=textofstep.ChooseField();

        if(AppData.enemy){

            Random r = new Random();
            int min = 1;
            int max = 5;


            int randomnumber = r.nextInt(max - min + 1) + min;
            cursor=villanDBTable.querySingle(VillanDBTable.ALL_FIELDS,""+randomnumber);
            if(cursor.moveToNext()){
                AppData.villan = new Villan(cursor);
            }



        }else {


            textViewAdventureText.setVisibility(View.VISIBLE);
            textViewAdventureText.setText(steptext);
            cardView.setVisibility(View.VISIBLE);
            textViewAdventureBonus.setVisibility(View.VISIBLE);
            textViewAdventureBonus.setText("You received " + AppData.stepxp + " EXP");


            subirdeNivel.LeveluponStep();
            if (AppData.levelup) {

                subirdeNivel.AppDataLevelupParameteresForExp();
                subirdeNivel.AppDataLevelupStatsUpdate();


                    statsDBTable.update(AppData.selectedstats.getContentValues(), "" + AppData.selectedstats.getId());
                    userHeroesDBTable.update(AppData.selectedusedhero.getContentValues(), "" + AppData.selectedusedhero.getId());
                    cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS, "" + AppData.selectedlevel.getId() + 1);
                    if (cursor.moveToNext()) {
                        AppData.selectedlevel = new Level(cursor);
                    }

            } else {
                subirdeNivel.GiveStepxp();

                    statsDBTable.update(AppData.selectedstats.getContentValues(), "" + AppData.selectedstats.getId());
            }
        }

        if(AppData.enemy){
            Intent intent = new Intent(this, BattleMode.class);
            startActivity(intent);
            finish();

        }else {
            PrencherNavHeader();
            AppData.expparanextlevel = 0;
            button.setEnabled(false);
            button.setText("Wait");
            button.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button.setEnabled(true);
                    button.setText("Take Another Step");
                }
            }, 5000);
        }
    }

}
