package com.example.navigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navigationapp.fragments.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), CommunicatorToCartFragment {

    private val accountFragment = AccountFragment()
    private val ordersFragment = OrdersFragment()
    private val addOrderFragment = AddOrderFragment()
    private val callFragment = CallFragment()
    private val chatFragment = ChatFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(addOrderFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_account -> replaceFragment(accountFragment)
                R.id.ic_order -> replaceFragment(ordersFragment)
                R.id.ic_add_order -> replaceFragment(addOrderFragment)
                R.id.ic_call -> replaceFragment(callFragment)
                R.id.ic_chat -> replaceFragment(chatFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


    // Передача данных о заказе
    override fun passDataCart(order: String) {
        val bundle = Bundle()
        bundle.putString("order", order)

        val transaction = this.supportFragmentManager.beginTransaction()
        val cartFragment = OrdersFragment()
        cartFragment.arguments = bundle

        transaction.commit()
    }
}

