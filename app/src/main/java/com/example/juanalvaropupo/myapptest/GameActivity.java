package com.example.juanalvaropupo.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView clueTextview;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextview = findViewById(R.id.clue_textview);
        guessButton = findViewById(R.id.submit_guess_button);
        guess = findViewById(R.id.guess_edittext);

        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);
    }

    private void setListener() {
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guess.getText().toString());
                if (userGuess > 100) {
                    Toast.makeText(GameActivity.this, "Enter a number between 1 - 100", Toast.LENGTH_LONG).show();
//                    clueTextview.setText("Enter a number between 1 - 100");
//                    clueTextview.setVisibility(View.VISIBLE);
                    guess.setText("");
                } else {
                    checkGuess(userGuess);
                }
            }
        });
    }

    private void checkGuess(int userGuess) {

        if (userGuess == generatedNumber) {
            //TODO - Create intent to go to winning activity - handle winning
            clueTextview.setText("you guessed the correct number!!"
                    + " Want to play again?");
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses = 0;

        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            //TODO - Create intent to go to winning activity - handle out of chances
            clueTextview.setText("Sorry, you have ran out of chances. The correct number was: " + generatedNumber
                    + " Want to play again?");
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses = 0;

        } else if (userGuess > generatedNumber) {
            clueTextview.setText("Your number is too high!");
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;

        } else if (userGuess < generatedNumber) {
            clueTextview.setText("Your number is too low");
            clueTextview.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;

        }
    }
}