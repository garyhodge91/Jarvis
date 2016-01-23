package com.example.actions;

import android.content.Context;
import android.os.Vibrator;

public class vibrateActionDef implements IActionDef {

	@Override
	public void execute(String param1, String param2, String param3,
			Context context) {
		// TODO Auto-generated method stub
		Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);
		
	}

}
