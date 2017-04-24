package felipemartins.com.br.tourappreserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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





}
