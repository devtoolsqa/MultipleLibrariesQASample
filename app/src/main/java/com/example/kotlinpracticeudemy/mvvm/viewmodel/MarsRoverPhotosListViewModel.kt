package com.example.kotlinpracticeudemy.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinpracticeudemy.mvvm.models.Photo
import com.example.kotlinpracticeudemy.mvvm.models.Photos
import com.example.kotlinpracticeudemy.mvvm.requests.PhotosRequest
import com.example.kotlinpracticeudemy.mvvm.requests.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MarsRoverPhotosListViewModel : ViewModel() {
    private var photosData = MutableLiveData<Photos>()

    fun getPhotos() {
        ServiceGenerator.api.getPhotos(1000,2,"RdXa2tD7aJkyIpc96tXFCysf4bZcqQtvcuQOB44h").enqueue(object  : Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                if (response.body()!=null){
                    photosData.value = response.body()
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }


        })
    }
    fun observePhotosLiveData() : LiveData<Photos> {
        return photosData
    }


}