package elizandro.autonomia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.realm.Realm;

public class addPosto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_posto);
    }

    public void Salvar(View view){
        EditText etNome = (EditText) findViewById(R.id.etNome);
        EditText etPrecoGasosa = (EditText) findViewById(R.id.etPrecoGasosa);
        EditText etPrecoAlcool = (EditText) findViewById(R.id.etPrecoAlcool);
        Spinner spBandeira = (Spinner) findViewById(R.id.spBandeira);



        if(etNome.getText().toString().equals("") || etPrecoAlcool.getText().toString().equals("") ||
                etPrecoGasosa.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Favor completar todos os campos...", Toast.LENGTH_LONG).show();
            return;
        }


        if(spBandeira.getSelectedItem().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Favor selecionar uma bandeira...", Toast.LENGTH_LONG).show();
            return;
        }

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Posto postoRealm = realm.createObject(Posto.class);

        postoRealm.setBandeira(spBandeira.getSelectedItem().toString());
        postoRealm.setNome(etNome.getText().toString());
        postoRealm.setPrecoAlcool(Double.parseDouble(etPrecoAlcool.getText().toString()));
        postoRealm.setPrecoGasosina(Double.parseDouble(etPrecoGasosa.getText().toString()));
        postoRealm.setID(MainActivity.listaPostos.size());

        realm.copyFromRealm(postoRealm);

        realm.commitTransaction();



        MainActivity.listaPostos.add(postoRealm);
        finish();
    }
}
