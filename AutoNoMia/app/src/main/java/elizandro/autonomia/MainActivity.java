package elizandro.autonomia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    public static ArrayList <Posto> listaPostos = new ArrayList<>();
    public static ArrayList <Abastecimento> listaAbastece = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();
        MainActivity.listaAbastece = new ArrayList<>(realm.where(Abastecimento.class).findAll());
        MainActivity.listaPostos = new ArrayList<>(realm.where(Posto.class).findAll());


    }

    @Override
    protected void onResume(){


        TextView tvAuto = (TextView) findViewById(R.id.tvAuto);

        int i = MainActivity.listaAbastece.size();
        if(i > 1){
            Double quilo = MainActivity.listaAbastece.get(i-1).getQuilometragem() -
                    MainActivity.listaAbastece.get(0).getQuilometragem();
            Double litro = MainActivity.listaAbastece.get(i-2).getLitros();

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

    public void Postos(View view){
        Intent intencao = new Intent(getApplicationContext(), ListadePostos.class);
        startActivity(intencao);
    }


}
