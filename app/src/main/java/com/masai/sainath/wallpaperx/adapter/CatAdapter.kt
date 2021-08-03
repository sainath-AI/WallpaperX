package com.masai.sainath.wallpaperx.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.activity.Wallpaper
import com.masai.sainath.wallpaperx.model.CatModel

class CatAdapter(val requireContext: Context, val listOfCategories: ArrayList<CatModel>) : RecyclerView.Adapter<CatAdapter.CatViewholder>() {


    inner class CatViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name=itemView.findViewById<TextView>(R.id.catName)
        val imageview=itemView.findViewById<ImageView>(R.id.catiImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewholder {
        return CatViewholder(
        LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false))

    }

    override fun onBindViewHolder(holder: CatViewholder, position: Int) {
        holder.name.text=listOfCategories[position].name
        Glide.with(requireContext).load(listOfCategories[position].link).into(holder.imageview)
        holder.itemView.setOnClickListener( View.OnClickListener {
            val intent= Intent(requireContext, Wallpaper::class.java)
            intent.putExtra("link",listOfCategories[position].link)
            requireContext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
       return listOfCategories.size
    }

}