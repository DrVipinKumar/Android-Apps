package edu.kiet.www.myloginexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;
    boolean checklogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnLogin);
        username=findViewById(R.id.txtlogin);
        password=findViewById(R.id.txtpassword);
        final SharedPreferences sharedPreferences = getSharedPreferences("mylogin",Context.MODE_PRIVATE);
        checklogin =sharedPreferences.getBoolean("loginstatus",false);
        if(checklogin)
        {
            Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(i);
            finish();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("vipin")&& password.getText().toString().equals("kumar")) {
                    Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(i);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putBoolean("loginstatus",true);
                    editor.commit();
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter valid username and password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
