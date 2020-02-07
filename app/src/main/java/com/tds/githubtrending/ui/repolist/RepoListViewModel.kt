package com.tds.githubtrending.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.tds.githubtrending.base.BaseViewModel
import com.tds.githubtrending.model.Item
import com.tds.githubtrending.model.api.RepoRepository

class RepoListViewModel : BaseViewModel(){
    val repoList = MutableLiveData<List<Item>>()

    fun fetchRepoList(){
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess){
                repoList.value = response?.items
                empty.value = false
            }else{
                empty.value = true
            }
        }


    }
}