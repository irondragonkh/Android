package dragon.worldadventure.Class_Interface;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.support.v4.app.LoaderManager;

import android.support.v4.content.Loader;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.JogoContentProvider;
import dragon.worldadventure.Base_Dados.VillanCursorAdapter;
import dragon.worldadventure.Base_Dados.VillanDBTable;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.Villan;
import dragon.worldadventure.R;

public class VillanList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int VILLAN_CURSOR_LOADER_ID = 0;
    public static final String VILLAN_ID = "VILLAN_ID";
    public Cursor cursorvillan;
    final DBHandler dbHandler=new DBHandler(this);

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

        getSupportLoaderManager().initLoader(VILLAN_CURSOR_LOADER_ID,null,null);
    }

    private void Battle(){
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
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
      if(id == VILLAN_CURSOR_LOADER_ID){
          return new CursorLoader(this, JogoContentProvider.VILLAN_URI,VillanDBTable.ALL_FIELDS,null,null,null);
      }
      return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        villanCursorAdapter.refreshData(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        villanCursorAdapter.refreshData(null);

    }
}
