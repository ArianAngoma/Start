package com.cursania.ccmejia.cursaniaandroid.Views.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursania.ccmejia.cursaniaandroid.Data.Preferences.SessionPreferences;
import com.cursania.ccmejia.cursaniaandroid.R;

public class WelcomeActivity extends AppCompatActivity {

    private SessionPreferences prefs;
    private TextView tvNombre,tvEmail;
    private Button btnRooms;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        prefs = new SessionPreferences(getApplicationContext());

        tvNombre = findViewById(R.id.txt_name_info);
        btnRooms = findViewById(R.id.btn_rooms);
        btnClose = findViewById(R.id.btn_logout);
        //tvEmail = findViewById(R.id.tvEmail);

        /**imgEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this,EditarPerfilActivity.class);
                startActivity(i);
            }
        });**/

        tvNombre.setText("Bienvenido " + prefs.getUsuario().getName());

        btnClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                prefs.cerrarSesion();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                },3000);
            }
        });

        btnRooms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this,ListaCuartosActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                },3000);
            }
        });
    }
}
