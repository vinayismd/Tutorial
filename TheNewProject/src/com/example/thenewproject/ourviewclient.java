package com.example.thenewproject;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourviewclient extends WebViewClient {
	
@Override
 public boolean shouldOverrideUrlLoading(WebView v , String url){
	v.loadUrl(url);
	return true;
}
   
	
	

}
