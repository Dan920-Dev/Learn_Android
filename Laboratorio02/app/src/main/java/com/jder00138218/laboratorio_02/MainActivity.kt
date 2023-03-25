package com.jder00138218.laboratorio_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var calculateButton : Button
    private lateinit var containerResult: LinearLayout
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var statusTextView: TextView
    private lateinit var rangeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        calculateResult()
    }

    private fun calculateResult(){
        val weight = weightEditText.text
        val  height = heightEditText.text

        if (weight.toString().isNotEmpty() or height.toString().isNotEmpty()){
            resultTextView.text = ""
            statusTextView.text = ""
            rangeTextView.text = ""
        }else{
            calculateButton.setOnClickListener {
                var weightCalc = weight.toString().toDouble()
                var heightCalc = height.toString().toDouble()
                var result = heightCalc/100
                var bmi = weightCalc/result.pow(2)

                val roundoff = (bmi* 100.0).roundToInt() / 100.0
                resultTextView.text = roundoff.toString()

                if (bmi < 18.5) {
                    statusTextView.text = "Underweight"
                    rangeTextView.text = "Normal Range is 18.5 - 24.9"
                }
                if (bmi >= 18.5 && bmi < 25) {
                    statusTextView.text = "Healthy"
                    rangeTextView.text = "Normal Range is 18.5 - 24.9"
                }
                if (bmi > 25 && bmi < 30) {
                    statusTextView.text = "Overweight"
                    rangeTextView.text = "Normal Range is 18.5 - 24.9"
                }
                if (bmi > 29.99) {
                    statusTextView.text = "Obese"
                    rangeTextView.text = "Normal Range is 18.5 - 24.9"
                }

                containerResult.visibility = View.VISIBLE

            }

        }

            }




   private fun bind(){
       calculateButton = findViewById(R.id.action_calculate_button)
       containerResult = findViewById(R.id.container_results)
       heightEditText = findViewById(R.id.heightEt)
       weightEditText = findViewById(R.id.weightEt)
       resultTextView = findViewById(R.id.bmi_result_text_view)
       statusTextView = findViewById(R.id.status_bmi_text_view)
       rangeTextView = findViewById(R.id.range_text_view)
    }

}