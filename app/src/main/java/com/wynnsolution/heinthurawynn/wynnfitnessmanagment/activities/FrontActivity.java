package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.R;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.Constant;

import java.util.List;

public class FrontActivity extends AppCompatActivity implements Validator.ValidationListener{
    boolean isZawgyiForced;
    SharedPreferences prefs;

    @NotEmpty
    EditText edtadmin;
    Button btn_next;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        validator = new Validator(this);
        validator.setValidationListener(this);

        prefs = MainApplication.get().getDefaultSharedPreferences();
        isZawgyiForced = prefs.getBoolean(Constant.IS_ZG_FORCE, false);

        edtadmin = (EditText) findViewById(R.id.edtadmin);
        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

        if(isZawgyiForced){
            edtadmin.setHint(getString(R.string.hint_admin_name_Zg));
            edtadmin.setTypeface(MainApplication.typefaceManager.getZawgyi());

        }else {
            edtadmin.setTypeface(MainApplication.typefaceManager.getUnicode());
        }

    }

    @Override
    public void onValidationSucceeded() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("edtadmin", edtadmin.getText().toString());
        editor.apply();
        Intent intent = new Intent(FrontActivity.this, PasscodeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error: errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if(view instanceof EditText){
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

}
