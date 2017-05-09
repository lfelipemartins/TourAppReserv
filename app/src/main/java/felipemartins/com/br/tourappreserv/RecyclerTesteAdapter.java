package felipemartins.com.br.tourappreserv;

import android.content.Context;
import android.net.Uri;
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
    Context mctx;
    private List<Local> mList;

    public RecyclerTesteAdapter(Context ctx, List<Local> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlista, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Local local = mList.get(i);

        Uri uri = Uri.parse(local.getUrlImg());
        Context context = viewHolder.listURL.getContext();

        Picasso.with(context).load(uri).transform(new CropCircleTransformation()).into(viewHolder.listURL);

        viewHolder.viewNome.setText(local.getNome());
        viewHolder.viewCurta.setText(local.getDescricaoCurta());
        viewHolder.viewLocal.setText(local.getLocal());

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


            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Local local = mList.get(getLayoutPosition());

                    //long id = local.getId();

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));


                }
            });
        }
    }

}
