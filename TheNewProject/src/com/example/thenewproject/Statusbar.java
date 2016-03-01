package com.example.thenewproject;




import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statusbar extends Activity implements android.view.View.OnClickListener {
	
	NotificationManager nm;
	static final int uniqueID = 4567567;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statusbar);
		Button bnot = (Button)findViewById(R.id.bnotification);
		bnot.setOnClickListener(this);
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uniqueID);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this , Statusbar.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		String body = "hey!! you have a notification ...";
		String title = "vinay ku.";
		Notification n = new Notification(R.drawable.ic_launcher , body , System.currentTimeMillis());
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		
		nm.notify(uniqueID , n);
		finish();
		
	}


}
