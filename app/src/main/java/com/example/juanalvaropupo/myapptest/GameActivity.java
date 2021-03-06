package com.example.juanalvaropupo.myapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

    private TextView clueTextview;
    private TextView Guess1;
    private TextView Guess2;
    private TextView Guess3;
    private TextView Guess4;
    private TextView instructions;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        clueTextview = findViewById(R.id.clue_textview);
        guessButton = findViewById(R.id.submit_guess_button);
        guess = findViewById(R.id.guess_edittext);
        instructions = findViewById(R.id.instruction_textview);
        Guess1 = findViewById(R.id.first_guess);
        Guess2 = findViewById(R.id.second_guess);
        Guess3 = findViewById(R.id.third_guess);
        Guess4 = findViewById(R.id.fourth_guess);

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
//                    else if (userGuess)
                    } else {
                        checkGuess(userGuess);
                    }
            }
        });
    }

    private void checkGuess(int userGuess) {

        int MAX_GUESS_COUNT = 4;
        if (userGuess == generatedNumber) {
            //TODO - Create intent to go to winning activity - handle winning
            Intent win = new Intent(this, ResultsActivity.class);
            win.putExtra("generatedNumber", generatedNumber);
            win.putExtra("userGuess", userGuess);
            startActivity(win);

        } else if (numberOfGuesses > MAX_GUESS_COUNT) {
            //TODO - Create intent to go to winning activity - handle out of chances
            Intent lose = new Intent(this, ResultsActivity.class);
            lose.putExtra("generatedNumber", generatedNumber);
            lose.putExtra("userGuess", userGuess);
            startActivity(lose);
        }
        if (userGuess > generatedNumber) {
            clueTextview.setText(R.string.higher_message);
            clueTextview.setVisibility(View.VISIBLE);
            numberOfGuesses++;
            typedNumbers();

        } else if (userGuess < generatedNumber) {
            clueTextview.setText(R.string.lower_message);
            clueTextview.setVisibility(View.VISIBLE);
            numberOfGuesses++;
            typedNumbers();
        }
    }

    private void typedNumbers (){

            if (numberOfGuesses == 4){
                instructions.setText("You have 2 chances");
                String textInput = guess.getText().toString();
                Guess3.setText(textInput);
                Guess3.setVisibility(View.VISIBLE);

            } else if (numberOfGuesses == 2){
                instructions.setText("You have 4 chances");
                String textInput = guess.getText().toString();
                Guess1.setText(textInput);

            } else if (numberOfGuesses == 3){
                instructions.setText("You have 3 chances");
                String textInput = guess.getText().toString();
                Guess2.setText(textInput);

            } else if (numberOfGuesses == 5){
                instructions.setText("This is your last chance");
                String textInput = guess.getText().toString();
                Guess4.setText(textInput);
            }
        guess.setText("");
        }
    }
