package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewDates extends AppCompatActivity {

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dates);

        scrollView = findViewById(R.id.scrollView);
        Intent i = new Intent();

        //removes everything that is already in the scroll view
        scrollView.removeAllViewsInLayout();

        final databasemanager dbm = new databasemanager(this);
        ArrayList<String> list = dbm.getdates(); //fills list with all the dates in the database
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());

        //for each string date in our list
        for (String date:list ){
            TextView text = new TextView(this); //creating components of the view in the code
            text.setText(date);
            text.setTextSize(40);

            //makes button clickable
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                //tells the app what to do every time the button is clicked
                public void onClick(View view){
                    Intent i = new Intent(getApplicationContext(), ViewFood.class); //launches view both activity
                    //takes item that was clicked on and stores into intent
                    i.putExtra("DATE", ((TextView) view).getText().toString()); //casting value string
                    startActivity(i);
                }

            });

            grid.addView(text); //adds the food items to the view
        }
        scrollView.addView(grid); //adds the grid to the scrollview

    }

}
