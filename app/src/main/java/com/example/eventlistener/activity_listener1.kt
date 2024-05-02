package com.example.eventlistener

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_listener1 : AppCompatActivity(), View.OnClickListener {
    //deklarasi variabel input/output -->komponen(TextView,EditText,Button,dsb)
    //
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listener1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //hubungkan komponen XML Layout dengan variabel di file kotlin
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        //memasang event listener pada button
        //cara 1. didalam method OnCreate
        btn1.setOnClickListener {
            Toast.makeText(this, "BTN 1 sudah di klik", Toast.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            Toast.makeText(this, "BTN 2 sudah di klik", Toast.LENGTH_LONG).show()
        }
        //btn1. setOnClickListener pilih yang ada kurungnya //button diklik
        //logic program disini>>menjalankan apa
        //Notifikasi (mirip dengan JOptionPane >>Andorid :Toast
        //cara 2. menggunakan implements class view.OnClickListener
        btn3.setOnClickListener(this)
        btn3.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        //safe operator(?) >> aksesnya menggunakan if/when
        when (v?.id) {//isi varibale v ini adalah id. onclick idnya berasal dari button
            R.id.btn3 -> {//ketika btn3 di klik maka...
                //menjalankan apa..
                Toast.makeText(this, "BTN 3 sudah diklik", Toast.LENGTH_LONG).show()
            }

            R.id.btn4 -> {
                Toast.makeText(this, "BTN 4 sudah diklik", Toast.LENGTH_LONG).show()
            }

        }
    }
}



