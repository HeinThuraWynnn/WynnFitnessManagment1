package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.R;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.Constant;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean isZawgyiForced;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeText = (TextView) findViewById(R.id.welcomeText);

        prefs = MainApplication.get().getDefaultSharedPreferences();
        isZawgyiForced = prefs.getBoolean(Constant.IS_ZG_FORCE, false);

        if(isZawgyiForced){
            welcomeText.setText(getString(R.string.welcometext_Zg));
            welcomeText.setTypeface(MainApplication.typefaceManager.getZawgyi());
        }else{
            welcomeText.setTypeface(MainApplication.typefaceManager.getUnicode());
            }

            Button btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, FrontActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
