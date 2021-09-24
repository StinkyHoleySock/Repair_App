package com.example.navigationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.*
import kotlinx.android.synthetic.main.fragment_add_order.*
import kotlinx.android.synthetic.main.item_layout.view.*


class AddOrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RvAdapter.ViewHolder>? = null

    private lateinit var communicatorToCartFragment: CommunicatorToCartFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_order, container, false)

        communicatorToCartFragment = activity as CommunicatorToCartFragment

        // view.btn_add_order?.setOnClickListener{
        //     communicatorToCartFragment.passDataCart(view.tv_title.text.toString())
        // }

        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rcView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView


            val list = ArrayList<ListItem>()

                list.add(ListItem(R.drawable.ic_test_image_5, "Внутренняя отделка", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
                list.add(ListItem(R.drawable.ic_test_image_4, "Отделка стен", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
                list.add(ListItem(R.drawable.ic_test_image_3, "Покраска", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
                list.add(ListItem(R.drawable.ic_test_image_2, "Межевание участков", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
                list.add(ListItem(R.drawable.ic_test_image, "Подбор интерьера", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))

            rcView.adapter = AddOrderAdapter(list, context)
        }
    }

}

 