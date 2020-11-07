package edu.kiet.www.openbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button openurl;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url=findViewById(R.id.txtUrl);
        openurl=findViewById(R.id.btnOpenUrl);
        openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i =new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(url.getText().toString()));
               startActivity(i);


            }
        });
    }
}
