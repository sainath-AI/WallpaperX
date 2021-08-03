package com.masai.sainath.wallpaperx.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.masai.sainath.wallpaperx.adapter.DownloadAdapter
import com.masai.sainath.wallpaperx.databinding.FragmentDownloadBinding
import java.io.File


class DownloadFragment : Fragment() {
    lateinit var binding: FragmentDownloadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= FragmentDownloadBinding.inflate(layoutInflater,container,false)

        val allFiles:Array<File>
        val imageList= arrayListOf<String>()

        val targetpath=Environment.getExternalStorageDirectory().absolutePath+ "/Pictures/Amoled Wallpaper"
        val targetfile=File(targetpath)
        allFiles=targetfile.listFiles()!!
        for (data in allFiles){
            imageList.add(data.absolutePath)
        }

        binding.revDown.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.revDown.adapter=DownloadAdapter(requireContext(),imageList)


     return binding.root
    }


}