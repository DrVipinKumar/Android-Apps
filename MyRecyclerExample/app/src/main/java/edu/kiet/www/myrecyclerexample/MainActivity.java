package edu.kiet.www.myrecyclerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Integer getimage[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    String getname[]={"Dr. Vipin Kumar", "Jai Shani Dev","Jai Surya Dev","Jai Chaya Mata","Jai Bhoolenat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recylerView);
        RecyclerViewAdapter rva = new RecyclerViewAdapter(this,getimage,getname);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rva);

    }
}
