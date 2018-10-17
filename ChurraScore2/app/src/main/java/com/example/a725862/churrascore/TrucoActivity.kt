package com.example.a725862.churrascore

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.TextView
import android.widget.Toast
import com.ceylonlabs.imageviewpopup.ImagePopup
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
                if (ptsTime1.text.toString().toInt() > ptsTime2.text.toString().toInt()) {
                    val name = nameTime1Truco.text
                    Toast.makeText(this, "O $name VENCEU!", Toast.LENGTH_SHORT).show()
                    val wins = wins1.text.toString().split(" ")[1].toString().toInt()+1
                    wins1.text = "VITORIAS: $wins"
                } else if (ptsTime1.text.toString().toInt() < ptsTime2.text.toString().toInt()) {
                    val name = nameTime2Truco.text
                    Toast.makeText(this, "O $name VENCEU!", Toast.LENGTH_SHORT).show()
                    val wins = wins2.text.toString().split(" ")[1].toString().toInt()+1
                    wins2.text = "VITORIAS: $wins"
                } else {
                    Toast.makeText(this, "DEU VELHA!", Toast.LENGTH_SHORT).show()
                }
                ptsTime1.text = "0"
                ptsTime2.text = "0"


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
