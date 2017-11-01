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
        Intent intencao = new Intent(getApplicationContext(), MainActivity.class);
        intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intencao);
    }
}
