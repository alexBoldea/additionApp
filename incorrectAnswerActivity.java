package com.example.additionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class incorrectAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect_answer);

        Button tryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call the MainActivity passing firstNumber and secondNumber

                int firstNumber = 0;
                int secondNumber = 0;

                if ((getIntent().hasExtra("additionApp.first")) && (getIntent().hasExtra("additionApp.second"))) {
                    firstNumber = getIntent().getExtras().getInt("additionApp.first");
                    secondNumber = getIntent().getExtras().getInt("additionApp.second");
                }

                Intent startMainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startMainIntent.putExtra("additionApp.firstNumber", firstNumber);
                startMainIntent.putExtra("additionApp.secondNumber", secondNumber);
                startActivity(startMainIntent);

            }
        });
    }
}
