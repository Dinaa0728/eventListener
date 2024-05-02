package com.example.eventlistener

import android.os.Bundle
import android.widget.AbsSpinner
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.ArrayAdapter

class BMI2 : AppCompatActivity() {
    lateinit var edBerat: EditText
    lateinit var edTinggi: EditText
    lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner: Spinner = findViewById(R.id.spinnerumur)
        ArrayAdapter.createFromResource(
            this,
            R.array.umur_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        edBerat = findViewById(R.id.numberWeight)
        edTinggi = findViewById(R.id.numberHeight)
        btn = findViewById(R.id.btnCalculate)


        //set event listener
        btn.setOnClickListener {
            val umurPilih = spinner.selectedItem.toString()
            //convert ke float/double
            val isiBerat = edBerat.text.toString()
            val isiTinggi = edTinggi.text.toString()
            val result: TextView = findViewById(R.id.result)
            val hitungBMI =
                isiBerat.toFloat() / ((isiTinggi.toFloat() / 100) * (isiTinggi.toFloat() / 100))
            result.text = hitungBMI.toString()

            if (umurPilih == "Dewasa") {
                resultBMIDewasa(hitungBMI)
            } else {
                resultBMIAnak(hitungBMI)
            }

        }
    }

    private fun resultBMIDewasa(bmi: Float) {
        val result: TextView = findViewById(R.id.status)
        result.text = bmi.toString()
        when {
            bmi < 18.5 -> {
                Toast.makeText(this, "Kurus", Toast.LENGTH_LONG).show()
            }

            bmi in 18.5..24.9 -> {
                Toast.makeText(this, "Sehat", Toast.LENGTH_LONG).show()
            }

            else -> {
                Toast.makeText(this, "Gemuk", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun resultBMIAnak(bmi: Float) {
        val result: TextView = findViewById(R.id.status)
        result.text = bmi.toString()
        when {
            bmi < 18.5 -> {
                Toast.makeText(this, "Kurus", Toast.LENGTH_LONG).show()
            }

            bmi in 18.5..24.9 -> {
                Toast.makeText(this, "Sehat", Toast.LENGTH_LONG).show()
            }

            else -> {
                Toast.makeText(this, "Gemuk", Toast.LENGTH_LONG).show()
            }
        }
    }
}