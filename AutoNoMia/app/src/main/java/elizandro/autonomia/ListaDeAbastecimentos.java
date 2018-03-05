package elizandro.autonomia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAbastecimentos extends AppCompatActivity {

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
        adaptador.setListaAbastecimento( MainActivity.listaAbastece);

        rvLista.setAdapter( adaptador );
    }

    public void AddBastecimento(View view){
        Intent intent = new Intent(getApplicationContext(), AddAbastecimento.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());

        AdapterAbastecimento adaptador = new AdapterAbastecimento();
        adaptador.setListaAbastecimento( MainActivity.listaAbastece);

        rvLista.setAdapter( adaptador );

    }
}
