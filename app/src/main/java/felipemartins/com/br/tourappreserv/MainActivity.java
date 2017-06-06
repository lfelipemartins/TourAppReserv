package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import felipemartins.com.br.tourappreserv.models.Auth;
import felipemartins.com.br.tourappreserv.models.Local;
import felipemartins.com.br.tourappreserv.models.User;

public class MainActivity extends AppCompatActivity {

    ImageButton imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageView = (ImageButton) findViewById(R.id.imageButton_destaques);
        imageView = (ImageButton) findViewById(R.id.imageButton_promo);
        imageView = (ImageButton) findViewById(R.id.imageButton_tudo);

        /*

        WebDonw web = new WebDonw();

        try {
            web.donw(this, this, "https://tourappreserv.herokuapp.com/pointsjson");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }

    /* Função para verificar existência de conexão com a internet
     */
    public void verificaConexao() {
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {

            Toast.makeText(this, "Conexão ativa", Toast.LENGTH_SHORT).show();

            //limpar lista e carregar lista web
            Local.deleteAll(Local.class);

            WebDonw web = new WebDonw();

            try {
                web.donw(this, this, "https://tourappreserv.herokuapp.com/points.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Sem conexão", Toast.LENGTH_SHORT).show();
        }
    }



    public void destaques(View v) {
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("busca", "destaque");
        startActivity(i);
        finish();

    }
    public void promo(View v){

        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("busca", "promo");
        startActivity(i);
        finish();

    }
    public void tudo(View v){

        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("busca", "tudo");
        startActivity(i);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();

        verificaConexao();

        //evita que ao sair o usuario possa voltar a essa tela sem fazer login
        //lerToken(this, this);

    }

    //Metodo de validação do token para esta tela
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
