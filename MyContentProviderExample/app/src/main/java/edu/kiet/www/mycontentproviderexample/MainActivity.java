package edu.kiet.www.mycontentproviderexample;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    Button showcontact;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showcontact=findViewById(R.id.btnShowContact);
        name=findViewById(R.id.txtName);

        showcontact.setOnClickListener(new View.OnClickListener() {
            boolean checkcontact = false;
            @Override
            public void onClick(View view) {

                if(checkcontact ==false) {
                    getLoaderManager().initLoader(1, null, MainActivity.this);
                    checkcontact =true;
                }
                else
                {
                    getLoaderManager().restartLoader(1, null, MainActivity.this);
                }
            }
        });
    }
    public void displayMessage(String title, String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setCancelable(true);
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String selection=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+"=?";
        String selectionarg[]={name.getText().toString()};
        String projection [] ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};

        if(i==1) {
            return new CursorLoader(this, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(cursor!=null && cursor.getCount()>0)
        {
            StringBuffer data = new StringBuffer();
            while(cursor.moveToNext())
            {
                data.append("Name=>"+cursor.getString(0)+"\n");
                data.append("Phone Number=>"+cursor.getInt(1)+"\n\n");
            }
            displayMessage("Contact Info",data.toString());
        }
        else
        {
            displayMessage("Error","Phone Number is not Found");
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
