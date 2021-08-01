 package com.masai.sainath.wallpaperx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.wallpaperx.adapter.BomAdapter
import com.masai.sainath.wallpaperx.adapter.TctAdapter
import com.masai.sainath.wallpaperx.databinding.FragmentHomeBinding
import com.masai.sainath.wallpaperx.model.BomModel
import com.masai.sainath.wallpaperx.model.theColorTone


 class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var database:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        database=FirebaseFirestore.getInstance()

        database.collection("bestofthemonth").addSnapshotListener { value, error ->
         val  listBestofTheMoth = arrayListOf<BomModel>()

            val data=value?.toObjects(BomModel::class.java)
            listBestofTheMoth.addAll(data!!)

            binding.recyclerViewBOM.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerViewBOM.adapter=BomAdapter(requireContext(),listBestofTheMoth)
            
        }
        
        database.collection("thecolortone").addSnapshotListener { value, error ->

            val listOfColorTone= arrayListOf<theColorTone>()
            val data=value?.toObjects(theColorTone::class.java)
            listOfColorTone.addAll(data!!)
            binding.recyclerViewTct.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerViewTct.adapter= TctAdapter(requireContext(),listOfColorTone)


        }


        return binding.root
    }


}