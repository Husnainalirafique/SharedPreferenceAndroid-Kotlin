package com.example.sharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.sharedpref.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tag = "MyTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setThemeSwitch()
        getThemeSwitch()
    }

    private fun setThemeSwitch() {
        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> binding.mainLayout.setBackgroundColor(resources.getColor(R.color.Blue, null))
                else -> {
                    setTheme(R.style.Theme_SharedPref)
                    recreate()
                }
            }

            getSharedPreferences("key", MODE_PRIVATE).edit().apply {
                putBoolean("theme2", isChecked)
            }.apply()
        }
    }

    private fun getThemeSwitch() {
        val id = getSharedPreferences("key", MODE_PRIVATE).getBoolean("theme2", false)
        binding.switchTheme.isChecked = id
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}