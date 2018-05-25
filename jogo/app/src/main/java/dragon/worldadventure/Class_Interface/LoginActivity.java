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
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    private EditText editTextUsername;
    private EditText editTextPassword;
    private DBHandler dbHandler=new DBHandler(this);
    private SQLiteDatabase db;
    private UserDBTable userDBTable;
    public  User user = new User();

    public Cursor cursorusername=null;
    public Cursor cursorpassword=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        db = dbHandler.getReadableDatabase();
        userDBTable = new UserDBTable(db);

    }

    public void CreateAccount(View view) {

        editTextUsername = (EditText) findViewById(R.id.EditTextUsername);
        editTextPassword = (EditText) findViewById(R.id.EditTextpassword);
        user.setPassword(editTextPassword.getText().toString());
        user.setUsername(editTextUsername.getText().toString());


        //cursor = loginDBTable.querySingle(editTextUsername.getText().toString());

        //AppData.login.setUsername(editTextUsername.getText().toString());
        //AppData.login.setPassword(editTextPassword.getText().toString());



        if(user.getUsername().trim().isEmpty()||user.getPassword().trim().isEmpty()) {


            if (user.getUsername().trim().isEmpty()) {
                editTextUsername.setError(getString(R.string.EmptyUsername));
                return;
            }
            if (user.getPassword().trim().isEmpty()) {
                editTextPassword.setError(getString(R.string.EmptyPassword));
                return;
            }
        }else{
           cursorusername = userDBTable.queryUsername(user.getUsername().toString());
            if (cursorusername.getCount() > 0) {
                Toast.makeText(this, R.string.InvalidNewUsername,Toast.LENGTH_SHORT).show();
            }else{
               userDBTable.insert(user.getContentValues());
                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
            }
        }

    }

    public void SignIn(View view) {





        editTextUsername = (EditText) findViewById(R.id.EditTextUsername);
        editTextPassword = (EditText) findViewById(R.id.EditTextpassword);


        user.setPassword(editTextPassword.getText().toString());
        user.setUsername(editTextUsername.getText().toString());

        //AppData.login.setUsername(editTextUsername.getText().toString());
        //AppData.login.setPassword(editTextPassword.getText().toString());





        if(user.getUsername().trim().isEmpty()||user.getPassword().trim().isEmpty()) {


            if (user.getUsername().trim().isEmpty()) {
                editTextUsername.setError(getString(R.string.EmptyUsername));
                return;
            }
            if (user.getPassword().trim().isEmpty()) {
                editTextPassword.setError(getString(R.string.EmptyPassword));
                return;
            }
        }else {

             cursorusername = userDBTable.queryUsername(user.getUsername().toString());

             cursorpassword =userDBTable.queryPassword(user.getPassword().toString());


            if (cursorusername.getCount() == 0) {
                Toast.makeText(this, R.string.WrongUsername,Toast.LENGTH_SHORT).show();
            }else if (cursorpassword.getCount() ==0) {
                Toast.makeText(this, R.string.WrongPassword,Toast.LENGTH_SHORT).show();
            }else{
               // final Cursor cursor =  userDBTable.querySingle(UserDBTable.ALL_FIELDS,"" + editTextUsername.getText().toString());

               /* if(cursor.moveToNext()) {
                    AppData.user = new User(cursor);


                }*/
                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
            }


        }



    }
}
