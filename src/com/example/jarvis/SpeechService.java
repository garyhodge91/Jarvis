package com.example.jarvis;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.RecognitionListener;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.telephony.SmsManager;
import android.util.Log;

public class SpeechService extends RecognitionService {

	private SpeechRecognizer m_EngineSR = null;
	private static final String TAG = "MyStt3Activity";
	private Intent intent;

	public void stopListening() {
		if (m_EngineSR != null) {

			m_EngineSR.stopListening();
		}

	}

	public void listen() {
		if (m_EngineSR == null) {
			m_EngineSR = SpeechRecognizer.createSpeechRecognizer(this);
			m_EngineSR.setRecognitionListener(new listener());
		}
		intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
		intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
				this.getPackageName());
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

		Log.d(TAG, "Starting to listen");
		m_EngineSR.startListening(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("SimpleVoiceService", "Service started");

		listen();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("SimpleVoiceService", "Service stopped");
	}

	@Override
	protected void onCancel(Callback listener) {
		Log.i("SimpleVoiceService", "onCancel");
		m_EngineSR.cancel();
	}

	@Override
	protected void onStartListening(Intent recognizerIntent, Callback listener) {
		Log.i("SimpleVoiceService", "onStartListening");
		m_EngineSR.setRecognitionListener(new listener());
		m_EngineSR.startListening(recognizerIntent);
	}

	@Override
	protected void onStopListening(Callback listener) {
		Log.i("SimpleVoiceService", "onStopListening");
		m_EngineSR.stopListening();
	}

	/**
     * 
     */
	class listener implements RecognitionListener {
		public void onReadyForSpeech(Bundle params) {
			Log.d(TAG, "onReadyForSpeech");
		}

		public void onBeginningOfSpeech() {
			Log.d(TAG, "onBeginningOfSpeech");
		}

		public void onRmsChanged(float rmsdB) {
			// Log.d(TAG, "onRmsChanged");
		}

		public void onBufferReceived(byte[] buffer) {
			Log.d(TAG, "onBufferReceived");
		}

		public void onEndOfSpeech() {
			Log.d(TAG, "onEndofSpeech");
		}

		public void onError(int errorCode) {
			Log.d(TAG, "Error " + errorCode);
			// if ((errorCode == SpeechRecognizer.ERROR_NO_MATCH)
			// || (errorCode == SpeechRecognizer.ERROR_SPEECH_TIMEOUT))
			// {
			// m_EngineSR.startListening(intent);
			// // listen();
			// }else {

			// mText.setText("error " + error);
			m_EngineSR.stopListening();
			m_EngineSR.destroy();
			m_EngineSR = null;
			listen();
			// }
			// }
		}

		public void onResults(Bundle results) {
			Log.d(TAG, "onResults");
			String str = new String();

			Log.d(TAG, "onResults " + results);
			ArrayList data = results
					.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
			str = (String) data.get(0);
			if (str.startsWith("Jarvis")) {
				int index = str.indexOf(" ");
				if (index > 0) {

					str = str.substring(str.indexOf(" ") + 1);
					Log.d(TAG, "str:" + str);
					if (str.equals("vibrate")) {
						Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
						vibrator.vibrate(2000); // vibrates the device for 2
												// second
					} else if (str.equals("text me")) {
						SmsManager sms = SmsManager.getDefault();
						sms.sendTextMessage("07795556166", null,
								"I spoke this", null, null);
					} else {
						String query = "";
						try {
							query = URLEncoder.encode(str, "utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String url = "http://www.google.com/search?q=" + query;
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse(url));
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
					}
				}
			}
			listen();
			// mText.setText("results: "+String.valueOf(data.size()));
		}

		public void onPartialResults(Bundle partialResults) {
			Log.d(TAG, "onPartialResults");
		}

		public void onEvent(int eventType, Bundle params) {
			Log.d(TAG, "onEvent " + eventType);
		}
	}

}