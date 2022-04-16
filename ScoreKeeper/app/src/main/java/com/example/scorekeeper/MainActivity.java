package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    /*Here I will make variables*/
    TextView team1_score;
    TextView team2_score;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button addscore_team1;
    Button addscore_team2;
    int counter = 0;
    int team1 = 0;
    int team2 = 0;
    String t1, t2;

    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This is the condition checked for dark and light mode.
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            // If night mode is equal to yes so set dark theme
            setTheme(R.style.Theme_Dark);
        } else {
            // If night mode is not equal to yes so set light theme
            setTheme(R.style.Theme_Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Here I will declare variables to their IDs*/
        team1_score = (TextView) findViewById(R.id.team1_score);
        team2_score = (TextView) findViewById(R.id.team2_score);
        radioGroup = findViewById(R.id.radioGroup);
        addscore_team1 = findViewById(R.id.addscore_team1);
        addscore_team2 = findViewById(R.id.addscore_team2);

        switchCompat = findViewById(R.id.switch_button);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // If switch button is checked so set night mode
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                // else switch button is unchecked so set light mode
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


        addscore_team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if (radioId == R.id.radioButton1) {
                    team1 = team1 + 1;
                    t1 = String.valueOf(team1);
                    team1_score.setText(t1);
                    Toast.makeText(MainActivity.this, "Add 1 point in team 1 score", Toast.LENGTH_SHORT).show();
                } else if (radioId == R.id.radioButton2) {
                    team1 = team1 + 2;
                    t1 = String.valueOf(team1);
                    team1_score.setText(t1);
                    Toast.makeText(MainActivity.this, "Add 2 points in team 1 score", Toast.LENGTH_SHORT).show();
                } else if (radioId == R.id.radioButton3) {
                    team1 = team1 + 3;
                    t1 = String.valueOf(team1);
                    team1_score.setText(t1);
                    Toast.makeText(MainActivity.this, "Add 3 points in team 1 score", Toast.LENGTH_SHORT).show();
                }
            }
        });
        addscore_team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if (radioId == R.id.radioButton1) {
                    team2 = team2 + 1;
                    t2 = String.valueOf(team2);
                    team2_score.setText(t2);
                    Toast.makeText(MainActivity.this, "Add 1 point in team 2 score", Toast.LENGTH_SHORT).show();
                } else if (radioId == R.id.radioButton2) {
                    team2 = team2 + 2;
                    t2 = String.valueOf(team2);
                    team2_score.setText(t2);
                    Toast.makeText(MainActivity.this, "Add 2 points in team 2 score", Toast.LENGTH_SHORT).show();
                } else if (radioId == R.id.radioButton3) {
                    team2 = team2 + 3;
                    t2 = String.valueOf(team2);
                    team2_score.setText(t2);
                    Toast.makeText(MainActivity.this, "Add 3 point2 in team 2 score", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*this onclick score increment method for team1*/
    public void team1_increment(View v) {
        team1++;
        team1_score.setText("" + team1);
    }

    /*this onclick score decrement method for team1*/
    public void team1_decrement(View v) {
        if (team1 <= 0)
            team1 = 0;
        else
            team1--;
        team1_score.setText("" + team1);
        Toast.makeText(MainActivity.this, "Remove 1 point from team 1 score", Toast.LENGTH_SHORT).show();
    }

    /*this onclick score increment method for team2*/
    public void team2_increment(View v) {
        team2++;
        team2_score.setText("" + team2);
    }

    /*this onclick score decrement method for team2*/
    public void team2_decrement(View v) {
        if (team2 <= 0)
            team2 = 0;
        else
            team2--;
        team2_score.setText("" + team2);
        ;
        Toast.makeText(MainActivity.this, "Remove 1 point from team 2 score", Toast.LENGTH_SHORT).show();
    }

    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

    }

    /* This method is use for the menubar */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return true;
    }

    /* This method use for the menu options*/
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        /* when user click on about at that time toast shown in main screen*/
        if (id == R.id.about) {
            Toast.makeText(MainActivity.this, "Dhruv Kaneriya (A00226210) IOT1009", Toast.LENGTH_SHORT).show();
        }

        /* when user click on setting at that time new screen will be open*/
        else if (id == R.id.settings)
        {
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
