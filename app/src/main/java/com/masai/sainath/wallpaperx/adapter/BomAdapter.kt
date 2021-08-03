package com.masai.sainath.wallpaperx.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.activity.Wallpaper
import com.masai.sainath.wallpaperx.model.BomModel

class BomAdapter( val requireContext: Context, val listBestofTheMoth: ArrayList<BomModel>) : RecyclerView.Adapter<BomAdapter.BomViewHolder>() {


    inner class BomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageview=itemView.findViewById<ImageView>(R.id.bomImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BomViewHolder {
        return BomViewHolder(
        LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false))

    }

    override fun onBindViewHolder(holder: BomViewHolder, position: Int) {
        Glide.with(requireContext).load(listBestofTheMoth[position].link).into(holder.imageview)
        holder.itemView.setOnClickListener( View.OnClickListener {
            val intent=Intent(requireContext,Wallpaper::class.java)
            intent.putExtra("link",listBestofTheMoth[position].link)
            requireContext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
       return listBestofTheMoth.size
    }

}