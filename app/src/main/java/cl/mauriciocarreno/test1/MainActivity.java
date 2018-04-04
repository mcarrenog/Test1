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

        final EditText name = findViewById(R.id.nameET);
        final EditText password = findViewById(R.id.passwordET);
        Button login = findViewById(R.id.loginBtn);

        Switch switchButton = findViewById(R.id.switchBtn);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true)
                {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userPassword = password.getText().toString();

                if(!userName.equals("") && !userPassword.equals("")) {

                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("Name", userName);
                    intent.putExtra("Password", userPassword);
                    startActivity(intent);
                }
            }
        });

    }
}
