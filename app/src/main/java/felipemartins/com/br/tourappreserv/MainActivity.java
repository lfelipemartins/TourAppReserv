package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageButton) findViewById(R.id.imageButton_destaques);
        imageView = (ImageButton) findViewById(R.id.imageButton_promo);
        imageView = (ImageButton) findViewById(R.id.imageButton_tudo);


    }

    public void destaques(View v){

        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);

    }
    public void promo(View v){

        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);

    }
    public void tudo(View v){

        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);

    }

    @Override
    protected void onResume() {
        super.onResume();

        lerToken(this, this);

    }

    public void lerToken(Context context, Activity activity) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
        String tokenSP = sharedPref.getString("Token", "");


        if (tokenSP.equals("")) {
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            activity.finish();
        }

    }

}
