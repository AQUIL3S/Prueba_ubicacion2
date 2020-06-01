package com.example.funciona.io.Interface;

import android.text.GetChars;

import com.example.funciona.io.response.Geonames;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface GeonamesApi {
    //esta interface hace lo mismo que la de myapiservice
    @GET("findNearbyPlaceNameJSON?lat=42.814948&lng=-1.639035&username=andreshdm")
    Call<Geonames> getDatos();
}
