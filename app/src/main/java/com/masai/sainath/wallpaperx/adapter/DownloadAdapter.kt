package com.masai.sainath.wallpaperx.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.activity.Wallpaper

class DownloadAdapter(val requireContext: Context, val listBestofTheMoth: ArrayList<String>) : RecyclerView.Adapter<DownloadAdapter.BomViewHolder>() {


    inner class BomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview=itemView.findViewById<RoundedImageView>(R.id.cat_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BomViewHolder {
        return BomViewHolder(
        LayoutInflater.from(requireContext).inflate(R.layout.item_category,parent,false))

    }

    override fun onBindViewHolder(holder: BomViewHolder, position: Int) {
        Glide.with(requireContext).load(listBestofTheMoth[position]).into(holder.imageview)

    }

    override fun getItemCount(): Int {
       return listBestofTheMoth.size
    }

}