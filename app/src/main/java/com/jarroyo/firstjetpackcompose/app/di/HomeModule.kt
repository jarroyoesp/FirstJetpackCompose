package com.jarroyo.firstjetpackcompose.app.di

import com.jarroyo.firstjetpackcompose.data.repository.BreedRepository
import com.jarroyo.firstjetpackcompose.domain.GetDataUseCase
import com.jarroyo.firstjetpackcompose.domain.GetDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object HomeModule {

/*    @Binds
    abstract fun bindGetDataUseCase(getDataUseCaseImpl: GetDataUseCaseImpl): GetDataUseCase*/

    @Provides
    fun provideGetDataUseCase(breedRepository: BreedRepository): GetDataUseCase {
        return GetDataUseCaseImpl(breedRepository)
    }
}