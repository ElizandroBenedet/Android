package elizandro.autonomia;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by elizandro on 22/11/17.
 */

public class HolderAbastecimento extends ViewHolder {

    private TextView tvData;
    private TextView tvLitro;
    private TextView tvQuilo;
    private ImageView ivImagem;

    public HolderAbastecimento(View itemView) {
        super(itemView);

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvQuilo = itemView.findViewById(R.id.tvQuilo);
        this.tvLitro = itemView.findViewById(R.id.tvLitro);
        this.ivImagem = itemView.findViewById(R.id.ivImagem);
    }

    public void atualizaLista(Abastecimento abastece){

        NumberFormat decimal = NumberFormat.getInstance();
        decimal.setMaximumFractionDigits(2);
        decimal.setMinimumIntegerDigits(1);
        decimal.setRoundingMode(RoundingMode.HALF_UP);
        tvLitro.setText( decimal.format(abastece.getLitros()).toString());


        tvQuilo.setText( decimal.format(abastece.getQuilometragem()).toString());
        tvData.setText( abastece.getData());

        if(abastece.getPosto().equals("TEXACO")){
            this.ivImagem.setImageResource(R.drawable.texaco);
        }if(abastece.getPosto().equals("Ipiranga")){
            this.ivImagem.setImageResource(R.drawable.ipiranga);
        }if(abastece.getPosto().equals("Shell")){
            this.ivImagem.setImageResource(R.drawable.shell);
        }if(abastece.getPosto().equals("Petrobras")){
            this.ivImagem.setImageResource(R.drawable.petrobras);
        }if(abastece.getPosto().equals("Outros")){
            this.ivImagem.setImageResource(R.drawable.ic_gas_station_black_36dp);
        }
    }
}
