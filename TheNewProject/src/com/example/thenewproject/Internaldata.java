package com.example.thenewproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Internaldata extends Activity implements
		android.view.View.OnClickListener {
	
	TextView dataresult;
	EditText shareddata;
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internaldata);

		dataresult = (TextView) findViewById(R.id.tvshrdfref);
		shareddata = (EditText) findViewById(R.id.etshrdpref);
		Button save = (Button) findViewById(R.id.bshrdprefsave);
		Button load = (Button) findViewById(R.id.bsrdprefload);
		save.setOnClickListener(this);
		load.setOnClickListener(this);

		
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bshrdprefsave:

			String data = shareddata.getText().toString();
			// saving data via file
			/*
			 * File f = new File(FILENAME); try { fos = new FileOutputStream(f);
			 * //write some data fos.close(); } catch (FileNotFoundException e)
			 * { // TODfos.wO Auto-generated catch block e.printStackTrace(); }
			 */
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bsrdprefload:
			 new  loadSomeStuff().execute(FILENAME);			
			break;

		}

	}

	public class loadSomeStuff extends AsyncTask<String , Integer , String>{
	
	
   protected void onPreExecute(String f){
	   //for setting up something
	   f ="whatever";
   }
	
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
		FileInputStream fis = null;
		String collect = null;
		try {
			fis = openFileInput(FILENAME);
			byte[] dataarray = new byte [fis.available()];
			while(fis.read(dataarray) != -1){
				collect = new String(dataarray);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		try {
			fis.close();
			return collect;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			return null;
		};
}
	
	protected void onProgressUpdate(Integer...progress){
		
	}
	
	
	protected void onPostExecute(String result){
		dataresult.setText(result);
	}
}