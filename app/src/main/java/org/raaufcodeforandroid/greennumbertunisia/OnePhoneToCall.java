package org.raaufcodeforandroid.greennumbertunisia;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.raaufcodeforandroid.greennumbertunisia.controller.SharedPrefController;

public class OnePhoneToCall extends AppCompatActivity {

    TextView phone_name, phone_number;
    ImageButton call_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_phone_to_call);

        Bundle data=getIntent().getExtras();
        call_button=findViewById(R.id.call_button_all_phones_numbers);

        phone_name=findViewById(R.id.phone_name_come_from_all_phones_numbers);

        phone_number=findViewById(R.id.phone_number_come_from_all_phones_numbers);


        phone_name.setText(data.getString("phone_name"));
        phone_number.setText(data.getString("phone_number"));
        if(!checkPermission()){

            requestPermission();
        }
        call_button.setOnClickListener(v -> call());


    }


    private Boolean checkPermission(){
        int permission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
        return permission== PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(OnePhoneToCall.this, new String[]{
                Manifest.permission.CALL_PHONE,
        }, 101);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        if (requestCode == 101) {
            call_button = findViewById(R.id.call_button_all_phones_numbers);
            if (grantResult.length > 0) {
                boolean callPermission = grantResult[0] == PackageManager.PERMISSION_GRANTED;
                if (!callPermission) {
                    call_button.setEnabled(false);
                }
            }
        }
    }

    /*-------------------------------------*/
    public  void  call(){

        String dial;
        String phoneNumberStr=phone_number.getText().toString();
        if(!TextUtils.isEmpty(phoneNumberStr)) {
            dial = "tel:" + phoneNumberStr;

            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            save_historic();
            startActivity(new Intent( Intent.ACTION_CALL, Uri.parse(dial) ));
        }

    }
    private void save_historic(){
        SharedPrefController sharedPrefController = SharedPrefController.get_instance(getApplicationContext());
        if(sharedPrefController.get_last_phone()!=null){
            sharedPrefController.set_before_last_phone(sharedPrefController.get_last_phone(), sharedPrefController.get_last_phone_number());
        }
        sharedPrefController.set_last_called_phone(phone_name.getText().toString(), phone_number.getText().toString());
    }
}