package felipemartins.com.br.tourappreserv;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;

public class DetalhesActivity extends AppCompatActivity {


    public String nome = "";
    public String quarto = "";
    public String nome2, descLong, url;
    public TextView eTdesc;
    public ImageView urllocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                chamarMapa();

            }
        });

        urllocal = (ImageView) findViewById(R.id.detalhesbackdrop);
        eTdesc = (TextView) findViewById(R.id.detalhes_long);

        //long idLocal = getIntent().getExtras().getLong("idLocal");
        //Local local = new Local().findById(Local.class, idLocal);
        String nomeLocal = getIntent().getExtras().getString("nome");
        List<Local> local = Local.find(Local.class, "nome = ?", nomeLocal);
        for (Local a : local) {
            descLong = a.getDescricaolonga();
            url = a.getUrlImg();
            nome2 = a.getNome();
        }


        Picasso.with(this).load(url).into(urllocal);

        getSupportActionBar().setTitle(nome2);
       /* ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setTitle(nome2);*/

        eTdesc.setText(descLong);

    }

    private void chamarMapa() {

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("nome", nome2);
        startActivity(i);

    }

    public void solicitarReserva(View view) {

        Reserva reserva = new Reserva();

        reserva.custonDialog(this, this);

    }
}
