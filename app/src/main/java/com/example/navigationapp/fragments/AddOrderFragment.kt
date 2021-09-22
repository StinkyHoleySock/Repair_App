package com.example.navigationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.AddOrderAdapter
import com.example.navigationapp.ListItem
import com.example.navigationapp.R
import com.example.navigationapp.RvAdapter
import kotlinx.android.synthetic.main.fragment_add_order.*


class AddOrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RvAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_order, container, false)

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rcView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView


            val list = ArrayList<ListItem>()

                list.add(ListItem(R.drawable.ic_test_image, "Внутренняя отделка"))
                list.add(ListItem(R.drawable.ic_test_image_2, "Межевание участков"))
                list.add(ListItem(R.drawable.ic_test_image_3, "Покраска"))
                list.add(ListItem(R.drawable.ic_test_image_4, "Отделка стен"))
                list.add(ListItem(R.drawable.ic_test_image_5, "Подбор интерьера"))

            rcView.adapter = AddOrderAdapter(list, context)
        }
    }

}

 