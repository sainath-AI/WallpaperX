package com.masai.sainath.wallpaperx.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.wallpaperx.adapter.CategoryAdapter
import com.masai.sainath.wallpaperx.databinding.ActivityCategoryBinding
import com.masai.sainath.wallpaperx.model.BomModel

class Category : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")


        database.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->
                val listofCatWallpaper = arrayListOf<BomModel>()

                val data = value?.toObjects(BomModel::class.java)
                listofCatWallpaper.addAll(data!!)

                binding.revCat.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                binding.revCat.adapter=CategoryAdapter(this,listofCatWallpaper)
            }
    }
}