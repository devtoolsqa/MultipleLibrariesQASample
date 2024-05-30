package com.example.kotlinpracticeudemy.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinpracticeudemy.mvvm.models.Photo
import com.example.kotlinpracticeudemy.mvvm.requests.PhotosRequest
import com.example.kotlinpracticeudemy.mvvm.requests.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MarsRoverPhotosListViewModel : ViewModel() {
    private var photosData = MutableLiveData<List<Photo>>()
    val request=PhotosRequest(sol=1000,page=2,api_key="DEMO_KEY")
    fun getPhotos() {
        ServiceGenerator.api.getPhotos(request).enqueue(object  : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.body()!=null){
                    photosData.value = response.body()
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }


        })
    }
    fun observePhotosLiveData() : LiveData<List<Photo>> {
        return photosData
    }


}