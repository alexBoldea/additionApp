package com.example.additionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstNumberTextView = (TextView) findViewById(R.id.firstNumberTextView);
        TextView secondNumberTextView = (TextView) findViewById(R.id.secondNumberTextView);

        int first;
        int second;

        if ((getIntent().hasExtra("additionApp.firstNumber")) && (getIntent().hasExtra("additionApp.secondNumber"))){
            first = getIntent().getExtras().getInt("additionApp.firstNumber");
            second = getIntent().getExtras().getInt("additionApp.secondNumber");
        } else {
            first = 10 + (int) (Math.random()*90);
            second = 10 + (int) (Math.random()*90);
        }

        firstNumberTextView.setText(first + "");
        secondNumberTextView.setText(second + "");

        int correctAnswer = first + second;  // correct answer

        Button verificaButton = (Button) findViewById(R.id.verificaButton);
        verificaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText raspunsEditText = (EditText) findViewById(R.id.raspunsEditText);
                try {
                    int raspuns = Integer.parseInt(raspunsEditText.getText().toString()); // user answer

                    if(raspuns == correctAnswer) {
                        Intent startCorrectIntent = new Intent(getApplicationContext(), correctAnswerActivity.class);       // new activity with button "Bravo, joaca din nou"
                        startActivity(startCorrectIntent);
                    } else {
                        // this should be a function

                        Intent startIncorrectIntent = new Intent(getApplicationContext(), incorrectAnswerActivity.class);   // new activity with button "mai incearca o data"
                        startIncorrectIntent.putExtra("additionApp.first", first);
                        startIncorrectIntent.putExtra("additionApp.second", second);
                        startActivity(startIncorrectIntent);
                    }
                } catch (NumberFormatException ex) {
                    Intent startIncorrectIntent = new Intent(getApplicationContext(), incorrectAnswerActivity.class);   // new activity with button "mai incearca o data"
                    startIncorrectIntent.putExtra("additionApp.first", first);
                    startIncorrectIntent.putExtra("additionApp.second", second);
                    startActivity(startIncorrectIntent);
                }
            }
        });
    }
}
