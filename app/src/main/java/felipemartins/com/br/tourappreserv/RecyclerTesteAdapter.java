package felipemartins.com.br.tourappreserv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import felipemartins.com.br.tourappreserv.models.Local;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;

/**
 * Created by lfeli on 23/04/2017.
 */

public class RecyclerTesteAdapter extends RecyclerView.Adapter<RecyclerTesteAdapter.RecyclerTesteViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    private Activity mAct;
    private List<Local> mList;

    public RecyclerTesteAdapter(Activity act, List<Local> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mAct = act;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    public RecyclerTesteAdapter(Activity act, List<Local> list) {
        this.mAct = act;
        this.mList = list;
        this.clickRecyclerViewInterface = null;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemlista, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerTesteViewHolder viewHolder, final int i) {
        final Local local = mList.get(i);

        Uri uri = Uri.parse(local.getUrlImg());
        final Context context = viewHolder.listURL.getContext();

        Picasso.with(context).load(uri).transform(new CropCircleTransformation()).into(viewHolder.listURL);

        viewHolder.viewNome.setText(local.getNome());
        viewHolder.viewCurta.setText(local.getDescricaoCurta());
        viewHolder.viewLocal.setText(local.getLocal());

        //Setup the click listener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*

                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("nome", local.getNome());
                editor.commit();

                clickRecyclerViewInterface.onCustomClick(mList.get(i));
*/

                Intent intent = new Intent(mAct.getBaseContext(), DetalhesActivity.class);
                intent.putExtra("nome", local.getNome());
                // intent.putExtra("idLocal", local.getId());
                mAct.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }


    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome, viewCurta, viewLocal;
        protected ImageView listURL;
        protected long id;


        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.textview_nome);
            viewCurta = (TextView) itemView.findViewById(R.id.textview_desccurta);
            viewLocal = (TextView) itemView.findViewById(R.id.textview_local);
            listURL = (ImageView) itemView.findViewById(R.id.imgpequena);



        }
    }

}
