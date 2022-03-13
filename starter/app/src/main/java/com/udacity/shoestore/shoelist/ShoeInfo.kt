package com.udacity.shoestore.shoelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShoeInfo(val shoeNameValue: String, val companyNameValue: String, val shoeSizeValue: String, val descriptionValue: String): ViewModel() {
    val shoeName = MutableLiveData<String>(shoeNameValue)
    val companyName = MutableLiveData<String>(companyNameValue)
    val shoeSize = MutableLiveData<String>(shoeSizeValue)
    val description = MutableLiveData<String>(descriptionValue)


    fun getDescriptionVal(): String {
        return description.value ?: ""
    }

    fun getShoeSizeVal(): String {
        return shoeSize.value ?: ""
    }

    fun getCompanyNameVal(): String {
        return companyName.value ?: ""
    }

    fun getShoeNameVal(): String {
        return shoeName.value ?: ""
    }
}