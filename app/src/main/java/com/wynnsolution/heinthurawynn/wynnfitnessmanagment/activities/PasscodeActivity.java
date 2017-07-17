package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.R;

import in.arjsna.passcodeview.PassCodeView;

public class PasscodeActivity extends AppCompatActivity {

    PassCodeView passCodeView;
    TextView txtEnterPasscode;
    SharedPreferences prefs;
    String InfoText;
    String confirmText;
    boolean firstInput = true;
    String passcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);

        passCodeView = (PassCodeView) findViewById(R.id.pass_code_view);
        passCodeView.setTypeFace(MainApplication.typefaceManager.getPasscodeFont());

        txtEnterPasscode = (TextView) findViewById(R.id.txtPasscodeNoti);

        prefs = MainApplication.get().getDefaultSharedPreferences();

        InfoText = "Enter Privacy Passcode";
        confirmText = "Retype Your Passcode";

        txtEnterPasscode.setText(InfoText);

        passCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override
            public void onTextChanged(String text) {
                if (text.length() == 4){
                    if(firstInput){
                        passcode = text;
                        passCodeView.reset();
                        firstInput = false;
                        txtEnterPasscode.setText(confirmText);
                    } else {
                        if (text.equals(passcode)){
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("passcode", text);
                            editor.apply();
                            Intent intent = new Intent(PasscodeActivity.this, IntroActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            txtEnterPasscode.setText(InfoText);
                            Toast.makeText(getApplicationContext(), "Passcode does not match !", Toast.LENGTH_SHORT).show();
                            firstInput = true;
                            passCodeView.setError(true);
                        }
                    }
                }
            }
        });

    }
}
