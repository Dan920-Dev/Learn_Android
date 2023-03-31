package com.jder00138218.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var countMoney: TextView
    private lateinit var fiveCent: ImageView
    private lateinit var tenCent: ImageView
    private lateinit var quarterDollar: ImageView
    private lateinit var oneDollar: ImageView

    private var money =  0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        calculate()

    }

    private fun bind(){
        countMoney = findViewById(R.id.cont_mony_textView)

        fiveCent = findViewById(R.id.fiveCent_ImageView)
        tenCent = findViewById(R.id.tenCent_imageView)
        quarterDollar = findViewById(R.id.quarterDollar)
        oneDollar = findViewById(R.id.oneDollar_imageView)
    }

    private fun calculate(){
        fiveCent.setOnClickListener(){
            money += 0.05
            val roundoff = (money* 100.0).roundToInt() / 100.0
            countMoney.text = roundoff.toString()
        }

        tenCent.setOnClickListener(){
            money += 0.10
            val roundoff = (money* 100.0).roundToInt() / 100.0
            countMoney.text = roundoff.toString()
        }

        quarterDollar.setOnClickListener(){
            money += 0.25
            val roundoff = (money* 100.0).roundToInt() / 100.0
            countMoney.text = roundoff.toString()
        }

        oneDollar.setOnClickListener(){
            money += 1
            val roundoff = (money* 100.0).roundToInt() / 100.0
            countMoney.text = roundoff.toString()
        }
    }


}