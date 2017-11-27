package elizandro.autonomia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Double litros= 0.0;
    private Double Km = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    @Override
    protected void onResume(){


        NumberFormat decimal = NumberFormat.getInstance();
        decimal.setMaximumFractionDigits(2);
        decimal.setMinimumIntegerDigits(1);
        decimal.setRoundingMode(RoundingMode.HALF_UP);


        TextView tvAuto = (TextView) findViewById(R.id.tvAuto);

        int i = ListaDeAbastecimentos.listaAbastece.size();
        if(i > 1) {
            this.litros += ListaDeAbastecimentos.listaAbastece.get(i - 1).getLitros();
            this.Km += (ListaDeAbastecimentos.listaAbastece.get(i - 1).getQuilometragem()
                    - ListaDeAbastecimentos.listaAbastece.get(i - 2).getQuilometragem());
            Double autonomia = this.Km / this.litros;

            tvAuto.setText(decimal.format(autonomia).toString());
        }






        super.onResume();
    }

    public void AddAbastecimento(View clicou){
        Intent intencao = new Intent(getApplicationContext(), AddAbastecimento.class);
        startActivity(intencao);
    }

    public void ListaAbastecimento(View view){
        Intent intencao = new Intent(getApplicationContext(), ListaDeAbastecimentos.class);
        startActivity(intencao);
    }


}
