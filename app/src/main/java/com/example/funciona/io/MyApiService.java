package com.example.funciona.io;

import com.example.funciona.io.response.DatosCiudad;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {
    //request particular
    @GET("findNearbyPlaceNameJSON?lat=42.814948&lng=-1.639035&username=andreshdm")
    //cambiar a <DatosCiudad>
    Call<DatosCiudad> getCiudad();
    //los datos json se parsean a instancia java de la clase DatosCiudad
}
