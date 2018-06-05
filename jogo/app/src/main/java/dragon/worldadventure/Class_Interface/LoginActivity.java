package dragon.worldadventure.Class_Interface;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dragon.worldadventure.Base_Dados.DBHandler;
import dragon.worldadventure.Base_Dados.UserDBTable;
import dragon.worldadventure.Objects.AppData;
import dragon.worldadventure.Objects.User;
import dragon.worldadventure.R;


/**
 * A login screen that offers login via username/password
 * tambem se pode criar uma conta so tem 2 funçoes esta class
 * no app data e criado um user
 */
public class LoginActivity extends AppCompatActivity {

    final DBHandler dbHandler=new DBHandler(this);

    private EditText editTextUsername;
    private EditText editTextPassword;
    public Cursor cursor;
    public Cursor cursorpassword;
    public long id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.



    }

    /**
     --------------------Criar Conta
     */

    public void CreateAccount(View view) {


        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserDBTable userDBTable= new UserDBTable(db);

        editTextUsername = (EditText) findViewById(R.id.EditTextUsername);
        editTextPassword = (EditText) findViewById(R.id.EditTextpassword);

        AppData.user = new User(editTextUsername.getText().toString(),editTextPassword.getText().toString());

        cursor = userDBTable.querySingle(UserDBTable.ALL_FIELDS,AppData.user.getUsername());

        if(AppData.user.getUsername().trim().isEmpty()||AppData.user.getPassword().trim().isEmpty()) {


            if (AppData.user.getUsername().trim().isEmpty()) {
                editTextUsername.setError(getString(R.string.EmptyUsername));
                return;
            }
            if (AppData.user.getPassword().trim().isEmpty()) {
                editTextPassword.setError(getString(R.string.EmptyPassword));
                return;
            }
        }else{
            if (cursor.getCount() > 0) {
                Toast.makeText(this, R.string.InvalidNewUsername,Toast.LENGTH_SHORT).show();
            }else{
               userDBTable.insert(AppData.user.getContentValues());

               cursor = userDBTable.querySingle(UserDBTable.ALL_FIELDS,AppData.user.getUsername());

               if(cursor.moveToNext()){
                   AppData.user = new User(cursor);
               }
                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
                finish();
            }
        }

    }

    /**
     --------------------Entrar na conta
     */

    public void SignIn(View view) {

        final DBHandler dbHandler=new DBHandler(this);
        final SQLiteDatabase db=dbHandler.getReadableDatabase();
        final UserDBTable userDBTable= new UserDBTable(db);

        editTextUsername = (EditText) findViewById(R.id.EditTextUsername);
        editTextPassword = (EditText) findViewById(R.id.EditTextpassword);

        AppData.user = new User(editTextUsername.getText().toString(),editTextPassword.getText().toString());


        if(AppData.user.getUsername().trim().isEmpty()||AppData.user.getPassword().trim().isEmpty()) {


            if (AppData.user.getUsername().trim().isEmpty()) {
                editTextUsername.setError(getString(R.string.EmptyUsername));
                return;
            }
            if (AppData.user.getPassword().trim().isEmpty()) {
                editTextPassword.setError(getString(R.string.EmptyPassword));
                return;
            }
        }else {
            cursor = userDBTable.querySingle(UserDBTable.ALL_FIELDS,AppData.user.getUsername());
            cursorpassword = userDBTable.querySinglePassword(UserDBTable.ALL_FIELDS,AppData.user.getPassword());

            if (cursor.getCount() == 0) {
                Toast.makeText(this, R.string.WrongUsername,Toast.LENGTH_SHORT).show();
            }else if (cursorpassword.getCount() ==0) {
                Toast.makeText(this, R.string.WrongPassword,Toast.LENGTH_SHORT).show();
            }else{

                if(cursor.moveToNext()){
                    AppData.user = new User(cursor);
                }

                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
                finish();
            }


        }



    }
}
