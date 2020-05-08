package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddList extends AppCompatActivity {
    private EditText dateText;
    private EditText itemText;
    private boolean add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //name of the xml
        setContentView(R.layout.add_list);

        dateText = findViewById(R.id.dateText);
        itemText = findViewById(R.id.itemText);

        //the main page grabs this i and sends it to open
        Intent i = getIntent();
        add = i.getBooleanExtra("ADD", true);
    }
    public void addPressed(View v){
        //grabbing the database manager
        databasemanager dbm = new databasemanager(this);
        //grabs title & director from title & director box in addlist
        String date = dateText.getText().toString();
        String item = itemText.getText().toString();
        //dbm.insert(date, item);
        if(add) {
            dbm.insert(date, item);
        }
        finish();
    }
}
