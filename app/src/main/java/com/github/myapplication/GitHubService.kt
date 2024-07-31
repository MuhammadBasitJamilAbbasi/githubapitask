package com.github.myapplication

import android.telecom.Call
import com.github.myapplication.Models.GitHubRepo
import com.github.myapplication.Models.GitHubUser
import com.github.myapplication.Models.GitHubUserprofile
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users")
    suspend fun getUsers(): List<GitHubUser>
    @GET("users/{username}/repos")
    suspend fun getUserRepos(@Path("username") username: String): List<GitHubRepo>
    @GET("users/{username}")
    suspend fun getUserprofile(@Path("username") username: String): GitHubUserprofile
}

object RetrofitInstance {
    private const val BASE_URL = "https://api.github.com/"

    val api: GitHubService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }
}
