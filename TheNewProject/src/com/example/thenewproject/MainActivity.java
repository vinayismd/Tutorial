package com.example.thenewproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    
	int counter;
	Button add , subs;
	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		counter=0;
		add = (Button)findViewById(R.id.button1);
		subs = (Button)findViewById(R.id.button2);
		display = (TextView)findViewById(R.id.textView1);
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter++;
				display.setText("YOUR TOTAL IS "+counter);
			}
		});
        subs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter--;
				display.setText("YOUR TOTAL IS "+counter);
			}
		});
	}

	

}
