package edu.tecii.android.aplicacion6;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;
    NotificationCompat.Builder notificacion;
    RadioButton rdbtn1, rdbtn2, rdbtn3, rdbtn4;
    Button btn1;
    int rb = 0, i = 0;
    Timer timer1 = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        rdbtn1 = (RadioButton)findViewById(R.id.radioButton1);
        rdbtn2 = (RadioButton)findViewById(R.id.radioButton2);
        rdbtn3 = (RadioButton)findViewById(R.id.radioButton3);
        rdbtn4 = (RadioButton)findViewById(R.id.radioButton4);
        btn1 = (Button)findViewById(R.id.button);

        rdbtn1.toggle(); //Este metodo sirve para selecionar el radioButton correspondiente
        onRadioButtonClicked(rdbtn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb == 1){
                    i = 5000;
                } else if (rb == 2){
                    i = 15000;
                } else if (rb == 3){
                    i = 30000;
                } else if (rb == 4){
                    i = 60000;
                } else {
                    i = 5000;
                }
                Toast.makeText(getApplicationContext(), "Por favor espera "+i/1000+" segundos", Toast.LENGTH_SHORT).show();
                if(timer1!=null){
                    timer1.cancel();
                    timer1 = new Timer();
                }
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        mostrarNotificacion();
                    }
                };
                timer1.schedule(tt, i);
                //timer1.cancel();
            }
        });
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked){
                    rdbtn2.setChecked(false);
                    rdbtn3.setChecked(false);
                    rdbtn4.setChecked(false);
                    rb = 1;
                }
                    break;
            case R.id.radioButton2:
                if (checked){
                    rdbtn1.setChecked(false);
                    rdbtn3.setChecked(false);
                    rdbtn4.setChecked(false);
                    rb = 2;
                }
                    break;
            case R.id.radioButton3:
                if (checked){
                    rdbtn1.setChecked(false);
                    rdbtn2.setChecked(false);
                    rdbtn4.setChecked(false);
                    rb = 3;
                }
                    break;
            case R.id.radioButton4:
                if (checked){
                    rdbtn1.setChecked(false);
                    rdbtn2.setChecked(false);
                    rdbtn3.setChecked(false);
                    rb = 4;
                }
                    break;
        }
    }

    public void mostrarNotificacion(){
        switch (rb){
            case 0: {
                Toast.makeText(getApplicationContext(), "Por favor selecciona alguna opcion", Toast.LENGTH_SHORT).show();
            }
            break;
            case 1: {
                notificacion = new NotificationCompat.Builder(getApplicationContext());
                notificacion.setContentTitle("Titulo de notificacion 1");
                notificacion.setContentText("Hola mundo notificacion 1");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion.setTicker("texto 1");

                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);
                //notificacion1.setContentIntent(intent);
                manager.notify(10, notificacion.build());
            }
            break;
            case 2: {
                notificacion = new NotificationCompat.Builder(getApplicationContext());
                notificacion.setContentTitle("Titulo de notificacion 2");
                notificacion.setContentText("Hola mundo notificacion 2");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion.setTicker("texto 2");

                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);
                //notificacion1.setContentIntent(intent);
                NotificationCompat.BigTextStyle estilo = new NotificationCompat.BigTextStyle();
                estilo.setSummaryText("Esto es un resumen");
                estilo.setBigContentTitle("Esto es un Titulo");
                estilo.bigText("Este es un texto largo que se puede repetir" +
                        "Este es un texto largo que se puede repetir" +
                        "Este es un texto largo que se puede repetir" +
                        "Este es un texto largo que se puede repetir");
                manager.notify(20, notificacion.build());
            }
            break;
            case 3: {
                notificacion = new NotificationCompat.Builder(getApplicationContext());
                notificacion.setContentTitle("Titulo de notificacion 3");
                notificacion.setContentText("Hola mundo notificacion 3");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion.setTicker("texto 3");

                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);
                //notificacion1.setContentIntent(intent);
                manager.notify(10, notificacion.build());
            }
            break;
            case 4: {
                notificacion = new NotificationCompat.Builder(getApplicationContext());
                notificacion.setContentTitle("Titulo de notificacion 4");
                notificacion.setContentText("Hola mundo notificacion 4");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion.setTicker("texto 4");

                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);
                //notificacion1.setContentIntent(intent);
                manager.notify(10, notificacion.build());
            }
            break;
        }
    }
}
