package com.jarroyo.firstjetpackcompose.data.source.network

import com.jarroyo.firstjetpackcompose.domain.model.BreedApi
import com.jarroyo.firstjetpackcompose.domain.model.BreedImageApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedService {

    companion object{
        const val URL_PATH_BREEDS_LIST = "breeds/list"
        const val URL_PATH_BREED_IMAGE = "breed/{name}/images/random"
    }

    @GET(URL_PATH_BREEDS_LIST)
    suspend fun getBreeds(): Response<BreedApi?>

    @GET(URL_PATH_BREED_IMAGE)
    suspend fun getImage(@Path("name") name: String?): Response<BreedImageApi?>
}