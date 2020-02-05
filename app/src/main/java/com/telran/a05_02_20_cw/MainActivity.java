package com.telran.a05_02_20_cw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myList = findViewById(R.id.myList);
        MyAdapter adapter = new MyAdapter();
        myList.setAdapter(adapter);
    }
}
