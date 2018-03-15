package com.example.juanalvaropupo.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private TextView winMessage;
    private ImageView image_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        winMessage = findViewById(R.id.winning_edittext);
        image_result = findViewById(R.id.results_image);
        show_winning_screen();
    }

    private void show_winning_screen() {

            winMessage.setText(getString(R.string.win_message)
                    + getString(R.string.again_message));
            winMessage.setVisibility(View.VISIBLE);
        }
    private void show_losing_screen(){

        winMessage.setText(getString(R.string.run_out_of_chances_message) /* +  generatedNumber */
                + getString(R.string.again_message));
//        image_result
    }
}