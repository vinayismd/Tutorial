package com.example.thenewproject;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Seekbarvolume extends Activity implements OnSeekBarChangeListener {
	
	MediaPlayer mp;
	SeekBar sb;
	AudioManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbarvolume);
		sb = (SeekBar)findViewById(R.id.sbvolume);
		mp = MediaPlayer.create(this ,R.raw.sound);
		mp.start();
		am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int maxv = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		int curv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		sb.setMax(maxv);
		sb.setProgress(curv);
		
		sb.setOnSeekBarChangeListener(this);
		
	}
	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mp.release();
	}



	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		// TODO Auto-generated method stub
		am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
