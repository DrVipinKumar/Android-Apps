package edu.kiet.www.myoptionmenuexample;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popup=findViewById(R.id.button);
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),popup);
                popupMenu.getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                    popupMenu.show();
            }
        });
        registerForContextMenu(popup);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,1,0,"context1");
        menu.add(0,2,0,"context2");
        menu.add(0,3,0,"context3");
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
            case R.id.app_bar_search:
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        return false;
                    }
                });

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
