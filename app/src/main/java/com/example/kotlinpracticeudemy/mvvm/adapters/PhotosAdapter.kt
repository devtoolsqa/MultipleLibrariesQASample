package com.example.kotlinpracticeudemy.mvvm.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinpracticeudemy.databinding.PhotosLayoutBinding
import com.example.kotlinpracticeudemy.mvvm.models.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>()  {
    private var photosList = ArrayList<Photo>()
    fun setPhotosList(movieList : List<Photo>){
        // Get the existing list of photos from the adapter
        val existingPhotos =  photosList

        // Combine the new and existing photos into a single list
        val combinedPhotos = existingPhotos + movieList

        // Update the adapter with the combined list
        this.photosList = combinedPhotos as ArrayList<Photo>

        //Notify the adapter that the data has changed
        notifyDataSetChanged()
    }
    class ViewHolder(val binding : PhotosLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PhotosLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.photoId.text = "Photo ID : "+photosList[position].id
        Glide.with(holder.itemView.context)
            .load(photosList[position].img_src)
            .into(holder.binding.photoImage)
        Log.d("url",photosList[position].img_src)
    }
}