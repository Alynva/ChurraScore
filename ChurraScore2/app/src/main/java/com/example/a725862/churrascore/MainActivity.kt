package com.example.a725862.churrascore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_goToFutebol.setOnClickListener() {
            val futebol = Intent(this, FutebolActivity::class.java)
            startActivity(futebol)
        }

        btn_goToTruco.setOnClickListener() {
            val truco = Intent(this, TrucoActivity::class.java)
            startActivity(truco)
        }
    }
}
