package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListModel: ViewModel() {
    data class ShoeInfo(
        val shoeName: String,
        val companyName: String,
        val shoeSize: Int,
        val description: String
    )

    val shoeList: LiveData<List<ShoeInfo>> = MutableLiveData<List<ShoeInfo>>();

    init {
        setDefaultShoeList()
    }

    private fun setShoeListVal(newList: List<ShoeInfo>) {
        (shoeList as MutableLiveData).value = newList;
    }

    private fun getShoeListVal(): List<ShoeInfo> {
        return shoeList.value ?: listOf<ShoeInfo>()
    }

    private fun setDefaultShoeList() {
        val newList = listOf<ShoeInfo>(
            ShoeInfo("Loafers", "Puma", 10,"Casual Shoes"),
            ShoeInfo("Moccasin", "Reebok", 9, "Casual Shoes"),
            ShoeInfo("Sneakers", "Hummel", 7, "Casual Shoes"),
            ShoeInfo("Boots", "Red chief", 9, "Casual/Formal"),
            ShoeInfo("Sandals", "Sparx", 8, "Casual"),
            ShoeInfo("Lace Up", "Action", 6, "Formal"),
            ShoeInfo("Canvas", "Converse", 8, "Casual"),
            ShoeInfo("Chukkas", "Grenson", 7, "Formal/Casual"),
            ShoeInfo("Derby", "Clarks", 9,"Formals"),
            ShoeInfo("Brogue Shoes", "UCB", 7,"Formals / Wedding")
        )

        setShoeListVal(newList);
    }

    fun addShoe(shoe: ShoeInfo) {
        val newList = getShoeListVal().toMutableList()
        newList.add(shoe)
        setShoeListVal(newList)
    }
}