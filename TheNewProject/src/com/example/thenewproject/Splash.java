package com.example.thenewproject;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
    MediaPlayer oursong;
	@Override
	protected void onCreate(Bundle savenature) {
		// TODO Auto-generated method stub
		super.onCreate(savenature);
		setContentView(R.layout.splash);
		oursong = MediaPlayer.create(Splash.this, R.raw.sound);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Boolean music = getPrefs.getBoolean("checkbox", true);
		if(music==true)
		oursong.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(4000);
				} catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openstartingpoint = new Intent("com.example.thenewproject.MENU");
					startActivity(openstartingpoint);
				}
			}
	};
	timer.start();

  }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
		finish();
	}
	
}
