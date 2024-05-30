package com.example.kotlinpracticeudemy.mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinpracticeudemy.R
import com.example.kotlinpracticeudemy.databinding.ActivityMainBinding
import com.example.kotlinpracticeudemy.mvvm.adapters.PhotosAdapter
import com.example.kotlinpracticeudemy.mvvm.viewmodel.MarsRoverPhotosListViewModel

class MMVMActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MarsRoverPhotosListViewModel
    private lateinit var photosAdapter : PhotosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mmvmactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MarsRoverPhotosListViewModel::class.java]
        viewModel.getPhotos()
        viewModel.observePhotosLiveData().observe(this, Observer { photosList ->
            photosAdapter.setPhotosList(photosList)
        })
    }

    private fun prepareRecyclerView() {
        photosAdapter = PhotosAdapter()
    }
}