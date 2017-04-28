package felipemartins.com.br.tourappreserv;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import felipemartins.com.br.tourappreserv.models.Auth;
import felipemartins.com.br.tourappreserv.models.User;

public class LoginActivity  extends AppCompatActivity {

    public EditText password, user1;
    String datatokenSP = "";
    String tokenSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        user1 = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);




    }


    public void autenticar(View v) throws IOException {

        WebClient web = new WebClient();

        User user = new User();

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
        while(web.getResult()==null)
        System.out.println(web.getResult());
        String response =web.getResult();
    }


    public void lerToken(){
        SharedPreferences armazemSP = getSharedPreferences(datatokenSP, Context.MODE_PRIVATE);
        String tokenarmazenado = "";
        tokenSP = armazemSP.getString("token", tokenarmazenado);



    }











}

