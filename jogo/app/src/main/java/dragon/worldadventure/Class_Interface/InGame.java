package dragon.worldadventure.Class_Interface;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import dragon.worldadventure.Algoritmos.SubirdeNivel;
import dragon.worldadventure.Algoritmos.TravelAdvanceAdventure;
import dragon.worldadventure.Algoritmos.TravelXPandBatlleFunc;
import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.LevelDBTable;
import dragon.worldadventure.Base_Dados.StatsDBTable;
import dragon.worldadventure.Base_Dados.UserHeroesDBTable;
import dragon.worldadventure.Class_Interface.InGameTabs.Battle;
import dragon.worldadventure.Class_Interface.InGameTabs.Preferences;
import dragon.worldadventure.Class_Interface.InGameTabs.Profile;
import dragon.worldadventure.Class_Interface.InGameTabs.Stats;
import dragon.worldadventure.Class_Interface.InGameTabs.Travel;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Level;
import dragon.worldadventure.R;
import pl.droidsonroids.gif.GifImageView;

public class InGame extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  View navHeader;
    final DBHandler dbHandler=new DBHandler(this);
    public Cursor cursor = null;
    public int currenthealth;
    private TravelXPandBatlleFunc takeastep = new TravelXPandBatlleFunc();
    private TravelAdvanceAdventure textofstep = new TravelAdvanceAdventure();
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
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Battle()).commit();
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
            AppData.selectedherotab1=false;
            AppData.selectedherotab2=false;
            AppData.selectedherotab3=false;
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



        if(AppData.selectedherotab1){

            textViewHeroname.setText(AppData.herotab1.getHeroname());
            // gifImageViewHero.setImageResource(R.drawable....);
            if(AppData.herotab1.getId()==1){
                gifImageViewHero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab1.getId()==2){
                gifImageViewHero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab1.getId()==3){
                gifImageViewHero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab1.getId()==4){
                gifImageViewHero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab1.getId()==5){
                gifImageViewHero.setImageResource(R.drawable.priestheroicon);

            }
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero1.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                int currentxp = (int) AppData.stats1.getCurrentxp();
                int maxhealth = (int) AppData.stats1.getHp();
                currenthealth=maxhealth;
                textViewEXP.setText("EXP "+ currentxp +" / " + exptotal);
                textViewHP.setText("HP "+ currenthealth + " / " + maxhealth);
                textView.setText("Level " + level);
                progressBarEXP.setMax(exptotal);
                progressBarEXP.setProgress(currentxp);
                progressBarHP.setMax((maxhealth));
                progressBarHP.setProgress(maxhealth);
            }

        }else if(AppData.selectedherotab2){

            textViewHeroname.setText(AppData.herotab2.getHeroname());
            // gifImageViewHero.setImageResource(R.drawable....);
            if(AppData.herotab2.getId()==1){
                gifImageViewHero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab2.getId()==2){
                gifImageViewHero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab2.getId()==3){
                gifImageViewHero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab2.getId()==4){
                gifImageViewHero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab2.getId()==5){
                gifImageViewHero.setImageResource(R.drawable.priestheroicon);

            }

            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero2.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                int currentxp = (int) AppData.stats2.getCurrentxp();
                int maxhealth = (int) AppData.stats2.getHp();
                currenthealth=maxhealth;
                textViewEXP.setText("EXP "+ currentxp +" / " + exptotal);
                textViewHP.setText("HP "+ currenthealth + " / " + maxhealth);
                textView.setText("Level " + level);
                progressBarEXP.setMax(exptotal);
                progressBarEXP.setProgress(currentxp);
                progressBarHP.setMax((maxhealth));
                progressBarHP.setProgress(maxhealth);
            }
        }else{

            textViewHeroname.setText(AppData.herotab3.getHeroname());
            // gifImageViewHero.setImageResource(R.drawable....);
            if(AppData.herotab3.getId()==1){
                gifImageViewHero.setImageResource(R.drawable.warriorheroicon);

            }else if(AppData.herotab3.getId()==2){
                gifImageViewHero.setImageResource(R.drawable.mageheroicon);

            }else if(AppData.herotab3.getId()==3){
                gifImageViewHero.setImageResource(R.drawable.paladinheroicon);

            }else if(AppData.herotab3.getId()==4){
                gifImageViewHero.setImageResource(R.drawable.archerheroicon);

            }else if(AppData.herotab3.getId()==5){
                gifImageViewHero.setImageResource(R.drawable.priestheroicon);

            }
            cursor = levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.userHero3.getLevelid());

            if(cursor.moveToNext()){
                int level = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_LEVEL));
                int exptotal = cursor.getInt(cursor.getColumnIndex(LevelDBTable.DB_COLUMN_XP));
                int currentxp = (int) AppData.stats3.getCurrentxp();
                int maxhealth = (int) AppData.stats3.getHp();
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
    }

    public void AdventureStep(View view) {

        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserHeroesDBTable userHeroesDBTable= new UserHeroesDBTable(db);
        final StatsDBTable statsDBTable = new StatsDBTable(db);
        final LevelDBTable levelDBTable = new LevelDBTable(db);
        String steptext;

        TextView textViewAdventureText = (TextView)findViewById(R.id.TextViewAdventureText);
        CardView cardView = (CardView)findViewById(R.id.CardViewAdventureBonus);
        TextView textViewAdventureBonus = (TextView) findViewById(R.id.TextViewAdventureBonus);
        final Button button= (Button) findViewById(R.id.ButtonAdvanceAdventure);
        takeastep.TaketheStep();
        steptext=textofstep.ChooseField();


        textViewAdventureText.setVisibility(View.VISIBLE);
        textViewAdventureText.setText(steptext);
        cardView.setVisibility(View.VISIBLE);
        textViewAdventureBonus.setVisibility(View.VISIBLE);
        textViewAdventureBonus.setText("You received " + AppData.stepxp + " EXP");


        subirdeNivel.LeveluponStep();
        if(AppData.levelup){

            subirdeNivel.AppDataLevelupParameteres();

            if (AppData.selectedherotab1) {
                statsDBTable.update(AppData.stats1.getContentValues(), "" + AppData.stats1.getId());
                userHeroesDBTable.update(AppData.userHero1.getContentValues(),""+AppData.userHero1.getId());
              cursor= levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.leveltab1.getId()+1);
                if(cursor.moveToNext()){
                    AppData.leveltab1 = new Level(cursor);
                }


            } else if (AppData.selectedherotab2) {
                statsDBTable.update(AppData.stats2.getContentValues(), "" + AppData.stats2.getId());
                userHeroesDBTable.update(AppData.userHero2.getContentValues(),""+AppData.userHero2.getId());
                cursor= levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.leveltab2.getId()+1);
                if(cursor.moveToNext()){
                    AppData.leveltab2 = new Level(cursor);
                }
            } else if (AppData.selectedherotab3) {
                statsDBTable.update(AppData.stats3.getContentValues(), "" + AppData.stats3.getId());
                userHeroesDBTable.update(AppData.userHero3.getContentValues(),""+AppData.userHero3.getId());
                cursor= levelDBTable.querySingle(LevelDBTable.ALL_FIELDS,""+AppData.leveltab3.getId()+1);
                if(cursor.moveToNext()){
                    AppData.leveltab3 = new Level(cursor);
                }
            }
        }else {
            subirdeNivel.GiveStepxp();


            if (AppData.selectedherotab1) {
                statsDBTable.update(AppData.stats1.getContentValues(), "" + AppData.stats1.getId());

            } else if (AppData.selectedherotab2) {
                statsDBTable.update(AppData.stats2.getContentValues(), "" + AppData.stats2.getId());

            } else if (AppData.selectedherotab3) {
                statsDBTable.update(AppData.stats3.getContentValues(), "" + AppData.stats3.getId());

            }
        }

        PrencherNavHeader();
        AppData.expparanextlevel=0;
        button.setEnabled(false);
        button.setText("Wait");
        button.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setEnabled(true);
                button.setText("Take Another Step");
            }
        },5000);
    }
}
