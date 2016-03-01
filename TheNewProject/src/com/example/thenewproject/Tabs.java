package com.example.thenewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener{
	TabHost th;
	TextView showResult;
	long start , stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
		th = (TabHost)findViewById(R.id.tabhost);
		Button newTab = (Button)findViewById(R.id.baddtab);
		Button bstart = (Button)findViewById(R.id.bstartwatch);
		Button bstop = (Button)findViewById(R.id.bstopwatch);
		showResult = (TextView)findViewById(R.id.tvshowresultwatch);
		
		bstart.setOnClickListener(this);
		bstop.setOnClickListener(this);
		newTab.setOnClickListener(this);
		
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("StopWatch");
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("tab 2");
		th.addTab(specs);
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("add a tab");
		th.addTab(specs);
		start = 0;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.baddtab:
			TabSpec ourspec = th.newTabSpec("tag1");
			ourspec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tabs.this);
					text.setText("you've created a new tab");
					return text;
				}
			});
			ourspec.setIndicator("New");
			th.addTab(ourspec);
			break;
			
			
		case R.id.bstartwatch:
			start = System.currentTimeMillis();
			
			break;
			
		case R.id.bstopwatch:
			stop = System.currentTimeMillis();
			if(start != 0){
			long result = stop - start;
			int millis = (int) result;
			int second = (int)result/1000;
			int minute = second / 60;
			millis = millis%100;
			second = second%60;
			
			 showResult.setText(String.format("%d: %02d : %02d", minute , second , millis));}
			break;
		}
		
	}
	

}
