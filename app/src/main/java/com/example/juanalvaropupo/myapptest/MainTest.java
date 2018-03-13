package com.example.juanalvaropupo.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainTest extends AppCompatActivity {

    /* 1. Directions Activity
    Hard code
        Directions
        Title
    Methods
        Button action
    Life Cycle Methods
        On Back Pressed
           exit
    */
    /* 2. Main Activity
    Methods
        Handling Guesses
            if, else if, else statements
            if number is greater than or lower than
            count the number of guesses
        if at MAX Guesses && if correct
            Go to finishing activity
        if the number is greater
            update TextView to tell user the number to guess lower
        if the number is lower
            update the TextView to tell the user to guess higher
    Button Action
    Generate Number
*/
    /* 3. Finishing Activity
    Methods
       Win/Lose
          if won
            not show correct number TextView
            happy image
          if lose
             show correct number TextView
             sad image
    Button Action
       Go to Main Activity

     */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        ButterKnife.bind(this);
    }


    }



