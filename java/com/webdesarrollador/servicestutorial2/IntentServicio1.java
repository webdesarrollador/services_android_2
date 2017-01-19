package com.webdesarrollador.servicestutorial2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class IntentServicio1 extends IntentService {

    public IntentServicio1() {
        super("IntentServicio1");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Log.d("servicio","activo");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Intent i = new Intent("DOWNLOAD_EXITO");
            //Enviamos la intent
            sendBroadcast(i);
        }
    }
    public void onDestroy() {
        super.onDestroy();
        //Cuando toda la cola haya sido procesada se detendrá el servicio
        Log.d("servicio","detenido");
    }
}
