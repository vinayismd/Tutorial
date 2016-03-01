package com.example.thenewproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.view.View;

public class MyBringBack extends View {
    Bitmap grball;
    float changingY;
	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		grball = BitmapFactory.decodeResource(getResources(), R.drawable.gball);
		changingY=0;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint textpaint = new Paint();
		
		textpaint.setARGB(20, 245, 100, 177);
		textpaint.setTextSize(50);
		textpaint.setTextAlign(Align.CENTER);
	
		canvas.drawText("my bring back", canvas.getWidth()/2, 200, textpaint);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(grball, (canvas.getWidth()/2), changingY, null);
		
		
		if(changingY < canvas.getHeight()){
			changingY += 10;
		}else{
			changingY=0;
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 300, canvas.getWidth(), 400);
		Paint ourblue = new Paint();
		ourblue.setColor(Color.RED);
		canvas.drawRect(middleRect, ourblue);
		invalidate();
	}

}
