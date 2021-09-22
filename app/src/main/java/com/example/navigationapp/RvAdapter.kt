package com.example.navigationapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.RvAdapter.ViewHolder
import kotlinx.android.synthetic.main.my_message.view.*

class RvAdapter(private val context: Context, private val myList: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(myItem: String){
            itemView.tvMessage.text = myItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {

        val myListItem = if(position == 0){
            LayoutInflater.from(context).inflate(R.layout.my_message, parent, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.support_message, parent, false)
        }

        return ViewHolder(myListItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.count()
    }

    override fun getItemViewType(position: Int) = position%3

}




