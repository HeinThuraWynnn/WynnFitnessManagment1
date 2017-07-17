package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tayote on 7/16/16.
 */
public class UnicodeDetect {

    public static boolean isMMUnicode(CharSequence text) {

        String regexUni = "[ဃငဆဇဈဉညဋဌဍဎဏဒဓနဘရဝဟဠအ]်|ျ[က-အ]ါ|ျ[ါ-း]|\u103e|\u103f|\u1031[^\u1000-\u1021\u103b\u1040\u106a\u106b\u107e-\u1084\u108f\u1090]|\u1031$|\u1031[က-အ]\u1032|\u1025\u102f|\u103c\u103d[\u1000-\u1001]|ည်း|ျင်း|င်|န်း|ျာ|င့်";
        String regexZG = "\\s\u1031| ေ[က-အ]်|[က-အ]း";

        Pattern uniPattern = Pattern.compile(regexUni);
        Pattern zgPattern = Pattern.compile(regexZG);

        Matcher uniMatch = uniPattern.matcher(text);
        Matcher zgMatch = zgPattern.matcher(text);

        Log.i("ggwp", uniMatch+"");
        Log.i("ggwp", zgMatch+"");

        int uniMatchCount = 0;
        int zgMatchCount = 0;

        while (uniMatch.find()) {
            uniMatchCount++;
            Log.i("ggwp", uniMatchCount+"");
        }

        while (zgMatch.find()) {
            zgMatchCount++;
            Log.i("ggwp1", zgMatchCount+"");
        }

        if (uniMatchCount > 0) {
            //possible unicode
            //let check possible zagwyi
            if (zgMatchCount > 0) {
                //possible zawgyi =.=
                if (uniMatchCount > zgMatchCount) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;

    }

}
