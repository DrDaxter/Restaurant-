package com.example.restaurant.asset

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.restaurant.Login
import com.example.restaurant.MainActivity
import com.example.restaurant.R

class Onboarding : AppCompatActivity() {
    private val key = "STATUS"
    lateinit var btnNex: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val onboarding_status: Boolean = preferences.getBoolean(key,false)
        if (onboarding_status){
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else {
            setContentView(R.layout.activity_onboarding)
            btnNex = findViewById(R.id.btn_next)
            btnNex.setOnClickListener(View.OnClickListener { View ->
                val editor = preferences.edit()
                editor.putBoolean(key, true)
                editor.apply()

                val intent: Intent = Intent(this, Login::class.java)
                startActivity(intent)
            })
        }
    }

}