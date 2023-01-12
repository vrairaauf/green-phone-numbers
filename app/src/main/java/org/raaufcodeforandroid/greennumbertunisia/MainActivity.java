package org.raaufcodeforandroid.greennumbertunisia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.raaufcodeforandroid.greennumbertunisia.controller.SharedPrefController;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button english, french, arabic;
    SharedPrefController sharedPrefController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        english=findViewById(R.id.english_lang_button);
        french=findViewById(R.id.french_lang_button);
        arabic=findViewById(R.id.arabic_lang_button);

        sharedPrefController=SharedPrefController.get_instance(this.getApplicationContext());

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the lang of app to english
                sharedPrefController.set_language("en");
                change_intent();
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefController.set_language("fr");
                change_intent();
                // change the lang of app to french
            }
        });
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the lang of app to arabic
                sharedPrefController.set_language("ar");
                change_intent();
            }
        });

    }
    private void change_intent(){
        Intent intent=new Intent(getApplicationContext(), CoreActivity.class);
        startActivity(intent);
    }




}