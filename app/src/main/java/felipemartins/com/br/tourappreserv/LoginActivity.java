package felipemartins.com.br.tourappreserv;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import felipemartins.com.br.tourappreserv.models.Auth;
import felipemartins.com.br.tourappreserv.models.User;

public class LoginActivity extends AppCompatActivity {

    public EditText password, user1;

    public CheckBox cbSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        user1 = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        cbSalvar = (CheckBox) findViewById(R.id.checkBoxConectado);


        WebClient web = new WebClient();

        web.lerToken(this, this);

    }


    public void autenticar(View v) throws IOException {

        WebClient web = new WebClient();

        User user = new User();
        user.setSalvar("");

        if (cbSalvar.isChecked()) {
            user.setSalvar("ok");
        }

        user.setLogin(user1.getText().toString());
        user.setSenha(password.getText().toString());

        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        Auth auth = new Auth();
        auth.setJson(userJsonString);
        String json = gson.toJson(auth);

        System.out.println(userJsonString);
        System.out.println(json);

        web.post(this, this, user, "http://www.eukip.com/aulas/UserAuth/Home/PostAuth", json);

    }

}





