package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {

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
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = (1..6).random().toString()
        Toast.makeText(this, "Roll dice pressed!", Toast.LENGTH_SHORT).show()
    }

    private fun countUpPressed() {
        val resultText: TextView = findViewById(R.id.result_text)
        Toast.makeText(this, "Count up pressed!", Toast.LENGTH_SHORT).show()
        if (!checkNumeric(resultText.text.toString())) {
            resultText.text = "1"
        }
        else if(resultText.text.toString().toInt() < 6) {
            resultText.text = (resultText.text.toString().toInt() + 1).toString()
        }
    }

    private fun checkNumeric(strCheck: String): Boolean {
        var numeric = true

        try {
            val num = parseDouble(strCheck)
        } catch (e: NumberFormatException) {
            numeric = false
        }

        return numeric
    }

}
