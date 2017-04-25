package felipemartins.com.br.tourappreserv;



import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class LoginActivity extends AppCompatActivity {

    public EditText password, user1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.


    }


    public void autenticar(View v) throws IOException {

        WebClient web = new WebClient();

        User user = new User();

        user.setLogin(user1.getText().toString());
        user.setSenha(password.getText().toString());

        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        System.out.println(userJsonString);


        String response = web.post("http://www.eukip.com/aulas/UserAuth/Home", userJsonString);
        System.out.println(response);

        //try {

            //String resposta = response.toString();
            //JSONObject jsonresposta = new JSONObject(resposta);

            //String status = jsonresposta.getString("status");
            //String token = jsonresposta.getString("token");

            //Intent i = new Intent(this, MainActivity.class);
            //startActivity(i);
            //finish();


        //}catch (IOException e){

        //}



        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
        //finish();
    }











}

