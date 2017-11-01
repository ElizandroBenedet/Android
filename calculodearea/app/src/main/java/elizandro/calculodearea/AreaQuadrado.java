package elizandro.calculodearea;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AreaQuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_quadrado);
        setTitle("Dados do quadrado");
    }

    public void Calcular(View clicou){
        EditText etBase = (EditText) findViewById(R.id.etBase);
        EditText etAltura = (EditText) findViewById(R.id.etAltura);
        if(etAltura.getText().toString().equals("") || etBase.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle();

            try {
                Double area = Double.parseDouble(etBase.getText().toString()) * Double.parseDouble(etAltura.getText().toString());

                mochila.putDouble("area", area);
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Erro ao converter os dados", Toast.LENGTH_LONG).show();
                return;
            }

        Intent intencao = new Intent(getApplicationContext(), Quadrado.class);
        intencao.putExtras(mochila);
        startActivityForResult(intencao, 3);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3 && resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }else{
                return;
        }
    }
}
