package edu.kiet.www.myradioexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgb=findViewById(R.id.rdgGender);
        rgb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i)
                {
                    case R.id.rbtnMale:
                        Toast.makeText(getApplicationContext(),"You selected male",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnFemale:
                        Toast.makeText(getApplicationContext(),"You selected female",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }
}
