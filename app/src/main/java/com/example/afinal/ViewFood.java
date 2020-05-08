package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewFood extends AppCompatActivity {

    private ScrollView scrollView2;
    private TextView dateDisplayed;
    private RadioButton addItem;
    private RadioButton sendList;
    private int emailList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connects this class to the layout view
        setContentView(R.layout.view_food);

        dateDisplayed = findViewById(R.id.dateDisplayed);
        scrollView2 = findViewById(R.id.scrollView2);
        addItem = findViewById(R.id.addItem);
        sendList = findViewById(R.id.viewDateList);



        //removes everything that is already in the scroll view
        scrollView2.removeAllViewsInLayout();

        databasemanager dbm = new databasemanager(this);
        Intent i = getIntent();
        String date = i.getStringExtra("DATE"); //gets date from intent in view date list
        String[] entry = dbm.get(date);

        //sets the text from the database to the date and items view
        dateDisplayed.setText(entry[0]);
        //listView.setText(entry[1]);



        ArrayList<String> list2 = dbm.getItem(date); //fills list with all the food items in the database according to date selected
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);//creates 1 column to put one item per line in grid
        grid.setRowCount(list2.size());

        //for each string item in our list2
        for (String item:list2 ) {
            TextView text = new TextView(this); //creating components of the view in the code
            text.setText(item); //adds the items to text
            text.setTextSize(40);
            grid.addView(text); //adds the food items to the view
        }
        scrollView2.addView(grid); //adds the grid to the scrollview
    }
    public void options(View v){

        if (addItem.isChecked()) {
            Intent i = new Intent(this, AddList.class);
            //test if you are adding
            i.putExtra("ADD", true);
            startActivity(i);
        }
        else{
            Intent i = new Intent(this, ViewDates.class);
            startActivity(i);
            finish();

        }


    }


}
