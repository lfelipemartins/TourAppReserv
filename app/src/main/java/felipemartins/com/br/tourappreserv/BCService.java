package felipemartins.com.br.tourappreserv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import felipemartins.com.br.tourappreserv.LoginActivity;

/**
 * Created by lfeli on 05/06/2017.
 */

public class BCService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Teste de Serviço", Toast.LENGTH_LONG).show();


        Log.e("SERVICE FELIPE: ", "onStartCommand");
        // START_STICKY serve para executar seu serviço até que você pare ele, é reiniciado automaticamente sempre que termina
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}


