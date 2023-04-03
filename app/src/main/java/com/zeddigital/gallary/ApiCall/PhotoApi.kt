package com.zeddigital.gallary.ApiCall

import com.zeddigital.gallary.Model.GalleryDataModel
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {
    @GET("/photos")
    suspend fun getData() : Response<List<GalleryDataModel>>
}
