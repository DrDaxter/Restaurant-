package com.example.restaurant

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var imgLogo: ImageView
    lateinit var txtSlogan: TextView
    lateinit var  txtTagLine: TextView
    private val key = "STATUS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgLogo = findViewById(R.id.logo)
        txtSlogan = findViewById(R.id.txt_slogan)
        txtTagLine = findViewById(R.id.txt_tagline)

        val topAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val bottomAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        imgLogo.startAnimation(topAnim)
        txtSlogan.startAnimation(bottomAnim)
        txtTagLine.startAnimation(bottomAnim)
        NextActivity()
    }

    fun NextActivity(){
        val login = Runnable {
            val intent:Intent = Intent(this,Login::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

        val handler = Handler()
        handler.postDelayed(login,5000)
    }

}