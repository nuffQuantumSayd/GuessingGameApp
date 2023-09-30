package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val scoreView = findViewById<TextView>(R.id.scoreView)

        var leftNum = Random.nextInt(1, 10)
        var rightNum = getDistinctValue(leftNum)
        var score = 0

        buttonLeft.setText(leftNum.toString())
        buttonRight.setText(rightNum.toString())

        //set on-click listeners
        buttonLeft.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked left", Toast.LENGTH_LONG).show()
            leftNum = buttonLeft.getText().toString().toInt()
            rightNum = buttonRight.getText().toString().toInt()

            if (leftNum > rightNum) {
                score++
            }
            else {
                score--
            }
            scoreView.setText("Score $score")
            leftNum = Random.nextInt(1, 10)
            rightNum = getDistinctValue(leftNum)

            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())

        }
        buttonRight.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked right", Toast.LENGTH_LONG).show()
            leftNum = buttonLeft.getText().toString().toInt()
            rightNum = buttonRight.getText().toString().toInt()

            if (leftNum < rightNum) {
                score++
            }
            else {
                score--
            }
            scoreView.setText("Score $score")
            leftNum = Random.nextInt(1, 10)
            rightNum = getDistinctValue(leftNum)

            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())
        }
    }

    fun getDistinctValue(a: Int): Int {
        var b = Random.nextInt(1, 10)
        while (a == b) {
            b = Random.nextInt(1, 10)
        }
        return b
    }
}