package com.example.javalab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Switch switchButton;
    TextView teamName;
    TextView teamFirstScore;
    TextView teamSecondScore;
    Button plusScore;
    Button minusScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchButton = findViewById(R.id.switch1);
        teamName = findViewById(R.id.selectedTeamName);
        teamFirstScore = findViewById(R.id.team1Score);
        teamSecondScore = findViewById(R.id.team2Score);
        plusScore = findViewById(R.id.plusScore);
        minusScore = findViewById(R.id.minusScore);


        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    teamName.setText("Team 2");
                } else {
                    teamName.setText("Team 1");
                }
            }
        });


        plusScore.setOnClickListener(this);
        minusScore.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int value = 0;
        System.out.println(teamName.getText());
        switch (view.getId()){
            case R.id.plusScore:
                    if(teamName.getText().toString() == "Team 1") {
                        System.out.println("test");
                        value = Integer.parseInt(teamFirstScore.getText().toString().replaceAll("[^0-9]", ""));
                        System.out.println(value + " Goals");
                        value += 1;
                        teamFirstScore.setText(value + " Goals");
                    } else if(teamName.getText().toString() == "Team 2") {
                        value = Integer.parseInt(teamSecondScore.getText().toString().replaceAll("[^0-9]", ""));
                        value += 1;
                        teamSecondScore.setText(value + " Goals");
                    }
                    break;
            case R.id.minusScore:
                if(teamName.getText().toString() == "Team 1") {
                    value = Integer.parseInt(teamFirstScore.getText().toString().replaceAll("[^0-9]", ""));
                    value -= 1;
                    teamFirstScore.setText(value + " Goals");
                }else if(teamName.getText().toString() == "Team 2") {
                        value = Integer.parseInt(teamSecondScore.getText().toString().replaceAll("[^0-9]", ""));
                        value -= 1;
                        teamSecondScore.setText(value + " Goals");
                    }
                break;
        }
    }
}