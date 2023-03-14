package com.faisalgohar.gallery.imagesfolder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.faisalgohar.gallery.imagesfolder.adaters.FolderAdapters
import com.faisalgohar.gallery.imagesfolder.adaters.FolderImagesAdapters
import com.faisalgohar.gallery.imagesfolder.databinding.ActivityFolderImagesBinding
import com.faisalgohar.gallery.imagesfolder.helpers.CommonObjects
import com.faisalgohar.gallery.imagesfolder.helpers.CommonObjects.imgPathStr
import com.faisalgohar.gallery.imagesfolder.helpers.ImageFolderLoader
import com.faisalgohar.gallery.imagesfolder.interfaces.FolderImageClickIF
import com.faisalgohar.gallery.imagesfolder.models.FolderImages
import com.faisalgohar.gallery.imagesfolder.models.ImageViewer

class FolderImagesActivity : AppCompatActivity(), FolderImageClickIF {

    private lateinit var binding: ActivityFolderImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFolderImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageFolderLoader= ImageFolderLoader()

        binding.folderImagesRecyclerView.run {
            layoutManager = GridLayoutManager(this@FolderImagesActivity,3)
            setHasFixedSize(true)
            adapter = FolderImagesAdapters(this@FolderImagesActivity, imageFolderLoader.getAllImagesByFolder(this@FolderImagesActivity,
                CommonObjects.folderPathStr
            ),this@FolderImagesActivity)
        }
    }

    override fun onFolderImageClickIF(imageViewer: ImageViewer) {
        imgPathStr= imageViewer.picturePath.toString()
        startActivity(Intent(this,ImageViewActivity::class.java))
    }
}