package cl.mauriciocarreno.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        TextView bienvenido = findViewById(R.id.usuarioTV);
        String Usuario = getIntent().getStringExtra("Nombre");

        bienvenido.setText("Bienvenido " + Usuario + "!");
    }
}
