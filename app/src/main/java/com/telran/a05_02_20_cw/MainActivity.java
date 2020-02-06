package com.telran.a05_02_20_cw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MenuItem removeItem, editItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myList = findViewById(R.id.myList);
        final MyAdapter adapter = new MyAdapter();
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person) adapter.getItem(position);
                Toast.makeText(MainActivity.this, p.name, Toast.LENGTH_SHORT).show();
            }
        });

        Button addBtn = findViewById(R.id.addBtn);
        Button removeBtn = findViewById(R.id.rmBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(new Person("Name " + (int)(Math.random()*100),
                        "Phone",
                        "Email"));
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.remove();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        editItem = menu.findItem(R.id.editItem);
        removeItem = menu.findItem(R.id.removeItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.addItem){
            Toast.makeText(this, "Add Item", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.removeItem){
            removeItem.setVisible(false);
            editItem.setVisible(true);
        }else if(item.getItemId() == R.id.editItem){
            removeItem.setVisible(true);
            editItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(this, "Opened", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }


    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show();
        super.onOptionsMenuClosed(menu);
    }
}
