package felipemartins.com.br.tourappreserv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lfeli on 05/06/2017.
 */

public class BootCompletedIntentReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {

            Toast.makeText(context, "Teste de boot completed", Toast.LENGTH_SHORT).show();

            Log.e("BOOTCOMPLETED: ", "FUNCIONANDO");

            Intent activityIntent = new Intent(context, LoginActivity.class);
            activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);

            Intent pushIntent = new Intent(context, BCService.class);
            context.startService(pushIntent);
        }
    }
}
