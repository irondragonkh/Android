package dragon.worldadventure.Objects;

import android.content.ContentValues;
import android.database.Cursor;

import dragon.worldadventure.Base_Dados.UserDBTable;

public class User {
    private long id;
    public String username;
    public String password;

    public User(Cursor cursor) {
        this.id = cursor.getLong(cursor.getColumnIndex(UserDBTable._ID));
        this.password = cursor.getString(cursor.getColumnIndex(UserDBTable.DB_COLUMN_PASSWORD));
        this.username = cursor.getString(cursor.getColumnIndex(UserDBTable.DB_COLUMN_USERNAME));



    }

    //construtores----------------------------------------------------------------------------
    public User(){
        //construtor vazio
    }

    public User(String username, String password){
        this.id = -1;
        this.username = username;
        this.password = password;
    }
    //----------------------------------------------------------------------------------------

    // todos os gets e sets das variaveis------------------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //-------------------------------------------------------------------------------------------------

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserDBTable.DB_COLUMN_USERNAME,username);
        contentValues.put(UserDBTable.DB_COLUMN_PASSWORD,password);

        return contentValues;
    }
}
