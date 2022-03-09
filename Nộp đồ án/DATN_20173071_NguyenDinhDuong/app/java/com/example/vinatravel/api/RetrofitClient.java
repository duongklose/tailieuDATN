package com.example.vinatravel.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class dùng để tạo đối tượng retrofit2 để call api
 *
 * @author vanson
 */
public class RetrofitClient {

    /**
     * Base url của api
     */
    private static final String BASE_URL = "http://localhost:5000/api/v1/";

    /**
     * Khi chưa có đối tượng retrofit2 thì khởi tạo bằng null
     */
    private static Retrofit retrofitClient = null;

    /**
     * Khởi tạo chỉ một đối tượng retrofit dùng để call api
     *
     * @return Retrofit là đối tượng dùng để gọi API
     */
    public static Retrofit getInstance() {
        if (retrofitClient == null)
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofitClient;
    }
}
