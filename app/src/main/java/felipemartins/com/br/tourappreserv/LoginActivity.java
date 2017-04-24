package felipemartins.com.br.tourappreserv;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class LoginActivity extends AppCompatActivity {

    public AutoCompleteTextView user1;
    public EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        User user = new User();

        password = (EditText)findViewById(R.id.password);
        user1 = (AutoCompleteTextView)findViewById(R.id.email);


        user.setLogin(user1.getText().toString());
        user.setSenha(password.getText().toString());

    }

    public void autenticar(View v) throws IOException {


        WebClient web = new WebClient();

        User user = new User();

        user.setLogin(user1.getText().toString());
        user.setSenha(password.getText().toString());

        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        System.out.println(userJsonString);


        String response = web.post("http://http://www.eukip.com/aulas/UserAuth/Home/PostAuth", userJsonString);
        System.out.println(response);

    }


    public void autenticar2(View v) throws IOException {

        User user = new User();

        password = (EditText)findViewById(R.id.password);
        user1 = (AutoCompleteTextView)findViewById(R.id.email);


        user.setLogin(user1.toString());
        user.setSenha(password.toString());


        WebClient teste = new WebClient();


        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        Log.d("Gson", "String do Json" + userJsonString);

        //teste.post(userJsonString);

        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
        //finish();

    }




}

