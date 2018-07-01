package dragon.worldadventure.Class_Interface.InGameTabs;


import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;

import android.support.v4.app.LoaderManager;

import android.support.v4.content.Loader;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.JogoContentProvider;
import dragon.worldadventure.Base_Dados.VillanCursorAdapter;
import dragon.worldadventure.Base_Dados.VillanDBTable;
import dragon.worldadventure.Class_Interface.BattleMode;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Villan;
import dragon.worldadventure.R;

public class VillanList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    private static final int VILLAN_CURSOR_LOADER_ID = 0;
    public static final String VILLAN_ID = "VILLAN_ID";
    public Cursor cursorvillan;

    private VillanCursorAdapter villanCursorAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villan_list);


        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewVillan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        villanCursorAdapter = new VillanCursorAdapter(this);
        recyclerView.setAdapter(villanCursorAdapter);

        villanCursorAdapter.setViewHolderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Battle();
            }
        });

        getSupportLoaderManager().initLoader(VILLAN_CURSOR_LOADER_ID,null,this);
    }

    private void Battle(){

        final DBHandler dbHandler=new DBHandler(this);
        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final VillanDBTable villanDBTable= new VillanDBTable(db);
        int id = villanCursorAdapter.getLastVillanClicked();

        cursorvillan=villanDBTable.querySingle(VillanDBTable.ALL_FIELDS,""+id);
        if(cursorvillan.moveToNext()){
            AppData.villan = new Villan(cursorvillan);
        }

        Intent intent = new Intent(this, BattleMode.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(VILLAN_CURSOR_LOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
      if(id == VILLAN_CURSOR_LOADER_ID){
          return new CursorLoader(this, JogoContentProvider.VILLAN_URI,VillanDBTable.ALL_FIELDS,null,null,null);
      }
      return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        villanCursorAdapter.refreshData(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        villanCursorAdapter.refreshData(null);

    }
}
