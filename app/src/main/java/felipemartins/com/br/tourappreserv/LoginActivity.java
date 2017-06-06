package felipemartins.com.br.tourappreserv;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.IOException;

import felipemartins.com.br.tourappreserv.models.User;

public class LoginActivity extends AppCompatActivity {

    public EditText password, user1;

    public CheckBox cbSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        //INICIANDO O PROGRAMA AUTOMATICAMENTE ATRAVES DO BROADCASTRECIVER
        startService(new Intent(getBaseContext(), BCService.class));


        user1 = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        cbSalvar = (CheckBox) findViewById(R.id.checkBoxConectado);


        WebClient web = new WebClient();

        web.lerToken(this, this);

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    public void autenticar(View v) throws IOException {

        WebClient web = new WebClient();

        User user = new User();
        user.setSalvar("");

        if (cbSalvar.isChecked()) {
            user.setSalvar("ok");
            //user.setToken("");
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

        /*user.setLogin(user1.getText().toString());
        user.setSenha(password.getText().toString());

        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        Auth auth = new Auth();
        auth.setJson(userJsonString);
        String json = gson.toJson(auth);

        System.out.println(userJsonString);
        System.out.println(json);

        web.post(this, this, user, "http://www.eukip.com/aulas/UserAuth/Home/PostAuth", json);
*/
    }

}





