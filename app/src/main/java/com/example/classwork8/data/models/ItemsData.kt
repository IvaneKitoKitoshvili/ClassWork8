package com.example.classwork8.data.models


import com.google.gson.annotations.SerializedName

class ItemsData : ArrayList<ItemsData.ItemDataItem>(){
    data class ItemDataItem(
        val title: String,
        val cover: String,
        val price: String,
        val liked: Boolean
    )
}