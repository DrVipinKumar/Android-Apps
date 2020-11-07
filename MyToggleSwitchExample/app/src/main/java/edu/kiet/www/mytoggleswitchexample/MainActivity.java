package edu.kiet.www.mytoggleswitchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggle;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggle=findViewById(R.id.tglBtn);
        aSwitch=findViewById(R.id.swtBtn);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true)
                    Toast.makeText(getApplicationContext(),"You have selecte toggle button",Toast.LENGTH_SHORT).show();
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true)
                    Toast.makeText(getApplicationContext(),"You have selecte switch button",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
