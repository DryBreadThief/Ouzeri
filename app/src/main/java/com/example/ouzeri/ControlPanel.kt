package com.example.ouzeri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ControlPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.control_panel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOrdersIn = findViewById<Button>(R.id.ordersin)
        btnOrdersIn.setOnClickListener {
            val intent1 = Intent(this, OrdersIn::class.java)
            startActivity(intent1)
        }

        val btnToDishesOut = findViewById<Button>(R.id.dishesout)
        btnToDishesOut.setOnClickListener {
            val intent2 = Intent(this, DishesOut::class.java)
            startActivity(intent2)
        }

        val btnToHistory = findViewById<Button>(R.id.history)
        btnToHistory.setOnClickListener {
            val intent3 = Intent(this, History::class.java)
            startActivity(intent3)
        }



    }
}