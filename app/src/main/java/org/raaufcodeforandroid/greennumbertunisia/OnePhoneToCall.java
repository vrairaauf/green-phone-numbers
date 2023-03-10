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

import java.util.Objects;

public class OnePhoneToCall extends AppCompatActivity {

    private TextView phone_name, phone_number;
    private ImageButton call_button;
    private static final int REQUEST_CODE_CALL_PERMISSION=101;

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
        }, REQUEST_CODE_CALL_PERMISSION);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        if (requestCode == REQUEST_CODE_CALL_PERMISSION) {
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
        if(sharedPrefController.get_last_phone()!=null && !Objects.equals(sharedPrefController.get_last_phone_number(), phone_number.getText().toString())){
            sharedPrefController.set_before_last_phone(sharedPrefController.get_last_phone(), sharedPrefController.get_last_phone_number());
        }
        sharedPrefController.set_last_called_phone(phone_name.getText().toString(), phone_number.getText().toString());
    }
}