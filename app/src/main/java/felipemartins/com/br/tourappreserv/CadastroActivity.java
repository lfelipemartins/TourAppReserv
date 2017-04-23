package felipemartins.com.br.tourappreserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    public EditText nome, curta, longa, local, categoria, urlimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Local local1 = new Local("Ferinha", "Comidas regionais", "A feirinha é um lugar perfeito para encontrar amigos", "Tambaú", "comidas");
        //Local local2 = new Local("Ferinha2", "Comidas regionais", "A feirinha é um lugar perfeito para encontrar amigos", "Tambaú", "comidas");
       // local1.save();

       // Toast.makeText(ListActivity.this, "salvo", Toast.LENGTH_SHORT).show();
        nome = (EditText)findViewById(R.id.editText_nome);
        curta = (EditText)findViewById(R.id.editText_descricaocurta);
        longa = (EditText)findViewById(R.id.editText_descricaolonga);
        local = (EditText)findViewById(R.id.editText_local);
        categoria = (EditText)findViewById(R.id.editText_categoria);
        urlimg = (EditText)findViewById(R.id.editText_url);

    }

    public void Salvar(View v){

        String nom = nome.getText().toString();
        String cur = curta.getText().toString();
        String lon = longa.getText().toString();
        String loc = local.getText().toString();
        String cat = categoria.getText().toString();
        String url = urlimg.getText().toString();

        Local local = new Local(nom, cur, lon, loc, cat, url);
        local.save();
        Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);




    }




}
