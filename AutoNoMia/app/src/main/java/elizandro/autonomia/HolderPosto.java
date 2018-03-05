package elizandro.autonomia;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by elizandro on 01/12/17.
 */

public class HolderPosto extends ViewHolder {


    private TextView tvNome;
    private TextView tvGasolina;
    private TextView tvAlcool;
    private ImageView ivImagem;
    public ConstraintLayout layout;

    public HolderPosto(View itemView) {
        super(itemView);
        this.tvAlcool = itemView.findViewById(R.id.tvAlcool);
        this.tvGasolina = itemView.findViewById(R.id.tvGasolina);
        this.tvNome = itemView.findViewById(R.id.tvNome);
        this.ivImagem = itemView.findViewById(R.id.ivBandeira);
        this.layout = itemView.findViewById(R.id.clPosto);
    }

    public void atualizaLista(Posto posto){

        NumberFormat format = NumberFormat.getInstance();

        format.setMinimumIntegerDigits(1);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(3);


        tvNome.setText(posto.getNome());
        tvAlcool.setText(format.format(posto.getPrecoAlcool()));
        tvGasolina.setText(format.format(posto.getPrecoGasolina()));


        if(posto.getBandeira().toString().equals("TEXACO")){
            this.ivImagem.setImageResource(R.drawable.texaco);
        }if(posto.getBandeira().toString().equals("Ipiranga")){
            this.ivImagem.setImageResource(R.drawable.ipiranga);
        }if(posto.getBandeira().toString().equals("Shell")){
            this.ivImagem.setImageResource(R.drawable.shell);
        }if(posto.getBandeira().toString().equals("Petrobras")){
            this.ivImagem.setImageResource(R.drawable.petrobras);
        }if(posto.getBandeira().toString().equals("Outros")){
            this.ivImagem.setImageResource(R.drawable.ic_gas_station_black_36dp);
        }
    }
}
