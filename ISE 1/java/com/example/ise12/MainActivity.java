package com.example.ise12;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSelectContact;
    ImageButton btnCall, btnSMS, btnWhatsapp;

    String phoneNumber = "";

    static final int PICK_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectContact = findViewById(R.id.btnSelectContact);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);

        // Select Contact
        btnSelectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI);

                startActivityForResult(intent, PICK_CONTACT);
            }
        });

        // Call
        btnCall.setOnClickListener(v -> {

            if(phoneNumber.isEmpty()){
                Toast.makeText(MainActivity.this,"Select Contact First",Toast.LENGTH_SHORT).show();
                return;
            }

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        // SMS
        btnSMS.setOnClickListener(v -> {

            if(phoneNumber.isEmpty()){
                Toast.makeText(MainActivity.this,"Select Contact First",Toast.LENGTH_SHORT).show();
                return;
            }

            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + phoneNumber));
            startActivity(smsIntent);
        });

        // WhatsApp
        btnWhatsapp.setOnClickListener(v -> {

            if(phoneNumber.isEmpty()){
                Toast.makeText(MainActivity.this,"Select Contact First",Toast.LENGTH_SHORT).show();
                return;
            }

            Intent waIntent = new Intent(Intent.ACTION_VIEW);
            waIntent.setData(Uri.parse("https://wa.me/" + phoneNumber));
            startActivity(waIntent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {

            Uri contactUri = data.getData();

            Cursor cursor = getContentResolver().query(contactUri,
                    null, null, null, null);

            if(cursor != null && cursor.moveToFirst()){

                int numberIndex = cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER);

                phoneNumber = cursor.getString(numberIndex);

                Toast.makeText(this,"Selected: "+phoneNumber,Toast.LENGTH_SHORT).show();

                cursor.close();
            }
        }
    }
}