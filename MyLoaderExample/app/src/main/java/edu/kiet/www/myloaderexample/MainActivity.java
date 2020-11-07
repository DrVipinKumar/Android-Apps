package edu.kiet.www.myloaderexample;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button showcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showcontact =findViewById(R.id.btnShowContact);
        final MyLoader myLoader =new MyLoader(this);
        showcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLoaderManager().initLoader(1,null,myLoader);
            }
        });
    }



}
