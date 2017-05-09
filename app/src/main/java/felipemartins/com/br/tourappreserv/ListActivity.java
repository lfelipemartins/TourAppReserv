package felipemartins.com.br.tourappreserv;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;

public class ListActivity extends AppCompatActivity implements ClickRecyclerView_Interface {

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

        for (Local a: loc){
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

    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerTesteAdapter(this, locaisListas, this);
        mRecyclerView.setAdapter(adapter);
    }


    public void setaButtons(){

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {

        Local local = new Local();




        Intent i = new Intent(this, DetalhesActivity.class);
        startActivity(i);

    }

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
