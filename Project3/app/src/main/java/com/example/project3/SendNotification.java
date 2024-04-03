package com.example.project_3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class SendNotification extends BroadcastReceiver {

    private static final String CHANNEL_ID = "AlarmChannel";
    private static final String CHANNEL_NAME = "Alarm Notification";
    private static final String CHANNEL_DESCRIPTION = "Alarm Notification Channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription(CHANNEL_DESCRIPTION);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        Notification notification = createNotification(context);
        if (notificationManager != null) {
            notificationManager.notify(0, notification);
        }
    }

    private Notification createNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setContentTitle("Alarm Alert")
                .setContentText("Your alarm is ringing!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)  // Make sure we have an icon
                .setAutoCancel(true);

        return builder.build();
    }
}
