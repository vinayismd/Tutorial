package com.example.thenewproject;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;


public class Textvoice extends Activity implements  android.view.View.OnClickListener{
	
	static final String[] texts = {
		"whaaats up " , "you luks gus " , "i like u "
	};
	TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textvoice);
		
		Button b =(Button)findViewById(R.id.btextvoice);
		b.setOnClickListener(this);
		
		tts = new TextToSpeech(Textvoice.this , new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status != TextToSpeech.ERROR){
					tts.setLanguage(Locale.US);
				}
				
			}
		} );
	}

	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		String random = texts[r.nextInt(3)];
		tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
		
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
		if(tts != null){
			tts.stop();
			tts.shutdown();
			super.onPause();
		}
	}
	
	

}
