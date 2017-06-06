package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lfeli on 13/05/2017.
 */

public class Reserva {

    private AlertDialog alerta;
    private Context context;
    private Activity activity;

    public void custonDialog(Context context, final Activity activity) {

        this.context = context;
        this.activity = activity;


        LayoutInflater li = activity.getLayoutInflater();

        //infla o layout  na view
        View view = li.inflate(R.layout.enviar_email, null);

        EditText etNome = (EditText) view.findViewById(R.id.editText_nomeCliente);
        EditText etQuarto = (EditText) view.findViewById(R.id.editText_quartoCliente);

        String nome = etNome.getText().toString();
        String quarto = etQuarto.getText().toString();

        final String body = "Foi solicitado uma reserva para " + nome + " Hospedado no quarto " + quarto;

        // botão do layout um clickListener
        view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //exibe um Toast informativo.
                Toast.makeText(activity, "Sua reserva foi encaminhada, aguarde a confirmação da recepção", Toast.LENGTH_LONG).show();
                //desfaz o alerta.

                //composeEmail("lfelipemartins.88@gmail.com", "Reserva urgente", body);

                alerta.dismiss();

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
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

//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

}
