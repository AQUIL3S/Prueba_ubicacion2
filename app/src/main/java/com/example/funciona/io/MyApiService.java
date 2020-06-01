package com.example.funciona.io;

import com.example.funciona.io.response.Geonames;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {
    //request particular

    //cambiar a <Geonames>
    @GET("findNearbyPlaceNameJSON?lat=42.814948&lng=-1.639035&username=andreshdm")
    Call<Geonames> getCiudad();
    //los datos json se parsean a instancia java de la clase Geonames
}
