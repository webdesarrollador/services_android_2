package com.webdesarrollador.servicestutorial2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver download = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            setNumeroImagenes();
        }
    };
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(download, new IntentFilter("DOWNLOAD_EXITO"));
    }
    public void descargar (View view) {
        //Comenzamos el servicio
        startService(new Intent(this, IntentServicio1.class));
    }
    //Asginamos al TextView el numero de imagenes que se van descargando
    public void setNumeroImagenes(){
        TextView num_imagenes = (TextView) findViewById(R.id.num_imagenes);
        j++;
        num_imagenes.setText(String.valueOf(j));
    }
}


