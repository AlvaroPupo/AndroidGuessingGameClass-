package com.example.juanalvaropupo.myapptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private TextView winMessage;
    private ImageView image_winner;
    private ImageView image_loser;
    private Button yes;
    private Button no;
    private int GeneratedNumber;
    private Intent mainTestClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        winMessage = findViewById(R.id.winning_edittext);
        image_winner = findViewById(R.id.winner_image);
        image_loser = findViewById(R.id.loser_image);
        yes = findViewById(R.id.yes_button);
        no = findViewById(R.id.no_button);

        Bundle bundle = getIntent().getExtras();
        int number_OfGuesses = bundle.getInt("numberOfGuesses");
        GeneratedNumber = bundle.getInt("generatedNumber");
        int UserGuess = bundle.getInt("userGuess");

        if (UserGuess == GeneratedNumber) {
            show_winning_screen();

        } else {
            show_losing_screen();
        }
            setListener();
    }

    private void setListener() {
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               System.exit(0);

            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        mainTestClass = new Intent(this, MainTest.class);
        startActivity(mainTestClass);
    }

    public void show_winning_screen() {

            winMessage.setText(getString(R.string.win_message));
            winMessage.setVisibility(View.VISIBLE);
        }
    public void show_losing_screen(){

        winMessage.setText(getString(R.string.run_out_of_chances_message)  +  GeneratedNumber );
        image_winner.setVisibility(View.INVISIBLE);
        image_loser.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}