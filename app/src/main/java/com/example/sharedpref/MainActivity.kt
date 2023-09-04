package com.example.sharedpref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import androidx.databinding.DataBindingUtil
import com.example.sharedpref.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnClick.setOnClickListener {
            settingSharedPref()
        }

        Snackbar.make(window.decorView, "${gettingSharedPref()}", Snackbar.LENGTH_SHORT).show()
    }

    private fun settingSharedPref() {
        sharedPref = getSharedPreferences("key", MODE_PRIVATE)
        sharedPref.edit().apply {
            putBoolean("login", true)
        }.apply()
    }

    private fun gettingSharedPref(): Boolean {
        return sharedPref.getBoolean("login", false)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}