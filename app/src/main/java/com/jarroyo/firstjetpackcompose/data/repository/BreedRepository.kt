package com.jarroyo.firstjetpackcompose.data.repository

import com.jarroyo.firstjetpackcompose.data.source.network.BreedService
import com.jarroyo.firstjetpackcompose.data.source.network.NetworkDataSource
import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.domain.model.Response

class BreedRepository(
    private val networkDataSource: NetworkDataSource
) {

    /***********************************************************************************************
     * GET BREED LIST
     **********************************************************************************************/
    suspend fun getBreedsList(): Response<List<Breed>?> {
        val response = networkDataSource.getBreedList()
        return response
    }
}