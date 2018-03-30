package cl.mauriciocarreno.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre = findViewById(R.id.nombreET);
        final EditText contrasena = findViewById(R.id.contrasenaET);
        Button login = findViewById(R.id.loginBtn);

        Switch switchButton = findViewById(R.id.switchBtn);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true)
                {
                    contrasena.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    contrasena.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = nombre.getText().toString();
                String Contrasena = contrasena.getText().toString();

                Intent intentDatos = new Intent(getApplicationContext(), BienvenidaActivity.class);
                intentDatos.putExtra("Nombre", Nombre);
                intentDatos.putExtra("Contrasena", Contrasena);
                startActivity(intentDatos);
            }
        });

    }
}
