package com.example.thenewproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	
	Button scroll;
	EditText editText1,editText2,editText3,editText4,editText5,editText6;
	String fname,lname, fathername,mothername,myemail,myaddrs;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializevar();
		scroll.setOnClickListener(this);
	}



	private void initializevar() {
		// TODO Auto-generated method stub
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		editText3 = (EditText)findViewById(R.id.editText3);
		editText4 = (EditText)findViewById(R.id.editText4);
		editText5 = (EditText)findViewById(R.id.editText5);
		editText6 = (EditText)findViewById(R.id.editText6);
		scroll = (Button)findViewById(R.id.button1);
	}



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Convertedittexttostring();
		String message = "well hello"
				        + "my name is "
				         + fname 
				         + lname
				         + ".my fathers name is "
				         +fathername
				         +".my mother name is"
				         +mothername
				         +".my email is"
				         +myemail
				         +"and my address is"
				         +myaddrs
				         +'\n' +"thats all";
		
		Intent Mydetail = new Intent(android.content.Intent.ACTION_VIEW);
		startActivity(Mydetail);
				        
		
	}



	private void Convertedittexttostring() {
		// TODO Auto-generated method stub
		fname = editText1.getText().toString();
		lname = editText2.getText().toString();
		fathername = editText3.getText().toString();
		mothername = editText4.getText().toString();
		myemail = editText5.getText().toString();
		myaddrs = editText6.getText().toString();
		
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
