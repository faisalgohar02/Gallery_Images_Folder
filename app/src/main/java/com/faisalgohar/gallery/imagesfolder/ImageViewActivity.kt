package com.faisalgohar.gallery.imagesfolder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.faisalgohar.gallery.imagesfolder.databinding.ActivityImageViewBinding
import com.faisalgohar.gallery.imagesfolder.helpers.CommonObjects.imgPathStr

class ImageViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(imgPathStr)
            .apply(RequestOptions().centerCrop())
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.myZoomageView)

    }
}