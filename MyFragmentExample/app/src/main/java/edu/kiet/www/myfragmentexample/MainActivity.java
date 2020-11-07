package edu.kiet.www.myfragmentexample;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button showfragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showfragment2 = findViewById(R.id.btnShowFragment2);
        showfragment2.setOnClickListener(new View.OnClickListener() {
            boolean check;
            @Override
            public void onClick(View view) {
                if(check==false) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new Fragment2());
                    fragmentTransaction.commit();
                    check=true;
                }else
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new Fragment1());
                    fragmentTransaction.commit();
                    check=false;
                }

            }
        });

    }
}
