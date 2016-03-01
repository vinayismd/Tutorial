package com.example.thenewproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate  extends Activity implements SensorEventListener{
	
	float x , y ,sensorx , sensory;
	Bitmap ball;
	SensorManager sm;
	MyBringBackSurface ourSurfaceView;
	
	public class MyBringBackSurface extends SurfaceView implements Runnable {
		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MyBringBackSurface(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			ourHolder = getHolder();

		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;

				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(06, 06, 255);
				float centrex = canvas.getWidth()/2;
				float centrey = canvas.getHeight()/2;
				canvas.drawBitmap(ball, centrex + sensorx*20, centrey + sensory*20, null);
				
				ourHolder.unlockCanvasAndPost(canvas);
			}

		}
	
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new MyBringBackSurface(this));
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		if(sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0){
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.gball);
		x = y = sensorx = sensory = 0;
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.resume();
		setContentView(ourSurfaceView);
		
	}
	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sm.unregisterListener(this);
		super.onPause();
		
	}



	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(16);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sensorx = e.values[0];
		sensory = e.values[1];
		
	}

}
