package com.example.juanalvaropupo.myapptest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

            startButton = findViewById(R.id.start_button);

            setListener();

    }
    private void setListener() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }
        @Override
        public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainTest.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    private void startGame(){
        Intent playGame = new Intent(this, GameActivity.class);
        playGame.putExtra("SETWHICHVIEW", 3);
        startActivity(playGame);
    }

}


