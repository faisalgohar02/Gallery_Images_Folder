package com.faisalgohar.gallery.imagesfolder.adaters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.faisalgohar.gallery.imagesfolder.R
import com.faisalgohar.gallery.imagesfolder.databinding.FolderImageItemAdapterBinding
import com.faisalgohar.gallery.imagesfolder.databinding.FolderItemAdapterBinding
import com.faisalgohar.gallery.imagesfolder.interfaces.FolderClickIF
import com.faisalgohar.gallery.imagesfolder.interfaces.FolderImageClickIF
import com.faisalgohar.gallery.imagesfolder.models.FolderImages
import com.faisalgohar.gallery.imagesfolder.models.ImageViewer

class FolderImagesAdapters(private val context: Context, private val arrayList: ArrayList<ImageViewer>, private val folderImageClickIF: FolderImageClickIF) :
    RecyclerView.Adapter<FolderImagesAdapters.WeatherHolder>() {

    inner class WeatherHolder(val binding: FolderImageItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        return WeatherHolder(
            FolderImageItemAdapterBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.binding.run {

            Glide.with(context)
                .load(arrayList.get(position).picturePath)
                .apply(RequestOptions().centerCrop())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(folderImgThumb)


            folderImgThumb.setOnClickListener {
                folderImageClickIF.onFolderImageClickIF(arrayList.get(position))
            }
        }
    }
    override fun getItemCount(): Int = arrayList.size
}