package com.srm.mygithubprojects.data.library.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val baseUrl = "https://api.github.com/"
    private val retrofitClient : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val githubService: GithubService = retrofitClient.build().create(GithubService::class.java)
}