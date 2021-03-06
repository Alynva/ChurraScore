package com.example.a725862.churrascore

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import com.ceylonlabs.imageviewpopup.ImagePopup
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
            activedPts.setBackgroundColor(getResources().getColor(R.color.secondaryLightColor))
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
                showWinner()
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

                    handler.postDelayed(this, 1000)
                } else {
                    Toast.makeText(this@FutebolActivity, "Test", Toast.LENGTH_SHORT).show()
                    showWinner()
                }

            }
        }

        playCount.setOnClickListener() {
            handler.postDelayed(runnable, 1000)
        }
        pauseCount.setOnClickListener() {
            handler.removeCallbacks(null)
        }
    }

    private fun showWinner() {
        if (ptsFutTime1.text.toString().toInt() > ptsFutTime2.text.toString().toInt()) {
            val name = nameTime1Fut.text
            Toast.makeText(this, "O $name VENCEU!", Toast.LENGTH_SHORT).show()
            val wins = vitoriasTime1Count.text.toString().toInt()+1
            vitoriasTime1Count.text = wins.toString()
        } else if (ptsFutTime1.text.toString().toInt() < ptsFutTime2.text.toString().toInt()) {
            val name = nameTime2Fut.text
            Toast.makeText(this, "O $name VENCEU!", Toast.LENGTH_SHORT).show()
            val wins = vitoriasTime2Count.text.toString().toInt()+1
            vitoriasTime2Count.text = wins.toString()
        } else {
            Toast.makeText(this, "DEU VELHA!", Toast.LENGTH_SHORT).show()
        }
        ptsFutTime1.text = "0"
        ptsFutTime2.text = "0"


        val imagePopup = ImagePopup(this);
//        imagePopup.setWindowHeight(800); // Optional
//        imagePopup.setWindowWidth(800); // Optional
//        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
//        imagePopup.setHideCloseIcon(true);  // Optional
//        imagePopup.setImageOnClickClose(true);  // Optional
        imagePopup.initiatePopupWithGlide("https://st2.depositphotos.com/1005979/9531/i/950/depositphotos_95312146-stock-photo-and-the-winner-is-gold.jpg");
        imagePopup.viewPopup()
    }
}
