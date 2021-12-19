package com.example.androidlayoutelements;

import static com.example.androidlayoutelements.App.CHANNEL_1_ID;
import static com.example.androidlayoutelements.App.CHANNEL_2_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText mEditTitle, mEditMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        mEditTitle = findViewById(R.id.etTitle);
        mEditMessage = findViewById(R.id.etMessage);
    }

    public void onChannel1Clicked(View view) {

        String title = mEditTitle.getText().toString();
        String message = mEditMessage.getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationManagerCompat.IMPORTANCE_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    public void onChannel2Clicked(View view) {

        String title = mEditTitle.getText().toString();
        String message = mEditMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationManagerCompat.IMPORTANCE_LOW)
                .build();

        notificationManager.notify(2, notification);
    }
}