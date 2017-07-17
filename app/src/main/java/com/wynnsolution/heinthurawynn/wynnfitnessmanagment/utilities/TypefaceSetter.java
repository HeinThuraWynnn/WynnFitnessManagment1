package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities;

import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.MainApplication;

/**
 * Created by Hein Thura Wynn on 7/9/2017.
 */

public class TypefaceSetter
{
    private static Typeface typefaceZg, typefaceUni;
    public static boolean isZawgyiForced;

    public TypefaceSetter(boolean isZawgyiForced){
        this.isZawgyiForced = isZawgyiForced;
        typefaceZg = MainApplication.typefaceManager.getZawgyi();
        typefaceUni = MainApplication.typefaceManager.getUnicode();
    }
    public void Setter(TextView textView, String textZg, String textUni) {
        if (isZawgyiForced) {
            textView.setText(textZg);
            textView.setTypeface(typefaceZg);
        } else {
            textView.setText(textUni);
            textView.setTypeface(typefaceUni);
        }
    }
    public void Setter(EditText editText, String textZg, String txtUni){
        if (isZawgyiForced) {
            editText.setText(textZg);
            editText.setTypeface(typefaceZg);
        }else {
            editText.setText(txtUni);
            editText.setTypeface(typefaceUni);
        }
    }
    public void Setter(EditText editText, String textZg, String textUni, String hintZg, String hintUni){
        if(isZawgyiForced){
            editText.setHint(hintZg);
            editText.setText(textZg);
            editText.setTypeface(typefaceZg);
        }else{
            editText.setHint(hintUni);
            editText.setText(textUni);
            editText.setTypeface(typefaceUni);
        }
    }
    public void Setter(EditText editText, String text, String hintZg, String hintUni){
        if(isZawgyiForced){
            editText.setHint(hintZg);
            editText.setTypeface(typefaceZg);
        }else{
            editText.setHint(hintUni);
            editText.setTypeface(typefaceUni);
        }
    }
    public void Setter(Button button, String textZg, String textUni){
        if(isZawgyiForced){
            button.setText(textZg);
            button.setTypeface(typefaceZg);
        }else {
            button.setText(textUni);
            button.setTypeface(typefaceUni);
        }
    }

}