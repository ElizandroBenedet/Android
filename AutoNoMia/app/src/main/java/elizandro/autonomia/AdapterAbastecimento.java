package elizandro.autonomia;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by elizandro on 22/11/17.
 */

public class AdapterAbastecimento extends Adapter {
    private ArrayList<Abastecimento> listaAbastecimento;


    public void setListaAbastecimento(ArrayList <Abastecimento> lista){
        this.listaAbastecimento = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.abastecimento_item, parent, false);


        HolderAbastecimento gaveta = new HolderAbastecimento(layoutView);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final HolderAbastecimento abastece = (HolderAbastecimento) holder;
        final Abastecimento atual = this.listaAbastecimento.get(position);
        abastece.atualizaLista( atual );
    }

    @Override
    public int getItemCount() {
        return this.listaAbastecimento.size();
    }
}
