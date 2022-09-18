package com.example.mylab2;

import android.content.Context;
import android.widget.Toast;

public class Util {

    public static int countWords(String input) {
        String[] words = input.split("[ .,]+");
        return words.length;
    }

    public static Integer countChars(String input) {
        return input.replaceAll("[ .,]+", "").length();
    }

    public static void showToast( String text, Context context) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
