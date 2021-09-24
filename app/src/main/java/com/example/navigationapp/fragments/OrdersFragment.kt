package com.example.navigationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationapp.R
import kotlinx.android.synthetic.main.fragment_orders.view.*

class OrdersFragment : Fragment() {

    var displayOrder: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_orders, container, false)

        displayOrder = arguments?.getString("order")

        view.tv_title_2.text = displayOrder

        return view
    }


}