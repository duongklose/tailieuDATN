package com.example.vinatravel.api;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

//    Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy:MM:dd HH:mm:ss")
//                .create();
//
//    ApiService apiService = new Retrofit.Builder()
//                                .baseUrl("http://localhost:5000/api/v1/")
//                                .addConverterFactory(GsonConverterFactory.create(gson))
//                                .build()
//                                .create(ApiService.class);

    @GET("users")
    Call<List<User>> getListUser();
}
