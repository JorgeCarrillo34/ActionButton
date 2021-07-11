package com.edu.actionbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //inicializar variable
    Button btshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignar vairiable
        btshow = findViewById(R.id.bt_show);

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initializae
                NotificationManager manager = (NotificationManager)
                        getApplicationContext().getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );

                //INICIALIZA INTENT CUADNO PRESIONE SI EN NOTIFICACION
                Intent intent1 = new Intent(MainActivity.this,MainActivity2.class);

                //put extra
                intent1.putExtra("Si",true);
                //add flags
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                //INICIALIZAR PENDING INTENT
                PendingIntent pendingIntent1 = PendingIntent.getActivity(MainActivity.this,0,intent1,PendingIntent.FLAG_ONE_SHOT);

                //inicializar intent para boton no
                Intent intent2 = new Intent(MainActivity.this,MainActivity2.class);

                //put extra
                intent2.putExtra("No",false);

                //add flags
                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                //INICILIZAR PENDING INTENT
                PendingIntent pendingIntent2 = PendingIntent.getActivity(MainActivity.this,1,intent2,PendingIntent.FLAG_ONE_SHOT);

                //PONER RINGTONE
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                //INICIALIZAR NOTIFICATION BULDER
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,getString(R.string.app_name));

                //nombre notificacion
                builder.setContentTitle("Joke");
                //poner content text
                builder.setContentText("What is the secret of comedy??");
                //icono
                builder.setSmallIcon(R.drawable.ic_face);
                //sonido
                builder.setSound(uri);
                //set priority
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                //accion si da en yes
                builder.addAction(R.drawable.ic_launcher_foreground,"Si", pendingIntent1);
                //accion por si da NO
                builder.addAction(R.drawable.ic_launcher_background,"Not",pendingIntent2);
                //notify manager
                manager.notify(1, builder.build());

            }

        });



    }
}