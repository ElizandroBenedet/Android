package elizandro.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AreaCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);
        setTitle("Dados do circulo");
    }

    public void Calcular(View clicou){
        EditText etRaio = (EditText) findViewById(R.id.etRaio);

        if(etRaio.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle();

        try {
            Double area =  Double.parseDouble(etRaio.getText().toString());
            area = area * area * 3.14;

            mochila.putDouble("area", area);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao converter os dados", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), Circulo.class);
        intencao.putExtras(mochila);
        startActivityForResult(intencao, 6);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 6 && resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }else if(resultCode == RESULT_CANCELED){
            return;
        }
    }
}
