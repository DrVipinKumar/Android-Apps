package edu.kiet.www.myoptionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContext=findViewById(R.id.btnContext);
        btnContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),btnContext);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId())
                        {
                            case R.id.item1:
                                Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item3:
                                Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        registerForContextMenu(btnContext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("My Context Example");
        menu.add(0,1,0,"Open");
        menu.add(0,2,0,"Close");
        menu.add(0,3,0,"Display");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 1:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
