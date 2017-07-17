package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.R;


public class IntroActivity extends AppCompatActivity {

    Button button_next;
    TextView introText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        introText = (TextView)findViewById(R.id.introText);
        button_next = (Button)findViewById(R.id.btn_next);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
