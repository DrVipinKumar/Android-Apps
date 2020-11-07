package edu.kiet.www.mycheckboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c, java, python;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = findViewById(R.id.chkCLang);
        java = findViewById(R.id.chkJavaLang);
        python=findViewById(R.id.chkPythonLang);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.isChecked())
                    Toast.makeText(getApplicationContext(),"You selected C Language",Toast.LENGTH_SHORT).show();
            }
        });
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(java.isChecked())
                    Toast.makeText(getApplicationContext(),"You selected Java Language",Toast.LENGTH_SHORT).show();
            }
        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(python.isChecked())
                    Toast.makeText(getApplicationContext(),"You selected Python Language",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
