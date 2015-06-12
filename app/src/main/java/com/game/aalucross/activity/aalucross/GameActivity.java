package com.game.aalucross.activity.aalucross;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class GameActivity extends Activity implements View.OnClickListener {
    private Button button;
    private RadioButton firstRadio, secondRadio;
    private String radioInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        firstRadio = (RadioButton) findViewById(R.id.radioButton);
        firstRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstRadio.setSoundEffectsEnabled(true);
                firstRadio.setChecked(true);
                secondRadio.setChecked(false);
                radioInstanceState = "onePlayerGame";
            }
        });
        secondRadio = (RadioButton) findViewById(R.id.radioButton1);
        secondRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondRadio.setSoundEffectsEnabled(true);
                secondRadio.setChecked(true);
                firstRadio.setChecked(false);
                radioInstanceState = "twoPlayerGame";
            }
        });
    }

    @Override
    public void onClick(View v) {
        if ((!firstRadio.isChecked()) && !secondRadio.isChecked()) {
            Toast.makeText(getApplicationContext(), "Please Select Type Of Game", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(GameActivity.this, NamePickerActivity.class);
            intent.putExtra("radioInstanceState",radioInstanceState);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new ExitDialog(this).returnDialog();
        dialog.show();
        dialog.getWindow().setLayout(650, 250);
    }
}
