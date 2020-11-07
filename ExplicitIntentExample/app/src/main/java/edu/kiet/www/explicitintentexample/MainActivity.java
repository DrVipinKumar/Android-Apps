package edu.kiet.www.explicitintentexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button openActivity;
    EditText data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openActivity=findViewById(R.id.button);
        data=findViewById(R.id.txtName);
        openActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),SecondActivity.class);
                i.putExtra("name",data.getText().toString());
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                Toast.makeText(getApplicationContext(),data.getStringExtra("bye"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
