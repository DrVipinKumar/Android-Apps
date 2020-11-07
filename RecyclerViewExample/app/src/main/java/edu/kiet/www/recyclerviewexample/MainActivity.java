package edu.kiet.www.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    String myname[]={"Exit Icon","Infor Icon","Home Icon","USB Icon","Secure USB Icon"};
    int myimage[]={R.drawable.exit,R.drawable.info,R.drawable.home,R.drawable.usb,R.drawable.securekey};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(MainActivity.this,myname,myimage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
