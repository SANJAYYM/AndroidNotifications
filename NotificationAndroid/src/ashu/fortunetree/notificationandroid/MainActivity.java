package ashu.fortunetree.notificationandroid;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	private NotificationManager mNotificationManager;
	private int notificationID = 100;
	private int numMessages = 0;
	
	public Button mStartButton,mCancelButton,mUpdateButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mStartButton = (Button) findViewById(R.id.start);
        mCancelButton = (Button) findViewById(R.id.cancel);
        mUpdateButton = (Button) findViewById(R.id.update);
        
        mStartButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DisplayNotification();
				
			}
		});
        
        mCancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CancelNotification();
			}
		});
        
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateNotification();
				
			}
		});
        
    }
    
    protected void DisplayNotification(){
    	Log.i("Start", "Has Started");
    	
    	//invoking the default notification system
    	NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    	
    	mBuilder.setContentTitle("New Message from Ashok");
    	mBuilder.setContentText("Nam Myoho renge kyo - live your life happily live your life amazingly you deserve to be happy");
    	mBuilder.setTicker("New wish from");
    	mBuilder.setSmallIcon(R.drawable.noti_ico);
    	
    	// Increase in notification when everytime notification arrives
    	mBuilder.setNumber(++numMessages);
    	
    	//creating an explicit intent for the activity for the app
    	
    	Intent resultIntent = new Intent(this,NotiView.class);
    	TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    	stackBuilder.addParentStack(NotiView.class);
    	
    	// adds the intent to to start when notification clicked
    	stackBuilder.addNextIntent(resultIntent);
    	PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    	mBuilder.setContentIntent(resultPendingIntent);
    	mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    	
    	// Notification id allows you to update the notification later on
    	mNotificationManager.notify(notificationID, mBuilder.build());
    }
    	
    	protected void CancelNotification(){
    		Log.i("Cancel", "Notification Cancelled");
    		mNotificationManager.cancel(notificationID);
    	}
    	
    	protected void updateNotification(){
    		Log.i("Update","UpdateNotification");
    		
    		//Invoking the default notification service
    		
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Happy life and life is happy");
		mBuilder.setContentText("You deserve to be happy always Ashu.");
		mBuilder.setTicker("Happiness alert!");
		mBuilder.setSmallIcon(R.drawable.noti_ico);
		
		//increase notification number evertime notification arraives
		mBuilder.setNumber(++numMessages);
		
		/* Creates an explicit intent for an Activity in your app */
		Intent resultIntent = new Intent(
				this, NotiView.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NotiView.class);
		
		// adds the intent that starts activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		
		mBuilder.setContentIntent(resultPendingIntent);
		
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//updating notification using same notification id
		
		mNotificationManager.notify(notificationID,mBuilder.build());
    	}
    	
    	
    	
    	
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
