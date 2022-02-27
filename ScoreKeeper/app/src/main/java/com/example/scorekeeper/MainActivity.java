package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView team1_score;
    TextView team2_score;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button addscore_team1;
    Button addscore_team2;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1_score = (TextView) findViewById(R.id.team1_score);
        team2_score = (TextView) findViewById(R.id.team2_score);
        radioGroup = findViewById(R.id.radioGroup);
        addscore_team1 = findViewById(R.id.addscore_team1);
        addscore_team2 = findViewById(R.id.addscore_team2);

    }

    public void team1_increment (View v)
    {
        counter++;
        team1_score.setText("" + counter);
        Toast.makeText(MainActivity.this,"Add 1 point in team 1 score",Toast.LENGTH_SHORT).show();
    }

    public void team1_decrement (View v)
    {
        if (counter <= 0)
            counter = 0;
        else
        counter--;
        team1_score.setText("" + counter);
        Toast.makeText(MainActivity.this,"Remove 1 point from team 1 score",Toast.LENGTH_SHORT).show();
    }

    public void team2_increment (View v)
    {
        counter++;
        team2_score.setText("" + counter);
        Toast.makeText(MainActivity.this,"Add 1 point in team 2 score",Toast.LENGTH_SHORT).show();
    }

    public void team2_decrement (View v)
    {
        if (counter <= 0)
            counter = 0;
        else
            counter--;
        team2_score.setText("" + counter);
        Toast.makeText(MainActivity.this,"Remove 1 point from team 2 score",Toast.LENGTH_SHORT).show();
    }
}