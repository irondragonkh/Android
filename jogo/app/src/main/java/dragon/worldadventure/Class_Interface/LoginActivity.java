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

    final DBHandler dbHandler=new DBHandler(this);

    private EditText editTextUsername;
    private EditText editTextPassword;
    public  User user = new User();
    public Cursor cursor;
    private String username;
    private String password;
    public long id;

    public Cursor cursorusername=null;
    public Cursor cursorpassword=null;
    public Cursor cursorid=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.



    }

    public void CreateAccount(View view) {


        final SQLiteDatabase db =dbHandler.getReadableDatabase();
        final UserDBTable userDBTable= new UserDBTable(db);

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
                username=editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                cursorid = userDBTable.queryAll(username);
                if(cursorid.moveToNext()){
                    id = cursorid.getColumnIndex(UserDBTable._ID);
                }

                AppData.user = new User(username,password);


               userDBTable.insert(AppData.user.getContentValues());

                cursorid = userDBTable.queryAll(username);
                if(cursorid.moveToNext()){
                    id = cursorid.getColumnIndex(UserDBTable._ID);
                }
                AppData.user.setId(id);
                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
            }
        }

    }

    public void SignIn(View view) {

        final DBHandler dbHandler=new DBHandler(this);
        final SQLiteDatabase db=dbHandler.getReadableDatabase();
        final UserDBTable userDBTable= new UserDBTable(db);

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
                username=editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                cursorid = userDBTable.queryAll(username);
                if(cursorid.moveToNext()){
                    id = cursorid.getColumnIndex(UserDBTable._ID);
                }



                AppData.user = new User(username,password);
                AppData.user.setId(id);


                Intent intent = new Intent(this, HeroSelection.class);
                startActivity(intent);
            }


        }



    }
}
