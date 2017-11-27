package elizandro.autonomia;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;

public class AddAbastecimento extends AppCompatActivity{
    EditText etData;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;

    Calendar calendario = Calendar.getInstance();

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
        Button btConfirmar = (Button) findViewById(R.id.btConfirmar);
        EditText etQuilo = (EditText) findViewById(R.id.etQuilo);
        EditText etLitros = (EditText) findViewById(R.id.etLitros);
        Spinner spPostos = (Spinner) findViewById(R.id.spPosto);

        int aux = ListaDeAbastecimentos.listaAbastece.size();
        if(etLitros.getText().toString().equals("") || etQuilo.getText().toString().equals("")
                || etData.getText().toString().equals("") || spPostos.getSelectedItem().toString().equals("Bandeira do posto")){
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(aux != 0) {
            if (Double.parseDouble(etQuilo.getText().toString()) < ListaDeAbastecimentos.listaAbastece.get(aux - 1).getQuilometragem()) {
                Toast.makeText(getApplicationContext(), "Quilometragem tem que ser maior do que do último abastecimento inserido", Toast.LENGTH_SHORT).show();
                return;
            }
        }




        {
            Double quilo = Double.parseDouble(etQuilo.getText().toString());
            Double litro = Double.parseDouble(etLitros.getText().toString());
            String data = etData.getText().toString();
            String posto = spPostos.getSelectedItem().toString();
            Abastecimento abastecimento = new Abastecimento(quilo, litro, data, posto);

            ListaDeAbastecimentos.listaAbastece.add(abastecimento);
            finish();
        }

    }
}
