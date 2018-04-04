package cl.mauriciocarreno.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcome = findViewById(R.id.userTV);
        String user = getIntent().getStringExtra("Name");

        welcome.setText("Bienvenido " + user + "!");
    }
}
