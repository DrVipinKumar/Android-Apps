package edu.kiet.www.mysqliteexample;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button insert,update,delete,display;
    EditText rollnumber, name, branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyDatabaseHelper mydb=new MyDatabaseHelper(this);
        rollnumber=findViewById(R.id.txtRollNumber);
        name=findViewById(R.id.txtName);
        branch=findViewById(R.id.txtBranch);
        insert=findViewById(R.id.btnInsert);
        update=findViewById(R.id.btnUpdate);
        delete=findViewById(R.id.btnDelete);
        display=findViewById(R.id.btnDisplay);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rnumber = Integer.parseInt(rollnumber.getText().toString());
                long check=mydb.deleteRecord(rnumber);
                if(check>=1)
                {
                    displayMessage("Info","Record is deleted");
                }
                else
                {
                    displayMessage("Error","Record is not deleted");
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rnumber = Integer.parseInt(rollnumber.getText().toString());
                long check = mydb.updateRecord(rnumber,name.getText().toString(),branch.getText().toString());
                if(check>=1)
                {
                    displayMessage("Info","Record Updated");
                }
                else
                {
                    displayMessage("Error","Record not Updated");
                }
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor =mydb.getDisplay();
                if(cursor.getCount()>0)
                {
                    StringBuffer data =new StringBuffer();
                    while (cursor.moveToNext())
                    {
                        data.append("Roll Number=>"+cursor.getInt(0)+"\n");
                        data.append("Name=>"+cursor.getString(1)+"\n");
                        data.append("Branch=>"+cursor.getString(2)+"\n\n");
                    }
                    displayMessage("Record Found",data.toString());
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rnumber = Integer.parseInt(rollnumber.getText().toString());
                long check = mydb.insertRecord(rnumber,name.getText().toString(),branch.getText().toString());
                if(check==-1)
                {
                    displayMessage("Error","Record not inserted");
                }
                else
                {
                    displayMessage("Info","Record Inserted");
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
}
