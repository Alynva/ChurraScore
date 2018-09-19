package com.example.a725862.churrascore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_futebol.*
import kotlinx.android.synthetic.main.activity_truco.*
import kotlin.concurrent.timer

class FutebolActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futebol)

        var activedPts = ptsFutTime1
        var activedWins = vitoriasTime1Count

        fun changeActived(newPts: TextView, newWins: TextView) {
            activedPts.setBackgroundResource(0)
            activedPts = newPts
            activedWins = newWins
            activedPts.setBackgroundColor(getResources().getColor(R.color.fundoSecundary))
        }

        ptsFutTime1.setOnClickListener() {
            changeActived(ptsFutTime1, vitoriasTime1Count)
        }
        ptsFutTime2.setOnClickListener() {
            changeActived(ptsFutTime2, vitoriasTime2Count)
        }

        fun addScore(pts: Int) {
            activedPts.text = (activedPts.text.toString().toInt()+pts).toString()

            if (activedPts.text.toString().toInt() >= 15) {
                val wins = activedWins.text.toString().toInt()+1
                activedWins.text = wins.toString()

                activedPts.text = (activedPts.text.toString().toInt()-15).toString()
            }
        }

        btnFutPlus1.setOnClickListener() {
            addScore(1)
        }

        btnFutMinus1.setOnClickListener() {
            if (activedPts.text.toString().toInt() > 0) {
                activedPts.text = (activedPts.text.toString().toInt()-1).toString()
            }
        }

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (countProgress.progress > 0) {
                    val new_time = countProgress.progress.toInt() - 1
                    timeLabel.text = "$new_time segundos"
                    countProgress.progress = new_time
                }

                handler.postDelayed(this, 1000)
            }
        }

        playCount.setOnClickListener() {
            handler.postDelayed(runnable, 1000)
        }
        pauseCount.setOnClickListener() {
            handler.removeCallbacks(runnable)
        }
    }
}
