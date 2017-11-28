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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    @Override
    protected void onResume(){



        TextView tvAuto = (TextView) findViewById(R.id.tvAuto);

        int i = ListaDeAbastecimentos.listaAbastece.size();
        if(i > 1){
            Double quilo = ListaDeAbastecimentos.listaAbastece.get(i-1).getQuilometragem() -
                    ListaDeAbastecimentos.listaAbastece.get(0).getQuilometragem();
            Double litro = ListaDeAbastecimentos.listaAbastece.get(i-2).getLitros();

            Double autonomia = quilo / litro;
            tvAuto.setText(String.format("%.2f", autonomia));
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
