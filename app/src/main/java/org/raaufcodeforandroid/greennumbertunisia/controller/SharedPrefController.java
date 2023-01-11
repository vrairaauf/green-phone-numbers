package org.raaufcodeforandroid.greennumbertunisia.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefController {
    private static final String SHARED_PREF_NAME="GREEN_PHONES_NUMBERS_TUNISIA";
    private static final String KEY_LANGUAGE="LANGUAGE";

    private static Context context;
    private static SharedPrefController sharedPrefController;
    public SharedPrefController(Context context){context=context;}
    public static synchronized SharedPrefController get_instance(Context context){
        if(sharedPrefController==null){
            sharedPrefController=new SharedPrefController(context);
        }
        return sharedPrefController;
    }
    public void set_language(String lang){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_LANGUAGE, lang);
        editor.apply();
    }

    public String get_language(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LANGUAGE, null);
    }


}
