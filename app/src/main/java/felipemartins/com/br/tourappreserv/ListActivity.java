package felipemartins.com.br.tourappreserv;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;

public class ListActivity extends AppCompatActivity {

    public String busca, categoria;
    RecyclerTesteAdapter adapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Local> locaisListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        setaRecyclerView();

        setaButtons();
        listenersButtons();

        busca = getIntent().getExtras().getString("busca");

        List<Local> loc = Local.listAll(Local.class);

        for (Local a : loc) {
            Local lugar = new Local();
            lugar.setCategoria(a.getCategoria());
            if (busca.equals("destaque") && lugar.getCategoria().equals("Destaques")) {
                lugar.setNome(a.getNome());
                lugar.setDescricaoCurta(a.getDescricaoCurta());
                lugar.setLocal(a.getLocal());
                lugar.setUrlImg(a.getUrlImg());
                lugar.setDescricaolonga(a.getDescricaolonga());
                locaisListas.add(lugar);
            }
            if (busca.equals("promo") && lugar.getCategoria().equals("Promoções")) {
                lugar.setNome(a.getNome());
                lugar.setDescricaoCurta(a.getDescricaoCurta());
                lugar.setLocal(a.getLocal());
                lugar.setUrlImg(a.getUrlImg());
                lugar.setDescricaolonga(a.getDescricaolonga());
                locaisListas.add(lugar);
            }
            if (busca.equals("tudo")) {
                lugar.setNome(a.getNome());
                lugar.setDescricaoCurta(a.getDescricaoCurta());
                lugar.setLocal(a.getLocal());
                lugar.setUrlImg(a.getUrlImg());
                lugar.setDescricaolonga(a.getDescricaolonga());
                locaisListas.add(lugar);
            }
            adapter.notifyDataSetChanged();
        }


        imageView = (ImageView) findViewById(R.id.imgpequena);

        // Picasso.with(this.getApplicationContext())
        //        .load("http://www.paraibadebate.com.br/wp-content/uploads/2015/11/joao-pessoa-pb-5.jpg")
        //        .into(imageView);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerTesteAdapter(this, locaisListas);
        mRecyclerView.setAdapter(adapter);
    }


    public void setaButtons() {

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    /*@Override
    public void onCustomClick(Object object) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String nomeSP = sharedPref.getString("nome", "");

        String nome = "";
        String descLonga = "";
        String url = "";

        List<Local> loc = Local.find(Local.class, "nome = ?", nomeSP);
        for (Local a : loc) {
            nome = a.getNome();
            descLonga = a.getDescricaolonga();
            url = a.getUrlImg();
        }

        Intent i = new Intent(this, DetalhesActivity.class);
        i.putExtra("nome", nome);
        i.putExtra("descLonga", descLonga);
        i.putExtra("urlimg", url);
        startActivity(i);

    }*/

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cadastrobutton();

            }
        });
    }

    public void cadastrobutton() {


        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
        finish();
    }

}
