package com.example.a725862.churrascore

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_truco.*

class TrucoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truco)
        var activedPts = ptsTime1
        var activedWins = wins1

        fun changeActived(newPts: TextView, newWins: TextView) {
            activedPts.setBackgroundResource(0)
            activedPts = newPts
            activedWins = newWins
            activedPts.setBackgroundColor(getResources().getColor(R.color.secondaryLightColor))
        }

        ptsTime1.setOnClickListener() {
            changeActived(ptsTime1, wins1)
        }
        ptsTime2.setOnClickListener() {
            changeActived(ptsTime2, wins2)
        }

        fun addScore(pts: Int) {
            activedPts.text = (activedPts.text.toString().toInt()+pts).toString()

            if (activedPts.text.toString().toInt() >= 12) {
                val wins = activedWins.text.toString().split(" ")[1].toString().toInt()+1
                activedWins.text = "VITORIAS: $wins"

                activedPts.text = (activedPts.text.toString().toInt()-12).toString()
            }
        }

        btnPlus1.setOnClickListener() {
            addScore(1)
        }
        btnPlus3.setOnClickListener() {
            addScore(3)
        }
        btnPlus6.setOnClickListener() {
            addScore(6)
        }
        btnPlus9.setOnClickListener() {
            addScore(9)
        }
        btnPlus12.setOnClickListener() {
            addScore(12)
        }

        btnMinus1.setOnClickListener() {
            if (activedPts.text.toString().toInt() > 0) {
                activedPts.text = (activedPts.text.toString().toInt()-1).toString()
            }
        }
    }
}
