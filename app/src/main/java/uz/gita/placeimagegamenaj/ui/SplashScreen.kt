package uz.gita.placeimagegamenaj.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.placeimagegamenaj.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).window?.statusBarColor = Color.parseColor("#009688")
        (activity as AppCompatActivity).window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycleScope.launch {
            delay(1500)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen())
        }

    }

}