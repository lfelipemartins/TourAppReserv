package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;

public class CadastroActivity extends AppCompatActivity {

    public EditText nome, curta, longa, local, categoria, urlimg;

    public Spinner spinner;


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
        //categoria = (EditText)findViewById(R.id.editText_categoria);
        urlimg = (EditText)findViewById(R.id.editText_url);

        spinner = (Spinner) findViewById(R.id.spinner_categoria);
        String [] categorias={"Destaques", "Promoções", "Padrão"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias);
        spinner.setAdapter(adapter);


    }

    public void Salvar(View v){

        String nom = nome.getText().toString();
        String cur = curta.getText().toString();
        String lon = longa.getText().toString();
        String loc = local.getText().toString();
        //String cat = categoria.getText().toString();
        String cat = spinner.getSelectedItem().toString();
        String url = urlimg.getText().toString();
        Local localidade = new Local(nom, cur, lon, loc, cat, url);
        localidade.setCategoria(spinner.getSelectedItem().toString());
        localidade.save();
        Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }


    public void Voltar(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    public void Limpar(View v){

        List<Local> localList = Local.listAll(Local.class);

        Local.deleteAll(Local.class);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    public void Sair(View v) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Token", "");

        editor.commit();

        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }


}
