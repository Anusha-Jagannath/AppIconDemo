package com.example.appicondemo

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appicondemo.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            chnageIcon()
        }

        binding.changeBtn.setOnClickListener {
            defaultIcon()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun chnageIcon() {



        val packageManager = applicationContext.packageManager

        // Disable all icons first
        packageManager.setComponentEnabledSetting(
            ComponentName(applicationContext, "com.example.appicondemo.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )

        packageManager.setComponentEnabledSetting(
            ComponentName(applicationContext, "com.example.appicondemo.MainActivityCloneAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )

    }


    private fun defaultIcon() {
        val packageManager = applicationContext.packageManager

        // Disable all icons first
        packageManager.setComponentEnabledSetting(
            ComponentName(applicationContext, "com.example.appicondemo.MainActivityCloneAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )


        packageManager.setComponentEnabledSetting(
            ComponentName(applicationContext, "com.example.appicondemo.MainActivityAlias"),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}