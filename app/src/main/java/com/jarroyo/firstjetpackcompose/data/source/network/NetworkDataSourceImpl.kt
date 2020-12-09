package com.jarroyo.firstjetpackcompose.data.source.network

import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.domain.model.Response
import com.jarroyo.firstjetpackcompose.domain.model.toModel
import java.io.IOException

class NetworkDataSourceImpl(val breedService: BreedService): NetworkDataSource() {

    override suspend fun getBreedList(): Response<List<Breed>?> {
        try {
           /* if (networkSystem.isNetworkAvailable()) {*/
                val response = breedService.getBreeds()
                if (response.isSuccessful) {
                    return Response.Success(response.body()?.toModel())
                } else {
                    return Response.Error(IllegalAccessException())
                }
            /*} else {
                return Response.Error(NetworkErrorException())
            }*/
        } catch (exception: IOException) {
            return Response.Error(exception)
        }
    }

    override suspend fun getBreedImage(name: String): Response<String?> {
        try {
            val response = breedService.getImage(name)
            if (response.isSuccessful) {
                return Response.Success(response.body()?.image)
            } else {
                return Response.Error(IllegalAccessException())
            }

        } catch (exception: IOException) {
            return Response.Error(exception)
        }
    }
}