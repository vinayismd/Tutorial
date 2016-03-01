package com.example.thenewproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener{
    
	TextView dataresult;
	EditText shareddata;
	public static String filename ="My shared data"; 
	SharedPreferences somedata;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		 
		dataresult = (TextView)findViewById(R.id.tvshrdfref);
		shareddata = (EditText)findViewById(R.id.etshrdpref);
		Button save = (Button)findViewById(R.id.bshrdprefsave);
		Button load = (Button)findViewById(R.id.bsrdprefload);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		
		somedata = getSharedPreferences(filename, 0);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bshrdprefsave:
			String stringdata = shareddata.getText().toString();
			SharedPreferences.Editor editor =somedata.edit();
			editor.putString("sharedstring", stringdata);
			editor.commit();
			break;
		case R.id.bsrdprefload:
			somedata = getSharedPreferences(filename, 0);
			String datareturned = somedata.getString("sharedstring", "data could not be loaded");
			dataresult.setText(datareturned);
			break;
		}
		
	}
	

}
