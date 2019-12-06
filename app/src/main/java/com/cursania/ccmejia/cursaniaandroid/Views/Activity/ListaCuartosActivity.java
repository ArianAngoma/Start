package com.cursania.ccmejia.cursaniaandroid.Views.Activity;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cursania.ccmejia.cursaniaandroid.Data.Api.Api;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.Cuarto;
import com.cursania.ccmejia.cursaniaandroid.R;
import com.cursania.ccmejia.cursaniaandroid.Views.Adapter.CuartosAdapter;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCuartosActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getSimpleName();

    private RecyclerView cuartosList;
    private ProgressBar pdBar;
    private FloatingActionButton btnRegisterCuarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuartosList = findViewById(R.id.recyclerViewListCuartos);
        pdBar = findViewById(R.id.progress);
        btnRegisterCuarto = findViewById(R.id.btnRegisterRoom);

        cuartosList.setLayoutManager(new LinearLayoutManager(this));
        cuartosList.setAdapter(new CuartosAdapter());

        btnRegisterCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaCuartosActivity.this,RegisterCuartoActivity.class));
            }
        });

        initialize();

    }

    private void initialize() {

        Call<List<Cuarto>> call = Api.getApi().getCuartos();
        call.enqueue(new Callback<List<Cuarto>>() {
            @Override
            public void onResponse(Call<List<Cuarto>> call, Response<List<Cuarto>> response) {
                try{
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code:" + statusCode);

                    if (response.isSuccessful())
                    {
                        pdBar.setVisibility(View.INVISIBLE);
                        List<Cuarto> cuartos = response.body();
                        Log.d(TAG, "cuartos" + cuartos);

                        CuartosAdapter adapter = (CuartosAdapter) cuartosList.getAdapter();
                        adapter.setCuartos(cuartos);
                        adapter.notifyDataSetChanged();

                    }else{
                        Log.d(TAG, "onError" + response.errorBody().string());
                        throw  new Exception("Error en el Servicio");
                    }
                }catch (Throwable t){
                    try{
                        Log.d(TAG, "onThrowable: "+ t.toString(), t);
                        Toast.makeText(ListaCuartosActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Cuarto>> call, Throwable t) {
                Log.d(TAG, "onFailure: " +t.toString() );
                Toast.makeText(ListaCuartosActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
