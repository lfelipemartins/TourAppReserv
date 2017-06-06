package felipemartins.com.br.tourappreserv.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ConnReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null) {
            Toast.makeText(context, "Conectado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Não concetado", Toast.LENGTH_SHORT).show();
        }


    }
}
