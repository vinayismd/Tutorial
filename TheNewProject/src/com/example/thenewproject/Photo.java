package com.example.thenewproject;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Photo extends Activity implements View.OnClickListener{
	
	
	ImageView iv;
	ImageButton ib;
	Button b;
	Intent i;
	int cameraData =0;
	Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}
	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView)findViewById(R.id.ivreturnedpic);
		ib = (ImageButton)findViewById(R.id.ibtakepic);
		b = (Button)findViewById(R.id.bsetwall);
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.ibtakepic:
			 i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			 startActivityForResult(i,cameraData);
			break;
			
		case R.id.bsetwall:
			try{
				getApplicationContext().setWallpaper(bmp);
			}catch(IOException e){
				e.printStackTrace();
			}
			
			break;
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp = (Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
