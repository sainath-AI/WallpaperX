 package com.masai.sainath.wallpaperx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.databinding.ActivityMainBinding
import com.masai.sainath.wallpaperx.databinding.FragmentHomeBinding


 class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)


        return binding.root
    }


}