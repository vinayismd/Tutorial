package com.example.thenewproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {
	
	Button start , startfor;
	EditText sendET;
	TextView gotAns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		start = (Button)findViewById(R.id.bSA);
		startfor = (Button)findViewById(R.id.bSAFR);
		sendET = (EditText)findViewById(R.id.etsend);
		gotAns = (TextView)findViewById(R.id.tvgot);
		start.setOnClickListener(this);
		startfor.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle Basket = new Bundle();
			Basket.putString("key", bread);
			Intent a = new Intent(Data.this , OpenedClass.class);
			a.putExtras(Basket);
			startActivity(a);
			break;
			
		case R.id.bSAFR:
			Intent i = new Intent(Data.this , OpenedClass.class);
			startActivityForResult(i,0);
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK);
		Bundle Basket = data.getExtras();
		String s = Basket.getString("answer");
		gotAns.setText(s);
	}

	

}
