package com.example.jarvis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        // Start AEScreenOnOffService Service
         
        Intent i = new Intent(this, DetectSpeech.class);
        startService(i);
         
    }   
     
}
