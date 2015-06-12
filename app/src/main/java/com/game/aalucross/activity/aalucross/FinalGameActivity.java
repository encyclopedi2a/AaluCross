package com.game.aalucross.activity.aalucross;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class FinalGameActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_game);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
