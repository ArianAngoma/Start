package com.cursania.ccmejia.cursaniaandroid.Views.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cursania.ccmejia.cursaniaandroid.Data.Preferences.SessionPreferences;
import com.cursania.ccmejia.cursaniaandroid.R;

public class PerfilActivity extends AppCompatActivity {

    private SessionPreferences prefs;
    private TextView tvNombre,tvEmail;
    private ImageView imgEditar;

    private RecyclerView cursoRecycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar pbCarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        prefs = new SessionPreferences(getApplicationContext());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Perfil");

        tvNombre = findViewById(R.id.tvNombre);
        tvEmail = findViewById(R.id.tvEmail);
        imgEditar= findViewById(R.id.imgEditar);

        imgEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PerfilActivity.this,WelcomeActivity.class);
                startActivity(i);
            }
        });

        tvNombre.setText(prefs.getUsuario().getName());
        tvEmail.setText(prefs.getUsuario().getEmail());


        pbCarga = findViewById(R.id.pbCarga);

        cursoRecycler = findViewById(R.id.cursoRecycler);

        layoutManager = new GridLayoutManager(this,2);
        cursoRecycler.setLayoutManager(layoutManager);

    }
}
