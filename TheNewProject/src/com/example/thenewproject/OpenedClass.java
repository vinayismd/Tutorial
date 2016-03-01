package com.example.thenewproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,OnCheckedChangeListener {
	TextView question, text;
	Button returnData;
	RadioGroup selectionList;
	String gotBread,setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		SharedPreferences getdata = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getdata.getString("name", "vinay is...");
		String value = getdata.getString("list", "4");
		if(value.contentEquals("1")){
			question.setText(et);
		}
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");
		//question.setText(gotBread);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvquestion);
		text = (TextView) findViewById(R.id.tvtext);
		returnData = (Button) findViewById(R.id.breturn);
		selectionList = (RadioGroup)findViewById(R.id.rganswers);
		returnData.setOnClickListener(this);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
     Intent person = new Intent();
     Bundle backpack = new Bundle();
     backpack.putString("answer", setData);
     person.putExtras(backpack);
     setResult(RESULT_OK,person);
     finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.rcrazy:
                         setData = "probably right";
			break;
		case R.id.rsexy:
			setData = "definatily right";
			break;
		case R.id.rboth:
			setData = "spot on";
			break;
		}
       text.setText(setData);
	}

}
