package com.udacity.shoestore.shoelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeInfoModelFactory(val shoeNameValue: String, val companyNameValue: String, val shoeSizeValue: String, val descriptionValue: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeInfo::class.java)) {
            return ShoeInfo(shoeNameValue, companyNameValue, shoeSizeValue, descriptionValue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}