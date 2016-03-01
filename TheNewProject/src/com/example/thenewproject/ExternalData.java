package com.example.thenewproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener {

	
	TextView canread;
	TextView canwrite;
	String state;
	boolean canw, canr;
	Spinner spinner ;
	String[] paths = { "music", "pictures", "downlaods" };
	 File path = null;
	 File file = null;
	 EditText savefile;
	 Button confirm , save;
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);

		

		canread = (TextView) findViewById(R.id.tvcanread);
		canwrite = (TextView) findViewById(R.id.tvcanwrite);
		confirm = (Button)findViewById(R.id.bconfirmsave);
		save = (Button)findViewById(R.id.bsavefile);
		savefile = (EditText)findViewById(R.id.etsaveas);
		confirm.setOnClickListener(this);
		save.setOnClickListener(this);
		
		
		checkstate();

		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				ExternalData.this,
				android.R.layout.simple_spinner_item, paths);

		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	private void checkstate() {
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			canread.setText("true");
			canwrite.setText("true");
			canw = canr = true;

		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			canread.setText("true");
			canwrite.setText("false");
			canw = false;
			canr = true;
		} else {
			canread.setText("false");
			canwrite.setText("false");
			canr = canw = false;

		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
	     int position = spinner.getSelectedItemPosition();
	     switch(position){
	     case 0 :
	    	 path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
	    	 break;
	    	 
	     case 1:
	    	 path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
	    	 break;
	    	 
	     case 2:
	    	 path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	    	 break;
	    	 
	     
	     
	     }
	     
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bconfirmsave:
			save.setVisibility(View.VISIBLE);
			break;
			
		case R.id.bsavefile:
			
			String f = save.getText().toString();
			file = new File(path , f + ".png");
			
			checkstate();
			if(canr ==canw){
			
			  path.mkdirs();
			try {
				
				InputStream is = getResources().openRawResource(R.drawable.gball);
				OutputStream os = new FileOutputStream(file);
				byte[] data = new byte[is.available()];
				is.read(data);
				os.write(data);
				is.close();
				os.close();
				
				Toast t = Toast.makeText(ExternalData.this, "the file has been saved", Toast.LENGTH_LONG);
				t.show();
				
				
				//update file for user to use
				MediaScannerConnection.scanFile(ExternalData.this, new String[] {file.toString()},
						null, new MediaScannerConnection.OnScanCompletedListener() {
							
							@Override
							public void onScanCompleted(String arg0, Uri arg1) {
								// TODO Auto-generated method stub
								Toast t = Toast.makeText(ExternalData.this, "Scan completed", Toast.LENGTH_SHORT);
								t.show();
							}
						});
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
		
		}
		
		}
	}

	
}
