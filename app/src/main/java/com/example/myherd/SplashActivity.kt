package com.example.myherd

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import android.widget.TextView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var logo_img:ImageView
    lateinit var framebyframe: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.logo_list)
        framebyframe= AnimationUtils.loadAnimation(this, com.google.android.material.R.anim.abc_fade_in)
        framebyframe.setAnimationListener(this)
        val button1 = findViewById<TextView>(R.id.btnStartAnotherActivity)
        button1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            framebyframe.start()
            logo_img.startAnimation(framebyframe)
        }
        else{
            framebyframe.hasEnded()
        }
        
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {

        Intent(this,MainActivity::class.java).apply {
            overridePendingTransition(R.anim.sacle_in,R.anim.scale_out)
        }


    }

    override fun onAnimationRepeat(p0: Animation?) {
        TODO("Not yet implemented")
    }



}







