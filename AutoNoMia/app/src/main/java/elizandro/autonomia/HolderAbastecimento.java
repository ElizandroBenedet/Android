package elizandro.autonomia;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by elizandro on 22/11/17.
 */

public class HolderAbastecimento extends ViewHolder implements View.OnClickListener {

    private TextView tvData;
    private TextView tvLitro;
    private TextView tvQuilo;
    private ImageView ivImagem;
    private TextView tvPosto;
    public ConstraintLayout layout;

    private Abastecimento atual;

    public HolderAbastecimento(View itemView) {
        super(itemView);

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvQuilo = itemView.findViewById(R.id.tvQuilo);
        this.tvLitro = itemView.findViewById(R.id.tvLitro);
        this.ivImagem = itemView.findViewById(R.id.ivImagem);
        this.layout = itemView.findViewById(R.id.clAbastecimento);
        this.tvPosto = itemView.findViewById(R.id.tvPosto);

        this.layout.setOnClickListener(this);
    }

    public void atualizaLista(Abastecimento abastece){
        Log.d("a", "aa");
        atual = abastece;

        NumberFormat format = NumberFormat.getInstance();

        format.setMinimumIntegerDigits(1);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(2);


        tvLitro.setText(format.format(abastece.getLitros()));
        tvQuilo.setText(format.format(abastece.getQuilometragem()));
        tvPosto.setText(abastece.getPosto().getNome());
        tvData.setText( abastece.getData());
        if(abastece.getPosto().getBandeira().equals("TEXACO")){
            this.ivImagem.setImageResource(R.drawable.texaco);
        }if(abastece.getPosto().getBandeira().equals("Ipiranga")){
            this.ivImagem.setImageResource(R.drawable.ipiranga);
        }if(abastece.getPosto().getBandeira().equals("Shell")){
            this.ivImagem.setImageResource(R.drawable.shell);
        }if(abastece.getPosto().getBandeira().equals("Petrobras")){
            this.ivImagem.setImageResource(R.drawable.petrobras);
        }if(abastece.getPosto().getBandeira().equals("Outros")){
            this.ivImagem.setImageResource(R.drawable.ic_gas_station_black_36dp);
        }
    }


    @Override
    public void onClick(View v) {
        Log.d("a", "aaaaaaaaaaaaaaaaaaaaaa");

        Bundle mochila = new Bundle();
        mochila.putString("combustivel", atual.getCombustivel());
        mochila.putString("data", atual.getData());
        mochila.putDouble("litros", atual.getLitros());
        mochila.putDouble("quilometragem", atual.getQuilometragem());
        mochila.putDouble("preco", atual.getPreco());
        mochila.putDouble("precoAlcool", atual.getPosto().getPrecoAlcool());
        mochila.putDouble("precoGasolina", atual.getPosto().getPrecoGasolina());
        mochila.putString("nomePosto", atual.getPosto().getNome());
        mochila.putString("bandeira", atual.getPosto().getBandeira());

        Intent intent = new Intent(this.layout.getContext(), mostraAbastecimento.class);
        intent.putExtras(mochila);
        this.layout.getContext().startActivity(intent);

    }
}
