package elizandro.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Circulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        setTitle("Área do circulo");

        TextView tvArea = (TextView) findViewById(R.id.tvArea);
        Double area = getIntent().getExtras().getDouble("area");
        tvArea.setText("Área: " + area.toString() + " cm²");
    }

    public void Reiniciar(View cliclou){
        setResult(RESULT_OK);
        finish();
    }







    public void naook(View clicou){
        finish();
    }
}
