package com.example.ouzeri

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //button
        val btnToControlPanel = findViewById<Button>(R.id.toControlPanel)
        btnToControlPanel.setOnClickListener {
            val intent = Intent(this, ControlPanel::class.java)
            startActivity(intent)
        }

        //display orders
        val menuLayout = findViewById<LinearLayout>(R.id.orderContainer)
        val menuItems = MenuRepository.menuItems

        //setting a divider for each dish type
        fun createDivider(): View {
            return View(this).apply {
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
                setBackgroundColor(Color.BLUE)
            }
        }

        //display Tiganita
        menuLayout.addView(TextView(this).apply {
            text = "Tiganita"
            gravity = Gravity.CENTER
        })
        menuLayout.addView(createDivider())

        for (item in menuItems) {
            if (item.type == "Tiganita") {
                val text = TextView(this).apply {
                text = "${item.name} - ${item.quantity}"
                textSize = 18f
                gravity = Gravity.CENTER
                setPadding(16, 16, 16, 16)
                }
                menuLayout.addView(text)
            }
        }

        //display Psita
        menuLayout.addView(TextView(this).apply {
            text = "Psita"
            gravity = Gravity.CENTER
        })
        menuLayout.addView(createDivider())

        for (item in menuItems) {
            if (item.type == "Psita") {
                val text = TextView(this).apply {
                    text = "${item.name} - ${item.quantity}"
                    textSize = 18f
                    gravity = Gravity.CENTER
                    setPadding(16, 16, 16, 16)
                }
                menuLayout.addView(text)
            }
        }

        //display Sxara
        menuLayout.addView(TextView(this).apply {
            text = "Sxara"
            gravity = Gravity.CENTER
        })
        menuLayout.addView(createDivider())

        for (item in menuItems) {
            if (item.type == "Sxara") {
                val text = TextView(this).apply {
                    text = "${item.name} - ${item.quantity}"
                    textSize = 18f
                    gravity = Gravity.CENTER
                    setPadding(16, 16, 16, 16)
                }
                menuLayout.addView(text)
            }
        }

        //display Piata
        menuLayout.addView(TextView(this).apply {
            text = "Piata"
            gravity = Gravity.CENTER
        })
        menuLayout.addView(createDivider())

        for (item in menuItems) {
            if (item.type == "Piata") {
                val text = TextView(this).apply {
                    text = "${item.name} - ${item.quantity}"
                    textSize = 18f
                    gravity = Gravity.CENTER
                    setPadding(16, 16, 16, 16)
                }
                menuLayout.addView(text)
            }
        }

    }
}