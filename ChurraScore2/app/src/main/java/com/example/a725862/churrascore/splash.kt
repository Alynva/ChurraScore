package com.example.a725862.churrascore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Glide.with(this)
                .load("https://media.giphy.com/media/8BDrjcJxybobe/giphy.gif")
//                .placeholder(R.mipmap.splash_bg)
                .into(splash_img);

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
