package felipemartins.com.br.tourappreserv;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.widget.CheckBox;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Stack;

import felipemartins.com.br.tourappreserv.models.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebClient implements Callback {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public String result;
    OkHttpClient client = new OkHttpClient();
    private Context context;
    private Activity activity;
    private User user;

    public String post(Context context, Activity activity, User user, String url, String json) throws IOException {

        this.context = context;
        this.activity = activity;
        this.user = user;

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(this);

        return result;
    }


    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        result = response.body().string();
        System.out.print(result);


        try {

            JSONObject obj = new JSONObject(result);

            String status = obj.getString("status");
            String token = obj.getString("token");

            user.setStatus(status);
            user.setToken(token);

            if (user.getStatus().equals("ok")) {
                if (user.getSalvar().equals("ok")) {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Token", user.getToken());
                    editor.putString("Salvar", user.getSalvar());
                    editor.commit();
                } else {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Token", "1");
                    editor.putString("Salvar", "no");

                    editor.commit();
                }

                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
                activity.finish();

            } else {
                Toast.makeText(activity, "Ops, ocorreu algum problema, tente novamente mais tarde.", Toast.LENGTH_LONG).show();
            }


        } catch (JSONException e) {

        }

    }

    public void lerToken(Context context, Activity activity) {


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity);
        String tokenSP = sharedPref.getString("Token", "");

        if (tokenSP.equals("") || tokenSP.equals("1")) {
            Toast.makeText(activity, "Digite seu usuário e senha para entrar", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(activity, "Você já está conectado " + tokenSP, Toast.LENGTH_LONG).show();

            Intent i = new Intent(context, MainActivity.class);
            context.startActivity(i);
            activity.finish();
        }

    }
}
