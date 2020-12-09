package com.jarroyo.firstjetpackcompose.domain.model

import com.google.gson.annotations.SerializedName

data class BreedApi(
    var status: String? = null,
    @SerializedName("message")
    var nameList: List<String>?
)

fun BreedApi.toModel(): List<Breed>? {
    var list = mutableListOf<Breed>()
    nameList?.let {
        for (name in it)
            list.add(Breed(name))
    }

    return list
}

data class BreedImageApi(
    var status: String? = null,
    @SerializedName("message")
    var image: String? = null
)