package com.jarroyo.firstjetpackcompose.domain

import android.util.Log
import com.jarroyo.firstjetpackcompose.data.repository.BreedRepository
import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.domain.model.Response
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

interface GetDataUseCase {

    /**
     * This function fetches the random number trivia
     * @return instance of [Result] which you should must check for all cases
     */

    fun getRandomNumberTrivia(): Int

    /**
     * This function fetches the number trivia
     * @return instance of [Result] which you should must check for all cases
     */
    suspend fun getNumberTrivia(number: String): Int

    suspend fun getBreedList(): Response<List<Breed>?>
}

class GetDataUseCaseImpl @Inject constructor(private val breedRepository: BreedRepository): GetDataUseCase {
    override fun getRandomNumberTrivia(): Int {
        return 1234
    }

    override suspend fun getNumberTrivia(number: String): Int {
        return 456
    }

    override suspend fun getBreedList(): Response<List<Breed>?> {
        return breedRepository.getBreedsList()
    }

}