package dragon.worldadventure;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.VillanDBTable;
import dragon.worldadventure.Objects.Villan;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Before
    public void SetUp(){
        getContext().deleteDatabase(DBHandler.DATABASE_NAME);
    }
    @Test
    public void openVillanDbTest() {
        // Context of the app under test.
        Context appContext =getContext();

        DBHandler dbHandler = new DBHandler(appContext);

        SQLiteDatabase db = dbHandler.getReadableDatabase();
        assertTrue("Could not open/ create game database",db.isOpen() );
       db.close();
    }

    @Test
    public void VillanCRUDtest(){
        DBHandler dbHandler = new DBHandler(getContext());

        SQLiteDatabase db = dbHandler.getReadableDatabase();

        VillanDBTable villanDBTable = new VillanDBTable(db);

        Villan villan = new Villan();
        villan.setVillanname("Teste");
        villan.setHp(1);
        villan.setAtk(2);
        villan.setDefense(3);
        villan.setLuck(4);

        long id = insertVillan(villanDBTable,villan);

        villan = ReadFirstVillan(villanDBTable,"Teste",id);

        villan.setVillanname("Testefinal");
        int rowsAffected = villanDBTable.update(VillanDBTable.getContentValues(villan),VillanDBTable._ID+"=?",
                new String[]{Long.toString(id)});

        assertEquals("Failed to update Villan",1,rowsAffected);

        villan = ReadFirstVillan(villanDBTable,"Testefinal",id);

        rowsAffected = villanDBTable.delete(VillanDBTable._ID + "=?", new String[]{Long.toString(id)});

        assertEquals("Failed to delete villan",1,rowsAffected);

        Cursor cursor = villanDBTable.query(VillanDBTable.ALL_FIELDS,null, null, null, null, null);
        assertEquals("Villan found after Delete?",0,cursor.getCount());

    }




    private Villan ReadFirstVillan(VillanDBTable villanDBTable, String teste, long id) {
        Cursor cursor = villanDBTable.query(VillanDBTable.ALL_FIELDS,null,null,null,null,null);
        assertEquals("Failed to read Villan",1,cursor.getCount());

        assertTrue("Failed to read categories",cursor.moveToNext());

        Villan villan = VillanDBTable.getCurrentVillanFromCursor(cursor);
        assertEquals("Incorrenct villan name",teste,villan.getVillanname());
        assertEquals("Incorrect villan id",id,villan.getId());

        return villan;
    }

    private long insertVillan(VillanDBTable villanDBTable, Villan villan) {
        long id = villanDBTable.insert(VillanDBTable.getContentValues(villan));

        assertNotEquals("Failed to insert a villan",-1,id);

        return id;
    }

    private Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}
