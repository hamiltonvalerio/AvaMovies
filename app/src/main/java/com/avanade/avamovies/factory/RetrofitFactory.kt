package com.avanade.avamovies.factory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val URL: String = "https://jsonplaceholder.typicode.com/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}