package com.masai.sainath.wallpaperx.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.activity.Wallpaper
import com.masai.sainath.wallpaperx.model.theColorTone

class TctAdapter(
    private val requireContext: Context, private val listofColorTone:
    ArrayList<theColorTone>) :
    RecyclerView.Adapter<TctAdapter
    .TctViewholder>() {


    inner class TctViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val cardview=itemView.findViewById<CardView>(R.id.itemCard)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TctViewholder {
        return TctViewholder(
        LayoutInflater.from(requireContext).inflate(R.layout.item_colortone,parent,false))

    }

    override fun onBindViewHolder(holder: TctViewholder, position: Int) {

        val color=listofColorTone[position].color
         holder.cardview.setCardBackgroundColor(Color.parseColor(color!!))
        holder.itemView.setOnClickListener( View.OnClickListener {
            val intent= Intent(requireContext, Wallpaper::class.java)
            intent.putExtra("link",listofColorTone[position].link)
            requireContext.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
       return listofColorTone.size
    }

}