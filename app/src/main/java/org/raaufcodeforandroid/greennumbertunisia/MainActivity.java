package org.raaufcodeforandroid.greennumbertunisia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.raaufcodeforandroid.greennumbertunisia.controller.SharedPrefController;

public class MainActivity extends AppCompatActivity {
    Button english, french, arabic;
    SharedPrefController sharedPrefController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefController=SharedPrefController.get_instance(this.getApplicationContext());
        if(sharedPrefController.shared_pref_contain_lang())
            change_intent();
        english=findViewById(R.id.english_lang_button);
        french=findViewById(R.id.french_lang_button);
        arabic=findViewById(R.id.arabic_lang_button);



        english.setOnClickListener(v -> {
            // change the lang of app to english
            sharedPrefController.set_language("en");
            change_intent();
        });
        french.setOnClickListener(v -> {
            sharedPrefController.set_language("fr");
            change_intent();
            // change the lang of app to french
        });
        arabic.setOnClickListener(v -> {
            // change the lang of app to arabic
            sharedPrefController.set_language("ar");
            change_intent();
        });

    }
    private void change_intent(){
        Intent intent=new Intent(getApplicationContext(), CoreActivity.class);
        startActivity(intent);
    }




}