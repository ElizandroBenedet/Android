package elizandro.autonomia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class mostraAbastecimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_abastecimento);
        TextView tvPreco = (TextView) findViewById(R.id.tvPreco);
        TextView tvPosto = (TextView) findViewById(R.id.tvPosto);
        TextView tvPrecoComb = (TextView) findViewById(R.id.tvPrecoComb);
        TextView tvComb = (TextView) findViewById(R.id.tvComb);
        TextView tvData = (TextView) findViewById(R.id.tvData);
        TextView tvLitros = (TextView) findViewById(R.id.tvLitros);
        TextView tvKm = (TextView) findViewById(R.id.tvKm);
        ImageView ivPosto = (ImageView) findViewById(R.id.ivPosto);

        String aux = getIntent().getExtras().getString("nomePosto", "Indisponivel");
        tvPosto.setText(aux);
        Double aux1 = getIntent().getExtras().getDouble("preco", 0.0);
        tvPreco.setText("R$ " + aux1.toString());
        aux = getIntent().getExtras().getString("data", "Indisponivel");
        tvData.setText(aux);
        aux1 = getIntent().getExtras().getDouble("litros", 0.0);
        tvLitros.setText(aux1.toString() + " litros");
        aux1 = getIntent().getExtras().getDouble("quilometragem", 0.0);
        tvKm.setText(aux1.toString() + " Km");
        aux = getIntent().getExtras().getString("combustivel", "Indisponivel");
        tvComb.setText(aux);
        if(aux.equals("alcool")){
            aux1 = getIntent().getExtras().getDouble("precoAlcool");
        }else {
            aux1 = getIntent().getExtras().getDouble("precoGasolina");
        }
        tvPrecoComb.setText("R$ " +aux1.toString());

        String posto = getIntent().getExtras().getString("bandeira");

        if(posto.equals("TEXACO")){
            ivPosto.setImageResource(R.drawable.texaco);
        }if(posto.equals("Petrobras")){
            ivPosto.setImageResource(R.drawable.petrobras);
        }if(posto.equals("Ipiranga")){
            ivPosto.setImageResource(R.drawable.ipiranga);
        }if(posto.equals("Shell")){
            ivPosto.setImageResource(R.drawable.shell);
        }if(posto.equals("Outros")){
            ivPosto.setImageResource(R.drawable.ic_gas_station_black_36dp);
        }

    }
}
