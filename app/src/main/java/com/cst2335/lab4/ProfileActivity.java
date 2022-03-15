package com.cst2335.lab4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class ProfileActivity extends AppCompatActivity {
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    ImageButton takePicture;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button goToChat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profileactivity);
        //get Intent from MainActivity
        Intent loginPage = getIntent();
        goToChat = (Button)findViewById(R.id.btnGotoChat);
        String emailType = loginPage.getStringExtra("emailType");
        EditText enterEmail = (EditText)findViewById(R.id.typeEmalprofle);
        enterEmail.setText(emailType);
        takePicture = (ImageButton)findViewById(R.id.takePicture);
        takePicture.setOnClickListener(c -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });
        goToChat.setOnClickListener( b -> {

            //Give directions to go from this page, to SecondActivity
            Intent nextPage = new Intent(ProfileActivity.this, ChatRoomActivity.class);
            //Now make the transition:
            startActivityForResult(nextPage, 345);
        });
        Log.e(ACTIVITY_NAME, "In function: onCreate"  /* replace with function name */);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            takePicture.setImageBitmap(imageBitmap);
        }
        Log.e(ACTIVITY_NAME, "In function: onActivityResult"  /* replace with function name */);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ACTIVITY_NAME, "In function: onStart"  /* replace with function name */);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME, "In function: onResume"  /* replace with function name */);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(ACTIVITY_NAME, "In function: onPause"  /* replace with function name */);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function: onStop"  /* replace with function name */);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function: onDestroy"  /* replace with function name */);
    }
}