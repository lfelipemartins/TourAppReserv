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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

    public EditText password, user1;


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

        String jsonvono = "{\"json\":" + userJsonString + "}";

        System.out.println(userJsonString);
        System.out.println(jsonvono);

        String response = web.post("http://www.eukip.com/aulas/UserAuth/Home/PostAuth", jsonvono);
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

