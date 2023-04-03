package com.zeddigital.gallary.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeddigital.gallary.ApiCall.PhotosApi
import com.zeddigital.gallary.ApiCall.RetrofitHelper
import com.zeddigital.gallary.Model.GalleryDataModel


object FetchDataRepo {
    private var listOfGalleryImages = MutableLiveData<List<GalleryDataModel>>()

    suspend fun getDataFromApi() {
        try {
            val imagesApi = RetrofitHelper.getInstanceApiInstance().create(PhotosApi::class.java)
            val result = imagesApi.getData()
            if(result.isSuccessful){
                listOfGalleryImages.postValue(result.body())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getAllImages():LiveData<List<GalleryDataModel>>{
        return listOfGalleryImages
    }
}




