package com.tds.githubtrending.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){

    val dataLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val empty = MutableLiveData<Boolean>().apply {
        value = false
    }

    val message = MutableLiveData<String>()

}