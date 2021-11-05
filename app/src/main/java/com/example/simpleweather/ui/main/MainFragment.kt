package com.example.simpleweather.ui.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.fragment.app.Fragment
import com.example.simpleweather.R

class MainFragment: Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img = view.findViewById<View>(R.id.imageView)
        val springAnimation = SpringAnimation(img,DynamicAnimation.TRANSLATION_Y, 300f)

        springAnimation.setStartVelocity(100f)
        springAnimation.start()
    }
}