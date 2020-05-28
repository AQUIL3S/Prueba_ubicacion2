package com.example.funciona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.funciona.io.MyApiAdapter;
import com.example.funciona.io.response.DatosCiudad;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DatosCiudad> {
public String latitud;
public String longitud;
EditText latText;
EditText lonText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latText =(EditText)findViewById (R.id.latitudText);
        lonText =(EditText)findViewById (R.id.longitudText);
    }

    public void localizar(View view) {
        latitud = latText.getText().toString();
        longitud = lonText.getText().toString();

        //accionamos la peticion y guardamos la respuesta con el tipo parseado de json
        //cambair a <DatosCiudad>
        Call<DatosCiudad> call = MyApiAdapter.getApiService().getCiudad();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<DatosCiudad> call, Response<DatosCiudad> response) {
        if(response.isSuccessful()){
//            DatosCiudad ciudad = response.body();
            DatosCiudad ciudad = response.body();
            Log.d("onResponse ciudad","aqui ciudad.tostring");
        }
    }

    @Override
    public void onFailure(Call<DatosCiudad> call, Throwable t) {
        Log.d("onFailure ciudad","aqui ciudad.tostring");
    }
}
