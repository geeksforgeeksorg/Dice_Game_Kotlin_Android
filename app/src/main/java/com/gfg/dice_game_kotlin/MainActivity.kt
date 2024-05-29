package com.gfg.dice_game_kotlin
import android.graphics.drawable.Drawable

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val x:Button=findViewById(R.id.Pick_Winner)

        x.setOnClickListener(){
            val i:Int=rollDice(R.id.dice1)
            val j:Int=rollDice(R.id.dice2)

            val res:TextView=findViewById(R.id.Result)

            if(i>j){
                res.text="Result: First One is Winner"
            }
            else if (j>i){
                res.text="Result: Second One is Winner"
            }
            else{
                res.text="Match Tie!!!"
            }

        }

    }

    private fun rollDice(draw:Int):Int {
        val change_image: ImageView = findViewById(draw)

        val randomInt = Random.nextInt(6)+1
        val drawableResource = when {
            randomInt == 1 -> R.drawable.dice_1
            randomInt == 2 -> R.drawable.dice_2
            randomInt == 3 -> R.drawable.dice_3
            randomInt == 4 -> R.drawable.dice_4
            randomInt == 5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        change_image.setImageResource(drawableResource)
        return randomInt
    }
}