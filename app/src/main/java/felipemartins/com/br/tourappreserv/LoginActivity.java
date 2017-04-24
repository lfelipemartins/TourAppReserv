package felipemartins.com.br.tourappreserv;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.


    }


    public void autenticar(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }




}

