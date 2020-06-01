package com.example.funciona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.funciona.io.Interface.GeonamesApi;
import com.example.funciona.io.MyApiAdapter;
import com.example.funciona.io.response.Geoname;
import com.example.funciona.io.response.Geonames;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//
public class MainActivity extends AppCompatActivity implements Callback<Geonames> {
public String latitud;
public String longitud;
EditText latText;
EditText lonText;
TextView locText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latText =(EditText)findViewById (R.id.latitudText);
        lonText =(EditText)findViewById (R.id.longitudText);
        locText = (TextView)findViewById(R.id.localizacion);
//        getDatos();

    }

    public void localizar(View view) {
        latitud = latText.getText().toString();
        longitud = lonText.getText().toString();

//        accionamos la peticion y guardamos la respuesta con el tipo parseado de json
//        cambair a <Geonames>
        Call<Geonames> call = MyApiAdapter.getApiService().getCiudad();
        call.enqueue(this);
    }
   // metodo del nuevo video
//    private void getDatos(){
//        //y esto es igual a myapiadapter
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.geonames.org/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GeonamesApi geonamesApi = retrofit.create(GeonamesApi.class);
//
//        Call<Geonames> call = geonamesApi.getDatos();
//
//        call.enqueue(new Callback<Geonames>(){
//            @Override
//            public void onResponse(Call<Geonames> call, Response<Geonames> response) {
//                if(response.isSuccessful()){
//
//                   Geonames geo = response.body();
//
////                        String content  ="Zona" + geo.getToponymName().toString();
//                    String content  = response.body().getCountryName().toString();
//
//                        locText.setText(content);
//
//                    Log.d("onResponse ciudad","aqui ciudad.tostring");
//                }
//                if(!response.isSuccessful()) {
//                    locText.setText("codigo" + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Geonames> call, Throwable t) {
//                Log.d("onFailure ciudad","aqui ciudad.tostring");
//            }
//        });
//    }
//
    @Override
    public void onResponse(Call<Geonames> call, Response<Geonames> response) {
        if(response.isSuccessful()){
                    Geonames geonames = response.body();
                    List<Geoname> lista = geonames.getGeonames();
                    String concat = "";
                   for(int i = 0; i<lista.size();i++) {

                       concat += lista.get(i).getCountryName() +"\n";
                       concat += lista.get(i).getToponymName() +"\n";
                       concat += lista.get(i).getPopulation() +"\n";
                       concat += lista.get(i).getDistance() +"\n";

                       locText.append(concat);
                   }



                    Log.d("onResponse ciudad",geonames.toString());
//                    for(Geonames geo: lista){
//                        String content  ="";
//                        content += "Pais" + geo.getCountryName() + "\n";
//                        content += "Zona" + geo.getToponymName();
//                        locText.append(content);
//                    }
                    Log.d("onResponse ciudad","");
                }
        if(!response.isSuccessful()) {
            locText.setText("codigo" + response.code());
            Log.d("onResponse error","");
        }
    }

    @Override
    public void onFailure(Call<Geonames> call, Throwable t) {
        Log.d("onFailure ciudad","aqui ciudad.tostring");
    }


}
