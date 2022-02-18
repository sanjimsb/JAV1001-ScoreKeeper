package com.example.javalab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Switch switchButton;
    TextView teamName;
    TextView teamFirstScore;
    TextView teamSecondScore;
    Button plusScore;
    Button minusScore;
    Spinner getSpinner;

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
        getSpinner = findViewById(R.id.score_values);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.score_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getSpinner.setAdapter(adapter);
        getSpinner.setOnItemSelectedListener(this);



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
        switch (view.getId()){
            case R.id.plusScore:
                    System.out.println("Team 1");
                    if(teamName.getText().toString().equals("Team 1")) {
                        System.out.println("test");
                        value = Integer.parseInt(teamFirstScore.getText().toString().replaceAll("[^0-9]", ""));
                        System.out.println(value + " Goals");
                        value += 1;
                        teamFirstScore.setText(value + " Goals");
                    } else if(teamName.getText().toString().equals("Team 2")) {
                        value = Integer.parseInt(teamSecondScore.getText().toString().replaceAll("[^0-9]", ""));
                        value += 1;
                        teamSecondScore.setText(value + " Goals");
                    }
                    break;
            case R.id.minusScore:
                if(teamName.getText().toString().equals("Team 1")) {
                    value = Integer.parseInt(teamFirstScore.getText().toString().replaceAll("[^0-9]", ""));
                    value -= 1;
                    value = value < 0 ? 0 : value;
                    teamFirstScore.setText(value + " Goals");
                }else if(teamName.getText().toString().equals("Team 2")) {
                    value = Integer.parseInt(teamSecondScore.getText().toString().replaceAll("[^0-9]", ""));
                    value -= 1;
                    value = value < 0 ? 0 : value;
                    teamSecondScore.setText(value + " Goals");
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String getScore = adapterView.getItemAtPosition(i).toString();
        if(getScore.equals("Score")) return;
        int value = 0;
        int increaseScoreBy = Integer.parseInt(getScore);
        if(teamName.getText().toString().equals("Team 1")) {
            value = Integer.parseInt(teamFirstScore.getText().toString().replaceAll("[^0-9]", ""));
            value += increaseScoreBy;
            teamFirstScore.setText(value + " Goals");
        } else if(teamName.getText().toString().equals("Team 2")) {
            value = Integer.parseInt(teamSecondScore.getText().toString().replaceAll("[^0-9]", ""));
            value += increaseScoreBy;
            teamSecondScore.setText(value + " Goals");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}