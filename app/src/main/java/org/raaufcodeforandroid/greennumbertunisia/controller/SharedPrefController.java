package org.raaufcodeforandroid.greennumbertunisia.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefController {
    private static final String SHARED_PREF_NAME="GREEN_PHONES_NUMBERS_TUNISIA";
    private static final String KEY_LANGUAGE="LANGUAGE";
    private static final  String KEY_LAST_PHONE="LAST_PHONE_CALLED";
    private static final  String KEY_LAST_PHONE_NUMBER="LAST_PHONE_NUMBER_CALLED";
    private static final String KEY_BEFORE_LAST_PHONE="BEFORE_LAST_PHONE_CALLED";
    private static final String KEY_BEFORE_LAST_PHONE_NUMBER="BEFORE_LAST_PHONE_NUMBER_CALLED";

    private final Context context;
    private static SharedPrefController sharedPrefController;
    public SharedPrefController(Context context){this.context=context;}

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

    public void set_last_called_phone(String name, String number){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_LAST_PHONE, name);
        editor.putString(KEY_LAST_PHONE_NUMBER, number);
        editor.apply();
    }
    public String get_last_phone(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LAST_PHONE, null);
    }
    public String get_last_phone_number(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LAST_PHONE_NUMBER, null);
    }

    public void set_before_last_phone(String name, String number){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_BEFORE_LAST_PHONE, name);
        editor.putString(KEY_BEFORE_LAST_PHONE_NUMBER, number);
        editor.apply();
    }

    public String get_before_last_phone(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BEFORE_LAST_PHONE, null);
    }
    public String get_before_last_phone_number(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BEFORE_LAST_PHONE_NUMBER, null);
    }

    public boolean contain_historic(){
        return get_last_phone() != null ;
    }
    public boolean shared_pref_contain_lang(){
        return this.get_language()!=null;
    }

}
