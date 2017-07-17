package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.R;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.Constant;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.Rabbit;

import static com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication.typefaceManager;

public class FontActivity extends AppCompatActivity {
    private TextView mTextView;
    private AVLoadingIndicatorView indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);

        SharedPreferences prefs = MainApplication.get().getDefaultSharedPreferences();
        final SharedPreferences.Editor editor = prefs.edit();


        mTextView = (TextView) findViewById(R.id.mm_test_text);
        ImageButton imgBtnUnseen = (ImageButton) findViewById(R.id.cantseeButton);
        ImageButton imgBtnSeen = (ImageButton) findViewById(R.id.seeButton);
        indicator = (AVLoadingIndicatorView) findViewById(R.id.loading_indicatior);

        imgBtnUnseen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String converted_text = "မြန်မာနို်င်ငံ";
                mTextView.setText(Rabbit.uni2zg(converted_text));
                mTextView.setTypeface(typefaceManager.getZawgyi());

                editor.putBoolean(Constant.IS_ZG_FORCE, true);
                editor.apply();

                DelayAndSwitchActivity();
            }
        });
        imgBtnSeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean(Constant.IS_ZG_FORCE, false);
                editor.apply();
                DelayAndSwitchActivity();
            }
    });
    }
        private void DelayAndSwitchActivity() {
            indicator.setVisibility(View.VISIBLE);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(FontActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }
    }

