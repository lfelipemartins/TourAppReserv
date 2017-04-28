package felipemartins.com.br.tourappreserv;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;

public class ListActivity extends AppCompatActivity implements ClickRecyclerView_Interface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerTesteAdapter adapter;
    private List<Local> locaisListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        setaRecyclerView();

        setaButtons();
        listenersButtons();

        List<Local> loc = Local.listAll(Local.class);

        for (Local a: loc){
            Local lugar = new Local();
            lugar.setNome(a.getNome().toString());

            locaisListas.add(lugar);
            adapter.notifyDataSetChanged();
        }


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
        Local local = (Local) object;
        String nome = local.getNome();

    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent i = new Intent(this, CadastroActivity.class);
                //startActivity(i);

              //  Local local1 = new Local();
               // local1.setNome("Feirinha");

                //Adiciona a lista e avisa o adapter que o conteúdo
                //da lista foi alterado
                //locaisListas.add(local1);
                //adapter.notifyDataSetChanged();

            }
        });
    }

    public void cadastrobutton (View v){

        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
        finish();

    }








}
