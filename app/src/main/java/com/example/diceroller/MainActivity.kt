package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {
            countUpPressed()
        }
        diceImage = findViewById(R.id.dice_image)
        diceImage.setTag(R.drawable.empty_dice)
    }

    private fun rollDice() {
        val drawableResource = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.setTag(drawableResource)
        Toast.makeText(this, "Roll dice pressed!", Toast.LENGTH_SHORT).show()
    }

    private fun countUpPressed() {
        if(diceImage.getTag() == R.drawable.empty_dice || diceImage.getTag() == R.drawable.dice_1) {
            diceImage.setImageResource(R.drawable.dice_2)
            diceImage.setTag(R.drawable.dice_2)
        }
        else if(diceImage.getTag() == R.drawable.dice_2) {
            diceImage.setImageResource(R.drawable.dice_3)
            diceImage.setTag(R.drawable.dice_3)
        }
        else if(diceImage.getTag() == R.drawable.dice_3) {
            diceImage.setImageResource(R.drawable.dice_4)
            diceImage.setTag(R.drawable.dice_4)
        }
        else if(diceImage.getTag() == R.drawable.dice_4) {
            diceImage.setImageResource(R.drawable.dice_5)
            diceImage.setTag(R.drawable.dice_5)
        }
        else if(diceImage.getTag() == R.drawable.dice_5) {
            diceImage.setImageResource(R.drawable.dice_6)
            diceImage.setTag(R.drawable.dice_6)
        }
        Toast.makeText(this, "Count up pressed!", Toast.LENGTH_SHORT).show()
    }
}
