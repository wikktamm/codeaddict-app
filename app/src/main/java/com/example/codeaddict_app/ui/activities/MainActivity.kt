package com.example.codeaddict_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.codeaddict_app.R
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.codeaddict_app.util.NetworkManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfig: AppBarConfiguration
    lateinit var navigationController: NavController
    private val networkManager = NetworkManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        appBarConfig = AppBarConfiguration(setOf(R.id.repositoriesListFragment))
        navigationController = findNavController(R.id.hostFragment)

        setupActionBarWithNavController(navigationController, appBarConfig)

        checkInternetConnection()
    }

    private fun checkInternetConnection() {
        networkManager.result = { isAvailable ->
            runOnUiThread {
                when (isAvailable) {
                    true -> {
                    }

                    false -> {
                        showNoConnectionError()
                    }
                }
            }
        }
    }

    private fun showNoConnectionError() {
        AlertDialog.Builder(this)
            .setTitle("No internet connection")
            .setMessage("Internet connection is necessary to use the app")
            .setNegativeButton("Understood") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

    override fun onResume() {
        super.onResume()
        networkManager.register()
    }

    override fun onStop() {
        super.onStop()
        networkManager.unregister()
    }
}