package com.example.tp023;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ShareCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reponse() ;
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }


    public void openWebsite(View view) {
        // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }


    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }
    public void camera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
    public void reponse(){
        Log.d(TAG,"Question 1") ;
        Log.d(TAG,"new Intent(String action)") ;

        Log.d(TAG,"Question 2") ;
        Log.d(TAG,"Résolvez l'intention avec le système avant d'appeler" +
                " startActivity() ou startActivityforResult().") ;

        Log.d(TAG,"Question 3") ;
        Log.d(TAG,"Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);") ;



    }
}