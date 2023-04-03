package com.mrprogrammer.mrshop.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class CommonFunctions {
    companion object {
        fun isConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val info = connectivityManager.allNetworkInfo
                if (info != null) {
                    for (networkInfo in info) {
                        if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
                    }
                }
            }
            return false
        }
    }
}