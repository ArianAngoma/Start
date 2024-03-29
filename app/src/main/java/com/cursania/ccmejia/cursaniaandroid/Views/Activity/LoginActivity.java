package com.cursania.ccmejia.cursaniaandroid.Views.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cursania.ccmejia.cursaniaandroid.Data.Api.Api;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.LoginBody;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.User;
import com.cursania.ccmejia.cursaniaandroid.Data.Preferences.SessionPreferences;
import com.cursania.ccmejia.cursaniaandroid.R;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Button btnLogin;
    private TextView tvRegistro;

    private ProgressDialog pdDialogo;
    private SessionPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = new SessionPreferences(getApplicationContext());

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnIniciarSesion);
        tvRegistro = findViewById(R.id.tvRegistro);

        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistroActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdDialogo = ProgressDialog.show(LoginActivity.this,"Iniciando sesión","Comprobando credenciales...",true,false);
                if(validar()){
                    login(etEmail.getText().toString(),etPassword.getText().toString());
                }else{
                    pdDialogo.dismiss();
                }
            }
        });

    }

    private boolean validar(){
        boolean valido = true;

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if(email.isEmpty() || !validateEmail(email)){
            valido =  false;
            etEmail.setError("El email es requerido");
        }else{
            etEmail.setError(null);
        }

        if(password.isEmpty()){
            valido =  false;
            etPassword.setError("El password es requerido");
        }else{
            etPassword.setError(null);
        }

        return valido;
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private void login(String email, String password){

        LoginBody _objLogin = new LoginBody(email,password);

        Call<User> callLogin = Api.getApi().login(_objLogin);
        callLogin.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                pdDialogo.dismiss();
                if(response.isSuccessful()){
                    toast("Usuario logueado");
                    prefs.guardarUsuario(response.body());

                    Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    toast("Usuario/Password incorrectos");
                    etPassword.setText("");
                    etPassword.setError("Password incorrecto");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                pdDialogo.dismiss();
                toast("Error al comunicarse con el servidor");
            }
        });

    }

    private void toast(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
    }
}
