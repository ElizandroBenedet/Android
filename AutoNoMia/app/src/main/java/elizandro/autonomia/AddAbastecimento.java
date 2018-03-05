package elizandro.autonomia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import io.realm.Realm;

import static elizandro.autonomia.MainActivity.listaPostos;

public class AddAbastecimento extends AppCompatActivity{
    EditText etData;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;

    Calendar calendario = Calendar.getInstance();

    private ArrayAdapter<Posto> postos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abastecimento);
        setTitle("Abastecimento");

        sDayIni = calendario.get(Calendar.DAY_OF_MONTH);
        sMonthIni = calendario.get(Calendar.MONTH);
        sYearIni = calendario.get(Calendar.YEAR);

        etData = (EditText) findViewById(R.id.etData);
        etData.setText(Integer.toString(sDayIni) + "/" + Integer.toString(sMonthIni) + "/" + Integer.toString(sYearIni));

        etData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });

        Spinner spPosto = (Spinner) findViewById(R.id.spPosto);
        this.postos = new ArrayAdapter<Posto>(this, android.R.layout.simple_spinner_item, listaPostos);
        spPosto.setAdapter(postos);
    }

    private void colocar_fecha() {
        etData.setText((mDayIni) + "/" + (mMonthIni+1) + "/" + mYearIni + " ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }

    public void confirmar(View clicou){
        EditText etQuilo = (EditText) findViewById(R.id.etQuilo);
        EditText etLitros = (EditText) findViewById(R.id.etLitros);
        Spinner spPostos = (Spinner) findViewById(R.id.spPosto);

        RadioButton rbAlcool = (RadioButton) findViewById(R.id.rbAlcool);

        int aux = MainActivity.listaAbastece.size();
        if( etLitros.getText().toString().equals("") || etQuilo.getText().toString().equals("")
                || etData.getText().toString().equals("") || spPostos.getSelectedItem() == null){
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(aux != 0) {
            if (Double.parseDouble(etQuilo.getText().toString()) < MainActivity.listaAbastece.get(aux - 1).getQuilometragem()) {
                Toast.makeText(getApplicationContext(), "Quilometragem tem que ser maior do que do último abastecimento inserido", Toast.LENGTH_SHORT).show();
                return;
            }
        }





            Double quilo = Double.parseDouble(etQuilo.getText().toString());
            Double litro = Double.parseDouble(etLitros.getText().toString());
            String data = etData.getText().toString();
            String combustivel;

            if(rbAlcool.isChecked()){
                combustivel = "Alcool";
            }else {
                combustivel = "Gasolina";
            }

        Posto posto =(Posto) spPostos.getSelectedItem();

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Abastecimento abastece = realm.createObject(Abastecimento.class);
        abastece.setCombustivel(combustivel);
        abastece.setData(data);
        abastece.setLitros(litro);
        abastece.setPosto(posto);
        abastece.setQuilometragem(quilo);
        abastece.setID(MainActivity.listaAbastece.size()+1);
        if(combustivel.equals("gasolina")){
            abastece.setPreco(litro * posto.getPrecoGasolina());
        }else{
            abastece.setPreco(litro * posto.getPrecoAlcool());
        }

        realm.copyFromRealm(abastece);

        realm.commitTransaction();


        MainActivity.listaAbastece.add(abastece);
        finish();


    }

    public void AddPosto(View view){

        Intent intencao = new Intent(getApplicationContext(), addPosto.class);
        startActivity(intencao);
    }

    @Override
    protected void onResume() {
         Spinner spPosto = (Spinner) findViewById(R.id.spPosto);
        this.postos = new ArrayAdapter<Posto>(this, android.R.layout.simple_spinner_item, listaPostos);
        spPosto.setAdapter(postos);
        super.onResume();


    }
}
