package com.cs4520.assignment4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    var productList = MutableLiveData<ProductList>()

    fun fetchProducts() {
        viewModelScope.launch {
            productList.value = ApiProduct.service.getProducts().body()
        }
    }
}