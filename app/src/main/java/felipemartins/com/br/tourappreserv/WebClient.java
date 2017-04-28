package felipemartins.com.br.tourappreserv;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import felipemartins.com.br.tourappreserv.models.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebClient implements Callback {

    public String result;
    private Context context;
    private Activity activity;
    private User user;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    OkHttpClient client = new OkHttpClient();

    public String post(Context context, Activity activity, User user, String url, String json) throws IOException {

        this.context = context;
        this.activity = activity;
        this.user = user;

        RequestBody body = RequestBody.create(JSON, json );
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(this);
/*
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                System.out.print(result);
                if (response != null){
                    return;
                }
            }
        });
        */
        return result;
    }


    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        result = response.body().string();
        System.out.print(result);

        String datatokenSP = "";

        try {

            JSONObject obj = new JSONObject(result);

            String status = obj.getString("status");
            String token = obj.getString("token");

            user.setStatus(status);
            user.setToken(token);

            if (user.getStatus().equals("ok")){
                SharedPreferences armazemSP = PreferenceManager.getDefaultSharedPreferences(activity);
                SharedPreferences.Editor editor = armazemSP.edit();
                editor.putString("Token", user.getToken());
                editor.commit();

                String tokenarmazenado = "Erro de token";

                //Toast.makeText(context, armazemSP.getString("Token", tokenarmazenado), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
                activity.finish();

            }else{
                //Toast.makeText(context, user.getStatus(), Toast.LENGTH_SHORT).show();
            }


        }catch (JSONException e){

        }

    }

    public String getResult() {
        return result;
    }
}
