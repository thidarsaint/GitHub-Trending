package com.tds.githubtrending.model.api

import com.tds.githubtrending.model.GitHubTrending
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("search/repositories")
    fun getRepo(
        @Query("q") search : String = "trending",
        @Query("sort") sort: String = "stars"
    ):Call<GitHubTrending>
}