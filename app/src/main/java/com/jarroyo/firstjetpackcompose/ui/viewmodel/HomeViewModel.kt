package com.jarroyo.firstjetpackcompose.ui.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarroyo.firstjetpackcompose.domain.GetDataUseCase
import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.domain.model.Response
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val useCase: GetDataUseCase
) : ViewModel() {

    private var _randomNumber: MutableLiveData<Int> = MutableLiveData()
    val randomNumber: LiveData<Int> get() = _randomNumber

    private var _breedList: MutableLiveData<List<Breed>?> = MutableLiveData()
    val breedList: LiveData<List<Breed>?> get() = _breedList

    fun printSomething() {
        viewModelScope.launch {
            _randomNumber.postValue(useCase.getNumberTrivia(""))
        }
    }

    fun getBreedList() {
        viewModelScope.launch {
            val response = useCase.getBreedList()
            if (response is Response.Success) {
                _breedList.postValue(response.data)
            }
        }
    }
}