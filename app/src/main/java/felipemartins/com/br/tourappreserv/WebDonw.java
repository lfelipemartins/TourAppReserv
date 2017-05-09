package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;
import felipemartins.com.br.tourappreserv.models.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lfeli on 01/05/2017.
 */

public class WebDonw implements Callback {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public String result;
    OkHttpClient client = new OkHttpClient();
    private Context context;
    private Activity activity;
    private User user;


    public String donw(Context context, Activity activity, String url) throws IOException {

        this.context = context;
        this.activity = activity;

        Request request = new Request.Builder()
                .url(url)
                .get()
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
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonarray = jsonObject.getJSONArray("points");

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject obj = jsonarray.getJSONObject(i);

                String nom = obj.getString("nome");
                String cur = obj.getString("desc_curta");
                String lon = obj.getString("desc_long");
                String loc = obj.getString("endereco");
                String url = obj.getString("url_img");
                int promo = obj.getInt("promocao");
                int dest = obj.getInt("destaque");
                int padr = obj.getInt("padrao");

                String cat;

                if (promo == 1 && padr == 1) {
                    cat = "Promoções";
                } else if (dest == 1 && padr == 1) {
                    cat = "Destaques";
                } else {
                    cat = "Padrão";
                }

                Local localidade = new Local(nom, cur, lon, loc, cat, url);
                localidade.save();

                Log.d("Item salvo: ", nom + " " + cur + " " + lon + " " + loc + " " + cat + " " + url);


            }


        } catch (JSONException e) {
            System.out.print(e);
        }


    }
}
