package com.escobar.torrehanoi

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    // Data
    private var counter = 0 // Contador de pasos


    // Views
    private lateinit var counterP: TextView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button


    // Discos

    private lateinit var bigDisk1: ImageView
    private lateinit var mediumDisk1: ImageView
    private lateinit var smallDisk1: ImageView

    private lateinit var bigDisk2: ImageView
    private lateinit var mediumDisk2: ImageView
    private lateinit var smallDisk2: ImageView

    private lateinit var bigDisk3: ImageView
    private lateinit var mediumDisk3: ImageView
    private lateinit var smallDisk3: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setupCounter()
        addListeners()
    }

    // Funciones necesarias para el contador
    private  fun counterFun(view: TextView, counter: Int){
        view.text = counter.toString()

        if (counter == 0) {
            prevButton.visibility = View.INVISIBLE
            bigDisk1.visibility = View.VISIBLE
            mediumDisk1.visibility = View.VISIBLE
            smallDisk1.visibility = View.VISIBLE
            bigDisk2.visibility = View.INVISIBLE
            bigDisk3.visibility = View.INVISIBLE
            mediumDisk2.visibility = View.INVISIBLE
            mediumDisk3.visibility = View.INVISIBLE
            smallDisk2.visibility = View.INVISIBLE
            smallDisk3.visibility = View.INVISIBLE
        }else{
            prevButton.visibility = View.VISIBLE
        }

        if (counter == 1){
            bigDisk2.setImageResource(R.drawable.small_disk)
            mediumDisk1.setImageResource(R.drawable.medium_disk)
            smallDisk1.setImageResource(R.drawable.small_disk)
            smallDisk1.visibility = View.INVISIBLE
            mediumDisk1.visibility = View.VISIBLE
            bigDisk2.visibility = View.VISIBLE
            bigDisk3.visibility = View.INVISIBLE
        }
        if (counter == 2){
            bigDisk3.setImageResource(R.drawable.medium_disk)
            bigDisk2.setImageResource(R.drawable.small_disk)
            mediumDisk1.visibility = View.INVISIBLE
            bigDisk3.visibility = View.VISIBLE
            bigDisk2.visibility = View.VISIBLE
            mediumDisk3.visibility = View.INVISIBLE
        }
        if (counter == 3){
            mediumDisk3.setImageResource(R.drawable.small_disk)
            bigDisk1.setImageResource(R.drawable.big_disk)
            bigDisk2.visibility = View.INVISIBLE
            mediumDisk3.visibility = View.VISIBLE
            bigDisk1.visibility = View.VISIBLE
        }
        if (counter == 4){
            bigDisk2.setImageResource(R.drawable.big_disk)
            mediumDisk3.setImageResource(R.drawable.small_disk)
            bigDisk2.visibility = View.VISIBLE
            bigDisk1.visibility = View.INVISIBLE
            mediumDisk3.visibility = View.VISIBLE
            mediumDisk2.visibility = View.INVISIBLE
        }
        if (counter == 5){
            mediumDisk2.setImageResource(R.drawable.small_disk)
            bigDisk3.setImageResource(R.drawable.medium_disk)
            bigDisk3.visibility = View.VISIBLE
            mediumDisk3.visibility = View.INVISIBLE
            bigDisk1.visibility = View.INVISIBLE
            mediumDisk2.visibility = View.VISIBLE
        }
        if (counter == 6){
            bigDisk1.setImageResource(R.drawable.medium_disk)
            mediumDisk1.visibility = View.INVISIBLE
            mediumDisk2.visibility = View.VISIBLE
            bigDisk3.visibility = View.INVISIBLE
            bigDisk1.visibility = View.VISIBLE
        }
        if (counter == 7){
            mediumDisk1.setImageResource(R.drawable.small_disk)
            bigDisk2.setImageResource(R.drawable.big_disk)
            mediumDisk2.visibility = View.INVISIBLE
            mediumDisk1.visibility = View.VISIBLE
            bigDisk2.visibility = View.VISIBLE
            bigDisk3.visibility = View.INVISIBLE
        }
        if (counter == 8){
            bigDisk3.setImageResource(R.drawable.big_disk)

            mediumDisk1.visibility = View.VISIBLE
            bigDisk2.visibility = View.INVISIBLE
            bigDisk3.visibility = View.VISIBLE
        }

        if (counter == 9){
            bigDisk2.setImageResource(R.drawable.small_disk)
            bigDisk1.setImageResource(R.drawable.medium_disk)
            mediumDisk1.visibility = View.INVISIBLE
            bigDisk2.visibility = View.VISIBLE
            bigDisk1.visibility =  View.VISIBLE
            mediumDisk3.visibility = View.INVISIBLE
        }
        if (counter == 10){
            mediumDisk3.setImageResource(R.drawable.medium_disk)
            bigDisk2.setImageResource(R.drawable.small_disk)

            mediumDisk3.visibility = View.VISIBLE
            bigDisk2.visibility = View.VISIBLE
            smallDisk3.visibility = View.INVISIBLE
            bigDisk1.visibility = View.INVISIBLE
        }

        if(counter >= 11){
            nextButton.visibility = View.INVISIBLE
            smallDisk3.setImageResource(R.drawable.small_disk)
            smallDisk3.visibility = View.VISIBLE
            bigDisk2.visibility = View.INVISIBLE

        }else{
            nextButton.visibility = View.VISIBLE
        }
    }

    private fun setupCounter() {
        counterFun(counterP, counter)
    }

    // Botones
    private fun addListeners() {
        prevButton.setOnClickListener {
           counter--
            counterFun(counterP, counter)
        }

        nextButton.setOnClickListener {
            counter++
            counterFun(counterP,counter)
        }
    }



    private fun bind() {
        counterP = findViewById(R.id.counter)
        nextButton = findViewById(R.id.next)
        prevButton = findViewById(R.id.prev)

        bigDisk1 = findViewById(R.id.bigDisk1)
        mediumDisk1 = findViewById(R.id.mediumDisk1)
        smallDisk1 = findViewById(R.id.smallDisk)

        bigDisk2 = findViewById(R.id.bigDisk2)
        mediumDisk2 = findViewById(R.id.mediumDisk2)
        smallDisk2 = findViewById(R.id.smallDisk2)

        bigDisk3 = findViewById(R.id.bigDisk3)
        mediumDisk3 = findViewById(R.id.mediumDisk3)
        smallDisk3 = findViewById(R.id.smallDisk3)
    }



    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }



}