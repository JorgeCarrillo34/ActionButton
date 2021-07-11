package com.edu.actionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //incializar variable
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //asignar variable

        textview = findViewById(R.id.text_view);

        //inicilizar notificacion
        NotificationManager manager = (NotificationManager)getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        //clear notification
        manager.cancelAll();

        //check condition
        if(getIntent().hasExtra("Si")){
            //cuando presione el boton SI
            //pongab texto tal
            textview.setText("You Accepted Joke");
        }else if (getIntent().hasExtra("No")){
            textview.setText("You Decline joke");
        }

    }

}