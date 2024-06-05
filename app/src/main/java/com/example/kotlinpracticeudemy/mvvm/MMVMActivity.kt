package com.example.kotlinpracticeudemy.mvvm

import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import com.example.kotlinpracticeudemy.R

import com.example.kotlinpracticeudemy.databinding.ActivityMmvmactivityBinding
import com.example.kotlinpracticeudemy.mvvm.adapters.PaginationScrollListener
import com.example.kotlinpracticeudemy.mvvm.adapters.PhotosAdapter
import com.example.kotlinpracticeudemy.mvvm.viewmodel.MarsRoverPhotosListViewModel

class MMVMActivity : AppCompatActivity() {
    private var context: MMVMActivity? = null
    private lateinit var binding : ActivityMmvmactivityBinding
    private lateinit var viewModel: MarsRoverPhotosListViewModel
    private lateinit var photosAdapter : PhotosAdapter
    private var page:Int=1;



    private val PAGE_START: Int = 1
    private val isLoading = false
    private val isLastPage = false

    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private val TOTAL_PAGES = 0
    private val currentPage = PAGE_START


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMmvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context=this;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[MarsRoverPhotosListViewModel::class.java]
        prepareRecyclerView()

    }

    private fun prepareRecyclerView() {
        photosAdapter = PhotosAdapter()
        binding.rvPhotos.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = photosAdapter
        }
         val scrollListener = object : PaginationScrollListener(binding.rvPhotos.layoutManager as GridLayoutManager) {
             override fun isLastPage(): Boolean {
                 return isLastPage
             }

             override fun isLoading(): Boolean {
               return isLoading
             }


             override fun loadMoreItems() {
                page++
                viewModel.getPhotos(page)
            }

             override fun getTotalPageCount(): Int {
                 return TOTAL_PAGES
             }


         }
        binding.rvPhotos.addOnScrollListener(scrollListener)
        viewModel.getPhotos(page)
        viewModel.observePhotosLiveData().observe(this) { photos ->
            photosAdapter.setPhotosList(photos.photos)
        }
    }
}