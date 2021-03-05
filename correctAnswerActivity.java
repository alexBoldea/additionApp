package com.example.additionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class correctAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

        Button bravoBtn = (Button) findViewById(R.id.bravoBtn);
        bravoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainIntent);
            }
        });
    }
}
