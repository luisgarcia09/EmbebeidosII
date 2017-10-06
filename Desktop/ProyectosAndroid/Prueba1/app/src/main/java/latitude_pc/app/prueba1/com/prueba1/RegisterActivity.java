package latitude_pc.app.prueba1.com.prueba1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                final EditText etUserName = (EditText) findViewById(R.id.etNewUserName);
                final EditText etName = (EditText) findViewById(R.id.etName);
                final EditText etPassword = (EditText) findViewById(R.id.etNewPassword);
                final EditText etPasswordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
                final String nombre = etName.getText().toString();
                final String user = etUserName.getText().toString();
                final String Pass = etPassword.getText().toString();
                final String Pass2 = etPasswordConfirm.getText().toString();
                /*final String name = etName.getText().toString();
                final String username = etUserName.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {*/
                            if(nombre.isEmpty() || user.isEmpty() || Pass.isEmpty() || Pass2.isEmpty()) {
                                Toast.makeText(RegisterActivity.this,"Ingrese los datos que falten",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if(!Pass.equals(Pass2))
                                    Toast.makeText(RegisterActivity.this,"Las contraseÃ±as no coinciden",Toast.LENGTH_SHORT).show();
                                else {
                                    try {

                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        intent.putExtra("User",user);
                                        intent.putExtra("Pass",Pass);
                                        RegisterActivity.this.startActivity(intent);
                                    }
                                    catch (Exception ex){
                                        Toast.makeText(RegisterActivity.this,ex.getMessage(),Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }
                            /*} else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };
                RegisterRequest registerRequest = new RegisterRequest(name, username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);*/
            }
        });
    }
}

