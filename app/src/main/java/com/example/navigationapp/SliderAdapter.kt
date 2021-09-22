package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter

class SliderAdapter(private var title: List<String>, private var text: List<String>, private var image: List<Int>): RecyclerView.Adapter<SliderAdapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val sliderTitle: TextView = itemView.findViewById(R.id.tv_slider_title)
        val sliderText: TextView = itemView.findViewById(R.id.tv_slider_text)
        val sliderImage: ImageView = itemView.findViewById(R.id.iv_slider_image)

        init{
            sliderImage.setOnClickListener{ v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "Pressed: ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false))
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.sliderTitle.text = title[position]
        holder.sliderText.text = text[position]
        holder.sliderImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }




}