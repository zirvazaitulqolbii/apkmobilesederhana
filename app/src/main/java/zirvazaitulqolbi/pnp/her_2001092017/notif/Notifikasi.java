package zirvazaitulqolbi.pnp.her_2001092017.notif;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import zirvazaitulqolbi.pnp.her_2001092017.R;

public class Notifikasi {
    private static final String CHANNEL_ID ="01";
    private static final String CHANNEL_NAME ="NOTIF";

    Context context;

    public Notifikasi(Context context) {
        this.context = context;
    }

    public void notif(String title, String konten){
        NotificationCompat.Builder notifikasiBuilder =
                new NotificationCompat.Builder(context,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_add)
                        .setAutoCancel(true)
                        .setLights(Color.BLUE, 500,500)
                        .setVibrate(new long[]{500, 500, 500})
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentTitle(title)
                        .setContentText(konten)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(channel);
        }
        int id = (int) System.currentTimeMillis();
        Glide.with(context)
                .asBitmap()
                .load(context.getResources().getIdentifier("zirva","drawable",
                        context.getPackageName()))
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        notifikasiBuilder.setLargeIcon(resource);
                        Notification notification = notifikasiBuilder.build();
                        notificationManager.notify(id,notification);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

    }
}
