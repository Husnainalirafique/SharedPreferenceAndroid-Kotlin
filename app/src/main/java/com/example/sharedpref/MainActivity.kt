package com.example.sharedpref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Display.Mode
import androidx.databinding.DataBindingUtil
import com.example.sharedpref.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tag = "MyTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnClick.setOnClickListener {
            settingSharedPref()
        }
        Log.d(tag, "${gettingSharedPref()}")
    }

    private fun settingSharedPref() {
        getSharedPreferences("key", MODE_PRIVATE).edit().apply {
            putBoolean("login", true)
        }.apply()
    }

    private fun gettingSharedPref(): Boolean {
        return getSharedPreferences("key", MODE_PRIVATE).getBoolean("login", false)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}