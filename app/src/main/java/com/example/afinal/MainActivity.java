package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //user can create a grocery list
    public void createList(View v){
        Intent i = new Intent(this, AddList.class);
        //test if you are adding
        i.putExtra("ADD", true);
        startActivity(i);

    }
    //user can view grocery lists
    public void viewList(View v){
        Intent i = new Intent(this, ViewDates.class);
        startActivity(i);

    }
}
