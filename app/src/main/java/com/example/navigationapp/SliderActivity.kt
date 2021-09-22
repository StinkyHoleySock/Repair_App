package com.example.navigationapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.navigationapp.SliderAdapter
import kotlinx.android.synthetic.main.activity_slider.*
import me.relex.circleindicator.CircleIndicator3


class SliderActivity : FragmentActivity() {

    private var titleList = mutableListOf<String>()
    private var textList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    fun lastPage(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        putToList()

        view_pager.adapter = SliderAdapter(titleList, textList, imageList)
        view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager)

        btn_next.setOnClickListener{

            view_pager.apply{
                beginFakeDrag()
                fakeDragBy(-100f)
                endFakeDrag()
            }


        }

        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 4){
                    btn_next.setOnClickListener{
                        lastPage()
                    }
                }
            }
        })

    }

    private fun addToList(title: String, text: String, image: Int){
        titleList.add(title)
        textList.add(text)
        imageList.add(image)
    }

    private fun putToList(){
        addToList("First title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", R.drawable.ic_repair)
        addToList("Nice title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", R.drawable.ic_repair_2)
        addToList("Cute title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", R.drawable.ic_repair_3)
        addToList("Funny title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", R.drawable.ic_repair_4)
        addToList("Beautiful title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", R.drawable.ic_repair_5)
    }


}