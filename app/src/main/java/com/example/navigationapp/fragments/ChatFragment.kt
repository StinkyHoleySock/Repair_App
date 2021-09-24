package com.example.navigationapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.R
import com.example.navigationapp.RvAdapter
import kotlinx.android.synthetic.main.fragment_chat.*


class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RvAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_chat, container, false)

        val recyclerView = rootView.findViewById(R.id.rv_chat) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)



        return rootView
    }



    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val list = ArrayList<String>()

        val myAdapter = context?.let { RvAdapter(it, list) }

            val btnSend = view?.findViewById<ImageView>(R.id.iv_send_message)
            btnSend?.setOnClickListener{
                if (et_message.text.isNotEmpty()){

                    list.add(et_message.text.toString())
                    list.add("Здравствуйте! Вас приветствует поддержка приложения 'Repair App'! ")
                    list.add("Чем можем помочь?")
                    myAdapter?.notifyDataSetChanged()

                }
            }
        rv_chat.hasFixedSize()
        rv_chat.adapter = myAdapter
        rv_chat.layoutManager = LinearLayoutManager(context)

    }
}




