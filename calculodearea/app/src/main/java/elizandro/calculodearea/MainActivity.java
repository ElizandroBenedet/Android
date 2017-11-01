package elizandro.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cálculo de área");
    }

    public void abrirInfo(View clicou){
        RadioGroup rgFormas = (RadioGroup) findViewById(R.id.rgForma);

        if(rgFormas.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Selecione a forma", Toast.LENGTH_SHORT).show();
            return;
        }

        if(rgFormas.getCheckedRadioButtonId() == R.id.rbCirculo){
            Intent intencao = new Intent(getApplicationContext(), AreaCirculo.class);
            startActivity(intencao);

        }else if(rgFormas.getCheckedRadioButtonId() == R.id.rbQuadrado){
            Intent intencao = new Intent(getApplicationContext(), AreaQuadrado.class);
            startActivity(intencao);
        } else if(rgFormas.getCheckedRadioButtonId() == R.id.rbTriangulo){
            Intent intencao = new Intent(getApplicationContext(), AreaTriangulo.class);
            startActivity(intencao);

        }


    }

}
