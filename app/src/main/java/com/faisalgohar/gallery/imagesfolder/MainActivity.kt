package com.faisalgohar.gallery.imagesfolder

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.faisalgohar.gallery.imagesfolder.adaters.FolderAdapters
import com.faisalgohar.gallery.imagesfolder.databinding.ActivityMainBinding
import com.faisalgohar.gallery.imagesfolder.helpers.CommonObjects.folderNameStr
import com.faisalgohar.gallery.imagesfolder.helpers.CommonObjects.folderPathStr
import com.faisalgohar.gallery.imagesfolder.helpers.ImageFolderLoader
import com.faisalgohar.gallery.imagesfolder.interfaces.FolderClickIF
import com.faisalgohar.gallery.imagesfolder.models.FolderImages

class MainActivity : AppCompatActivity(), FolderClickIF {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),100)
        }
        else{

            val imageFolderLoader=ImageFolderLoader()

            binding.folderRecyclerView.run {
                layoutManager = GridLayoutManager(this@MainActivity,3)
                setHasFixedSize(true)
                adapter = FolderAdapters(this@MainActivity, imageFolderLoader.getAllImagesFolder(this@MainActivity),this@MainActivity)
            }

        }


    }

    override fun onFolderClick(folderImages: FolderImages) {

         folderPathStr= folderImages.path
        folderNameStr=folderImages.folderName

        startActivity(Intent(this,FolderImagesActivity::class.java))


    }
}