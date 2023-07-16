package com.example.radiobotones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var addButton: RadioButton
    private lateinit var subtractButton: RadioButton
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        resultTextView = findViewById(R.id.resultTextView)
        radioGroup = findViewById(R.id.radioGroup)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val number1String = editText1.text.toString()
            val number2String = editText2.text.toString()

            if (number1String.isEmpty() || number2String.isEmpty()) {
                resultTextView.setText(R.string.please_enter_both_numbers)
                return@setOnClickListener
            }

            val number1 = number1String.toInt()
            val number2 = number2String.toInt()

            val calculationResult = when (radioGroup.checkedRadioButtonId) {
                R.id.addButton -> number1 + number2
                R.id.subtractButton -> number1 - number2
                else -> throw IllegalStateException("Invalid checkedRadioButtonId")
            }

            val resultText = getString(R.string.calres, calculationResult)
            resultTextView.text = resultText
        }
    }
}
