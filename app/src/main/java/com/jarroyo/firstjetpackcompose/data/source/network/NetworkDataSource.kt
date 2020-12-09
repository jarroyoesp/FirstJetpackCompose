package com.jarroyo.firstjetpackcompose.data.source.network

import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.domain.model.Response

abstract class NetworkDataSource {
    abstract suspend fun getBreedList(): Response<List<Breed>?>
    abstract suspend fun getBreedImage(name: String): Response<String?>
}