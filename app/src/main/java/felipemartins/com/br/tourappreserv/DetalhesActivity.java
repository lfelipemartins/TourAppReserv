package felipemartins.com.br.tourappreserv;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {


    public String nome = "";
    public String quarto = "";
    private AlertDialog alerta;

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

                custonDialog();

            }
        });
    }


    private void custonDialog() {
        LayoutInflater li = getLayoutInflater();

        //infla o layout  na view
        View view = li.inflate(R.layout.enviar_email, null);

        EditText etNome = (EditText) findViewById(R.id.editText_nomeCliente);
        EditText etQuarto = (EditText) findViewById(R.id.editText_quartoCliente);

        nome = etNome.getText().toString();
        quarto = etQuarto.getText().toString();

        final String body = "Foi solicitado uma reserva para " + nome + " Hospedado no quarto " + quarto;

        // botão do layout um clickListener
        view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //exibe um Toast informativo.
                Toast.makeText(DetalhesActivity.this, "Sua reserva foi encaminhada, aguarde a confirmação da recepção", Toast.LENGTH_LONG).show();
                //desfaz o alerta.

                composeEmail("lfelipemartins.88@gmail.com", "Reserva urgente", body);

                alerta.dismiss();

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reservar");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    public void composeEmail(String addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



}
