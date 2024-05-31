package com.example.kotlinpracticeudemy.mvvm

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinpracticeudemy.R

import com.example.kotlinpracticeudemy.databinding.ActivityMmvmactivityBinding
import com.example.kotlinpracticeudemy.mvvm.adapters.PhotosAdapter
import com.example.kotlinpracticeudemy.mvvm.viewmodel.MarsRoverPhotosListViewModel

class MMVMActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMmvmactivityBinding
    private lateinit var viewModel: MarsRoverPhotosListViewModel
    private lateinit var photosAdapter : PhotosAdapter
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMmvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        button=findViewById(R.id.button_list)
        button.setOnClickListener {

            prepareRecyclerView()
            viewModel = ViewModelProvider(this)[MarsRoverPhotosListViewModel::class.java]
            viewModel.getPhotos()
            viewModel.observePhotosLiveData().observe(this, Observer { photos ->
                photosAdapter.setPhotosList(photos.photos)
            })
        }
    }

    private fun prepareRecyclerView() {
        photosAdapter = PhotosAdapter()
        binding.rvPhotos.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = photosAdapter
        }
    }
}