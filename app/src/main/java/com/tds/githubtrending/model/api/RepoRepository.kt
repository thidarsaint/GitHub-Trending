package com.tds.githubtrending.model.api

import com.tds.githubtrending.model.GitHubTrending
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository {
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitHubTrending?) -> Unit){     //Unit is parameter as in front
        ApiClient.instance.getRepo().enqueue(
            object : Callback<GitHubTrending>{
                override fun onFailure(call: Call<GitHubTrending>, t: Throwable) {
                    onResult(false, null)
                }

                override fun onResponse(
                    call: Call<GitHubTrending>,
                    response: Response<GitHubTrending>
                ) {
                    if(response != null && response.isSuccessful){
                        onResult(true, response.body())
                    }else{
                        onResult(false, null)
                    }
                }

            }
        )
    }
    companion object{
        private var INSTANCE : RepoRepository? = null
        fun getInstance9() = INSTANCE ?: RepoRepository().also {
            INSTANCE = it
        }
    }
}