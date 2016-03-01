package com.example.thenewproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {
	EditText url;
	WebView ourbrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		ourbrow = (WebView) findViewById(R.id.wvbrowser);
		
		ourbrow.setWebViewClient(new ourviewclient()); // to open link in same browser
		ourbrow.getSettings().setJavaScriptEnabled(true);
		ourbrow.getSettings().setLoadWithOverviewMode(true);
		ourbrow.getSettings().setUseWideViewPort(true);
		try{
		ourbrow.loadUrl("http://www.google.com");
		}
		catch (Exception e){
			e.getStackTrace();
		}
		Button go = (Button) findViewById(R.id.bgo);
		Button goback = (Button) findViewById(R.id.bgoback);
		Button goforw = (Button) findViewById(R.id.bgoforward);
		Button refresh = (Button) findViewById(R.id.brefreshpage);
		Button clear = (Button) findViewById(R.id.bclearhistory);
		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		goback.setOnClickListener(this);
		goforw.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bgo:
			String thewebsite = url.getText().toString();
			ourbrow.loadUrl(thewebsite);
			// hideing keyboard after edit text
		    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
		    imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bgoforward:
			if (ourbrow.canGoForward())
				;
			ourbrow.goForward();
			break;
		case R.id.bgoback:
			if (ourbrow.canGoBack())
				;
			ourbrow.goBack();
			break;
		case R.id.brefreshpage:
			ourbrow.reload();
			break;
		case R.id.bclearhistory:
			ourbrow.clearHistory();
			break;
		}
	}

}
