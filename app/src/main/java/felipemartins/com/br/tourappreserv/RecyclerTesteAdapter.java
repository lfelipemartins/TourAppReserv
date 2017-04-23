package felipemartins.com.br.tourappreserv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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
        Local pessoa = mList.get(i);

        viewHolder.viewNome.setText(pessoa.getNome());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.textview_nome);

            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }

}