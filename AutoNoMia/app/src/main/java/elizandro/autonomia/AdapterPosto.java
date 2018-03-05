package elizandro.autonomia;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by elizandro on 01/12/17.
 */

public class AdapterPosto extends Adapter {
    private ArrayList<Posto> listaPosto;

    public void setListaPosto(ArrayList <Posto> lista){
        this.listaPosto = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.posto_item, parent, false);


        HolderPosto gaveta = new HolderPosto(layoutView);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final HolderPosto posto = (HolderPosto) holder;
        final Posto atual = this.listaPosto.get(position);
        posto.atualizaLista( atual );
        posto.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(posto.layout.getContext(), atual.getBandeira(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listaPosto.size();
    }
}


