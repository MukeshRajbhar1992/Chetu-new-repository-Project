package com.example.chetunewretrofitproject.retrofit

import com.example.chetunewretrofitproject.Constants
import com.example.chetunewretrofitproject.apiutil.ApiInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTmdbInstance {


    private val retrofitTmdbInstance: Retrofit.Builder by lazy {
        val httpIntercept = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(httpIntercept)
//                .connectTimeout(20, TimeUnit.SECONDS)
//                .readTimeout(20, TimeUnit.SECONDS)
//            writeTimeout(20, TimeUnit.SECONDS)
        }.build()
        Retrofit.Builder()
            .baseUrl(Constants.TMDB_BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }
    val apiInterface: ApiInterface by lazy {
        retrofitTmdbInstance.build().create(ApiInterface::class.java)
    }
}