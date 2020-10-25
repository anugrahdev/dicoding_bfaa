package com.anugrahdev.bffasubmission.networks

import com.anugrahdev.bffasubmission.BuildConfig
import com.anugrahdev.bffasubmission.data.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {

    private fun retrofitInstance(): Retrofit {

        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }
        logging.level = HttpLoggingInterceptor.Level.BODY


        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientBuilder.build())
                .build()
    }

    fun <T> getApiService(service: Class<T>): T {
        return retrofitInstance().create(service)
    }
}