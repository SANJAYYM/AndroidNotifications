AndroidNotifications
====================

Working with android notification instead of toast


**ANDROID NOTIFICATION SYSTEM**  
Android toast is a great component but the problem what i sense is after its duration it will disappear and if user needs  
information to be seen at any cost then toast is not the great way to start with. Android has a class for notification i have briefly  
given small program where user can activate notifications from button onclick listner class hope this helps.  

**Following information describes about toast**  
  
  **Follow these below steps to create a simple notification**  
  
  **STEP 1 - CREATE NOTIFICATION BUILDER**  
  As a first step is to create a notification builder using NotificationCompat.Builder.build().   
  You will use Notification Builder to set various Notification properties like its small and large icons,   
  title, priority etc.
  
  **NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)**
  
  **STEP 2 - SETTING NOTIFICATION PROPERTIES**  
  Once you have Builder object, you can set its Notification properties using Builder   
  object as per your requirement. But this is mandatory to set at least following:  
   A small icon, set by setSmallIcon()   
   A title, set by setContentTitle()   
   Detail text, set by setContentText()   
  **mBuilder.setSmallIcon(R.drawable.notification_icon);**  
  **mBuilder.setContentTitle("Notification Alert, Click Me!");**  
  **mBuilder.setContentText("Hi, This is Android Notification Detail!");**   
  
  You have many  optional properties which you can set for your notification.   
  To learn more about them, see the reference documentation for NotificationCompat.Builder.       
  
  
  **STEP 3 - ATTACH ACTIONS**   
  This is an optional part and required if you want to attach an action with the notification.   
  An action allows users to go directly from the notification to an Activity in your application,  
  where they can look at one or more events or do further work. The action is defined by a PendingIntent containing an   
  Intent that starts an Activity in your application. To associate the PendingIntent with a gesture, call the appropriate   
  method ofNotificationCompat.Builder. For example, if you want to start Activity when the user clicks the notification   
  text in the notification drawer, you add the PendingIntent by calling setContentIntent().  
  
  A PendingIntent object helps you to perform an action on your application’s behalf, often at a later time, without   
  caring of whether or not your application is running. We take help of stack builder object which will contain an   
  artificial back stack for the started Activity. This ensures that navigating backward from the Activity leads out   
  of your application to the Home screen.  
  
  
  
          
          Intent resultIntent = new Intent(this, ResultActivity.class);  
          TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);   
          stackBuilder.addParentStack(ResultActivity.class);  
          // Adds the Intent that starts the Activity to the top of the stack   
          stackBuilder.addNextIntent(resultIntent);   
          PendingIntent resultPendingIntent = stackBuilder.getPendingIntent( 0, PendingIntent.FLAG_UPDATE_CURRENT );   
          mBuilder.setContentIntent(resultPendingIntent);  
    
    **STEP 4 - ISSUE THE NOTIFICATION**  
    Finally, you pass the Notification object to the system by calling NotificationManager.notify()   
    to send your notification. Make sure you call NotificationCompat.Builder.build() method on builder   
    object before notifying it. This method combines all of the options that have been set and return a new Notificationobject.  
    
    
    **NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
    // notificationID allows you to update the notification later on.  
    mNotificationManager.notify(notificationID, mBuilder.build());**                   
    
    **The NotificationCompat.Builder Class**  
    The NotificationCompat.Builder class allows easier control over all the flags, as well as help constructing the typical notification layouts.  
    Following are few important and most frequently used methods available as  
    a part of NotificationCompat.Builder class.   
    1 Notification build() Combine all of the options that have been set and return a new Notification object.  
    2 NotificationCompat.Builder setAutoCancel (boolean autoCancel) Setting this flag will make it so the notification is automatically canceled when the user clicks it in the panel.  
    3 NotificationCompat.Builder setContent (RemoteViews views) Supply a custom RemoteViews to use instead of the standard one.  
    4 NotificationCompat.Builder setContentInfo (CharSequence info) Set the large text at the right-hand side of the notification.   
    5 NotificationCompat.Builder setContentIntent (PendingIntent intent) Supply a PendingIntent to send when the notification is clicked.  
    6 NotificationCompat.Builder setContentText (CharSequence text) Set the text (second row) of the notification, in a standard notification.   
    7 NotificationCompat.Builder setContentTitle (CharSequence title)
    
    
 **The Screens of the application in this repository looks like**
![Screen1](https://github.com/ashokslsk/AndroidNotifications/blob/master/NotificationAndroid/screens/screen1.png)
![Screen2](https://github.com/ashokslsk/AndroidNotifications/blob/master/NotificationAndroid/screens/screen2.png)
![Screen3](https://github.com/ashokslsk/AndroidNotifications/blob/master/NotificationAndroid/screens/screen3.png)
![Screen4](https://github.com/ashokslsk/AndroidNotifications/blob/master/NotificationAndroid/screens/screen4.png)
 
                **HAPPY CODING**  **AS USUAL CODING IS GREAT WAY OF SATISFACTION**
    
