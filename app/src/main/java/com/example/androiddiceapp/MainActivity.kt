package com.example.androiddiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollbtn: ImageView = findViewById(R.id.rollbtn)
        val playerScore:TextView = findViewById(R.id.playerScore)
        val npcScore: TextView = findViewById(R.id.npcScore)
        val die1: ImageView = findViewById(R.id.die1_img)
        val die2: ImageView = findViewById(R.id.die2_img)

        playerScore.text = 0.toString()
        npcScore.text = 0.toString()
        rollbtn.setOnClickListener {
            var die1Num:Int = (0..5).random() + 1
            var die2Num:Int = (0..5).random() + 1

            val playerScoreInt:Int = playerScore.text.toString().toInt()
            val npcScoreInt:Int = npcScore.text.toString().toInt()

            when(die1Num>die2Num){
                true -> playerScore.text = (playerScoreInt + 1).toString()
                false -> npcScore.text = (npcScoreInt + 1).toString()
            }


            die1.setImageResource(resources.getIdentifier("dice$die1Num","drawable","com.example.androiddiceapp"))
            die2.setImageResource(resources.getIdentifier("dice$die2Num","drawable","com.example.androiddiceapp"))
        }


    }
}