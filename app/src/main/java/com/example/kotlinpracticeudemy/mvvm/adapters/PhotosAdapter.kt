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
        this.photosList = movieList as ArrayList<Photo>
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