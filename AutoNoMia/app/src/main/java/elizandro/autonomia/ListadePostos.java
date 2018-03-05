package elizandro.autonomia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ListadePostos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_postos);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvListaPosto);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());

        AdapterPosto adaptador = new AdapterPosto();
        adaptador.setListaPosto( MainActivity.listaPostos);

        rvLista.setAdapter( adaptador );
    }

    public void addPosto(View view){
        Intent intent = new Intent(getApplicationContext(), addPosto.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvListaPosto);
        rvLista.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));
        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setItemAnimator(new DefaultItemAnimator());

        AdapterPosto adaptador = new AdapterPosto();
        adaptador.setListaPosto( MainActivity.listaPostos);

        rvLista.setAdapter( adaptador );
    }
}
