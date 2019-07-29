package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        text = findViewById(R.id.text)
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            //Toast.makeText( this,"button clicked", Toast.LENGTH_SHORT).show()
            var times = 0
            for (i in 0..1000) {
                val dice1: Int = rollDice(diceImage1)
                val dice2: Int = rollDice(diceImage2)
                if(dice1==dice2)times++
            }
            text.text="$times"
        }

    }

    private fun rollDice(a: ImageView): Int {
        val randomInt = Random.nextInt(6) + 1

        a.setImageResource(
            when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6

            }
        )
        return randomInt
    }


    private fun equal(dice1: Int, dice2: Int) {

        text.text = if (dice1 == dice2) "You win!!!!" else "You Loose!!!!"

    }


}

