package elizandro.autonomia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAbastecimentos extends AppCompatActivity {

    public static ArrayList<Abastecimento> listaAbastece = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_abastecimentos);



        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());

        AdapterAbastecimento adaptador = new AdapterAbastecimento();
        adaptador.setListaAbastecimento( listaAbastece);

        rvLista.setAdapter( adaptador );
    }
}
