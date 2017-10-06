package latitude_pc.app.prueba1.com.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText UserName;
    private EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUserName = (EditText) findViewById(R.id.etUserName);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName.setText(getIntent().getStringExtra("User"));
        etPassword.setText(getIntent().getStringExtra("Pass"));

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView registerLink = (TextView) findViewById((R.id.tvRegister));


        registerLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    EditText etUserName = (EditText) findViewById(R.id.etUserName);
                    EditText etPassword = (EditText) findViewById(R.id.etPassword);
                    if (etUserName.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {
                        String mensaje = "Ingrese porfavor: ";
                        if (etUserName.getText().toString().isEmpty())
                            mensaje += "- usuario";
                        if (etPassword.getText().toString().isEmpty())
                            mensaje += "- contraseÃ±a";
                        Toast.makeText(LoginActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent homeIntent = new Intent(LoginActivity.this, ProjectsView.class);
                        LoginActivity.this.startActivity(homeIntent);
                        Toast.makeText(LoginActivity.this, "Bienvenido "+etUserName.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception ex)
                {
                    Toast.makeText(LoginActivity.this,ex.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
