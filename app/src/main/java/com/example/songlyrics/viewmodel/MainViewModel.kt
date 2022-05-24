package com.example.songlyrics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.songlyrics.model.Hits
import com.example.songlyrics.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val songList = MutableLiveData<List<Hits>>()
    private val errorMessage = MutableLiveData<String>()
    val songListShow : LiveData<List<Hits>>
    get() = songList

    fun getSong(q : String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getSong(q)
                if (response.isSuccessful) {
                    songList.postValue(response.body()?.response?.hits)
                }else {
                    errorMessage.postValue("Error")
                }
            }catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }

}