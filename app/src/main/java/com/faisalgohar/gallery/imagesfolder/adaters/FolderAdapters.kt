package com.faisalgohar.gallery.imagesfolder.adaters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.faisalgohar.gallery.imagesfolder.R
import com.faisalgohar.gallery.imagesfolder.databinding.FolderItemAdapterBinding
import com.faisalgohar.gallery.imagesfolder.interfaces.FolderClickIF
import com.faisalgohar.gallery.imagesfolder.models.FolderImages

class FolderAdapters(private val context: Context,private val arrayList: ArrayList<FolderImages>,private val folderClickIF: FolderClickIF) :
    RecyclerView.Adapter<FolderAdapters.WeatherHolder>() {

    inner class WeatherHolder(val binding: FolderItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        return WeatherHolder(
            FolderItemAdapterBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.binding.run {

            Glide.with(context)
                .load(arrayList.get(position).thumbNail.toString())
                .apply(RequestOptions().centerCrop())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(folderThumb)

            folderNameTxt.setText(arrayList.get(position).folderName)
            folderSizeTxt.setText(arrayList.get(position).totalImages.toString())

            folderThumb.setOnClickListener {
                folderClickIF.onFolderClick(arrayList.get(position))
            }
        }
    }
    override fun getItemCount(): Int = arrayList.size
}