package com.example.sampleimage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleimage.models.ImageResponseModel
import com.example.sampleimage.repo.Repository
import com.example.sampleimage.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val imageLiveData: MutableLiveData<NetworkResult<ImageResponseModel>> =
        MutableLiveData()

    val imageResponseLiveData: LiveData<NetworkResult<ImageResponseModel>> =
        imageLiveData

    fun gettingImages(limit: Int, page: Int, order: String) = viewModelScope.launch {
        imageLiveData.value = NetworkResult.Loading()
        repository.gettingImages(limit, page, order).collect {
            imageLiveData.value = it
        }
    }
}