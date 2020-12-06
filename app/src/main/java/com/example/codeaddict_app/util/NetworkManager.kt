package com.example.codeaddict_app.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

class NetworkManager(private val context:Context) {
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    lateinit var result: (isAvailable: Boolean) -> Unit

    @Suppress("DEPRECATION")
    fun register() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (connectivityManager.activeNetwork == null) {
                result(false)
            }

            networkCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onLost(network: Network) {
                    super.onLost(network)

                    result(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    when {
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            result(true)
                        }
                        else -> {
                            result(true)
                        }
                    }
                }
            }
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val intentFilter = IntentFilter()
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            context.registerReceiver(networkChangeReceiver, intentFilter)
        }
    }

    fun unregister() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.unregisterNetworkCallback(networkCallback)
        } else {
            context.unregisterReceiver(networkChangeReceiver)
        }
    }

    @Suppress("DEPRECATION")
    private val networkChangeReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo

            if (activeNetworkInfo != null) {
                when (activeNetworkInfo.type) {
                    ConnectivityManager.TYPE_WIFI -> {
                        result(true)
                    }
                    else -> {
                        result(true)
                    }
                }
            } else {
                result(false)
            }
        }
    }
}