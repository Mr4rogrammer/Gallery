package com.zeddigital.gallary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zeddigital.gallary.Model.GalleryDataModel
import com.zeddigital.gallary.Repository.FetchDataRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {
    val listOfImages: LiveData<List<GalleryDataModel>>
        get() = FetchDataRepo.getAllImages()

    init {
        GlobalScope.launch {
            FetchDataRepo.getDataFromApi()
        }
    }
}