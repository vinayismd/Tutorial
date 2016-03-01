package com.example.thenewproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	MyBringBackSurface ourSurfaceView;
	float x, y, sx, sy, fx, fy,dx, dy ,anix ,aniy ,scaledx ,scaledy;
	Bitmap test, tri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		sx = 0;
		sy = 0;
		fx = 0;
		fy = 0;
		dx = dy = anix = aniy = scaledx = scaledy =0;
		test = BitmapFactory.decodeResource(getResources(), R.drawable.gball);
		tri = BitmapFactory.decodeResource(getResources(), R.drawable.triangle);
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = event.getX();
		y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sx = event.getX();
			sy = event.getY();
			dx = dy = anix = aniy = scaledx = scaledy =fx =fy=0;
			break;
		case MotionEvent.ACTION_UP:
			fx = event.getX();
			fy = event.getY();
			dx = fx - sx;
			dy = fy - sy;
			scaledx = dx/30;
			scaledy = dy/30;
			x = y =0;
			break;
		}

		return true;
	}

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
				if (x != 0 && y != 0) {

					canvas.drawBitmap(test, x - (test.getWidth() / 2), y
							- (test.getHeight() / 2), null);
				}
				if (sx != 0 && sy != 0) {

					canvas.drawBitmap(tri, sx - (tri.getWidth() / 2), sy
							- (tri.getHeight() / 2), null);
				}
				if (fx != 0 && fy != 0) {
					canvas.drawBitmap(test, fx - (test.getWidth() / 2)-anix, fy
							- (test.getHeight() / 2)-aniy, null);

					canvas.drawBitmap(tri, fx - (tri.getWidth() / 2), fy
							- (tri.getHeight() / 2), null);
				}
				anix = anix + scaledx;
				aniy = aniy + scaledy;
				ourHolder.unlockCanvasAndPost(canvas);
			}

		}
	}
}
