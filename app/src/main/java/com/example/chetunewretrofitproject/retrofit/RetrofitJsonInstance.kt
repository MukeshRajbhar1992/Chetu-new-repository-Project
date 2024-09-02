package com.example.chetunewretrofitproject.retrofit

import com.example.chetunewretrofitproject.Constants
import com.example.chetunewretrofitproject.apiutil.ApiInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitJsonInstance {

    private val retrofitJsonInstance: Retrofit.Builder by lazy {
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
            .baseUrl(Constants.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }
    val apiInterface: ApiInterface by lazy {
        retrofitJsonInstance.build().create(ApiInterface::class.java)
    }
}