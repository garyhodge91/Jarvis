package com.example.jarvis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{
 
	Button newCommand;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        // Start AEScreenOnOffService Service
         
        Intent i = new Intent(this, DetectSpeech.class);
        startService(i);
        
        newCommand = (Button) findViewById(R.id.newCommand);
        newCommand.setOnClickListener(this);
         
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this, AddNewCommand.class);
		startActivityForResult(intent, 0);
		
	}   
     
}
