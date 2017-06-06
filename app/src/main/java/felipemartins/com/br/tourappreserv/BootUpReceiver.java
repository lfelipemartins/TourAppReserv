package felipemartins.com.br.tourappreserv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import felipemartins.com.br.tourappreserv.LoginActivity;

/**
 * Created by lfeli on 05/06/2017.
 */

public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent activityIntent = new Intent(context, LoginActivity.class);
            activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);
        }
    }
}
