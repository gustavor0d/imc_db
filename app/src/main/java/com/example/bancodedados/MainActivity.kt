package com.example.bancodedados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnIMC: Button
    private lateinit var btnTitulos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIMC = findViewById(R.id.btnIMC)
        btnIMC.setOnClickListener {val intent = Intent(this, CalcularIMC::class.java)
            startActivity(intent)
        }

        btnTitulos = findViewById(R.id.btnTitulos)
        btnTitulos.setOnClickListener {val intent = Intent(this, SobreTitulos::class.java)
            startActivity(intent)
        }

    }
}