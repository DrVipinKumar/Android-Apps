package edu.kiet.www.mycustomliewviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int listofimage[]={R.drawable.computer,R.drawable.dvd,R.drawable.keyboard,R.drawable.mouse,R.drawable.monitor,R.drawable.server,R.drawable.speaker};
    String listofname[]={"Computer","DVD","Keyboard","Mouse","Monitor","Server","Speaker"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.custumlistview);
        final MyCustomBaseAdapter adapter = new MyCustomBaseAdapter(getApplicationContext(),listofimage,listofname);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),adapter.getItem(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
