 package com.example.thenewproject;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Textplay extends Activity implements View.OnClickListener  {

	Button chkcmd;
	ToggleButton pastog;
	EditText input;
	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		BacconAndEggs();
		
		pastog.setOnClickListener(this);
		chkcmd.setOnClickListener(this);
	}
	private void BacconAndEggs() {
		// TODO Auto-generated method stub
		chkcmd = (Button)findViewById(R.id.bResults);
		pastog = (ToggleButton)findViewById(R.id.toggleButton1);
		input = (EditText)findViewById(R.id.etcommands);
		display = (TextView)findViewById(R.id.tvResults);
		
	}
	
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.bResults:
			// TODO Auto-generated method stub
			String check = input.getText().toString();
			
			if(check.contentEquals("left")){
				display.setGravity(Gravity.LEFT);
			}else if(check.contentEquals("right")){
				display.setGravity(Gravity.RIGHT);
			}else if(check.contentEquals("centre")){
				display.setGravity(Gravity.CENTER);
			}else if(check.contentEquals("blue")){
				display.setTextColor(Color.BLUE);
			}else if(check.contentEquals("GOT")){
				Random crazy = new Random();
				display.setText("GOT");
				display.setTextSize(crazy.nextInt(77));
				display.setTextColor(Color.rgb(crazy.nextInt(266), crazy.nextInt(266), crazy.nextInt(266)));
				switch(crazy.nextInt(3)){
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.CENTER);
					break;
				case 2:
					display.setGravity(Gravity.RIGHT);
					break;
				}
			}
			else{
				display.setGravity(Gravity.CENTER);
				display.setText("notcorrect");
			}
			break;
			
		case R.id.toggleButton1:
			// TODO Auto-generated method stub
			if(pastog.isChecked()){
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				
			}else{
				input.setInputType(InputType.TYPE_CLASS_TEXT);
				
			}  
			break;
		}
	}

}
