package edu.kiet.www.explicitintentexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView displayName;
    Button goodbye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        displayName=findViewById(R.id.txtDisplayName);
        Bundle data = getIntent().getExtras();
        displayName.setText(data.getString("name"));
        goodbye=findViewById(R.id.btnGoodBye);
        goodbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("bye","Good Bye");
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });

    }
}
