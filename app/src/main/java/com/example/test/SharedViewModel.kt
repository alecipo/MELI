package com.example.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.Results

class SharedViewModel : ViewModel() {

    private lateinit var Product: MutableLiveData<Results>

    fun setObj(prod: MutableLiveData<Results>) {
        Product = prod
    }

    fun getObj(): LiveData<Results> {
        return Product
    }
}