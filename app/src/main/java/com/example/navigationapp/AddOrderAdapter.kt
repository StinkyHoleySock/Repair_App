package com.example.navigationapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AddOrderAdapter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<AddOrderAdapter.ViewHolder>() {

    private var listArrayRecycler = listArray
    private var contextRecycler = context


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var image = view.findViewById<ImageView>(R.id.iv_picture)
        var title = view.findViewById<TextView>(R.id.tv_title)
        var description = view.findViewById<TextView>(R.id.tv_description)

        fun bind(listItem: ListItem, context: Context){
            image.setImageResource(listItem.imageId)
            title.text = listItem.titleText
            description.text = listItem.descriptionText
            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed ${title.text}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextRecycler)

        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayRecycler[position]
        holder.bind(listItem, contextRecycler)
    }

    override fun getItemCount(): Int {
        return listArrayRecycler.size
    }

}

