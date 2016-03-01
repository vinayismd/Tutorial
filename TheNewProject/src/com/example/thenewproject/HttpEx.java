package com.example.thenewproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpEx extends Activity {

	TextView httpstuff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpstuff = (TextView) findViewById(R.id.tvhttp);
		GetMethodEx test = new GetMethodEx();
		String returned;
		try {
			returned = test.getIntenetData();
			httpstuff.setText(returned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
