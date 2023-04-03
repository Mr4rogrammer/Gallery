package com.zeddigital.gallary.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mrprogrammer.mrshop.Utils.CommonFunctions
import com.zeddigital.gallary.R

class SplashScreen : AppCompatActivity() {
    private val splashScreenTimeOut = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()
        val runnable = Runnable {
            checkInternetAndChangeScreen()
        }
        handler.postDelayed(runnable, splashScreenTimeOut)
    }

    private fun checkInternetAndChangeScreen() {
        if (CommonFunctions.isConnected(this)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            MaterialAlertDialogBuilder(this)
                .setMessage("Please make sure internet is connected")
                .setPositiveButton("ok") { dialog, which ->
                    checkInternetAndChangeScreen()
                    dialog.dismiss()
                }.show()
        }
    }
}