package org.raaufcodeforandroid.greennumbertunisia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button english, french, arabic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        english=findViewById(R.id.english_lang_button);
        french=findViewById(R.id.french_lang_button);
        arabic=findViewById(R.id.arabic_lang_button);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the lang of app to english
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the lang of app to french
            }
        });
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the lang of app to arabic
            }
        });
    }
}