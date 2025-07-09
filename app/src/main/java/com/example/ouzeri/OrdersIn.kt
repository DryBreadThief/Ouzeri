package com.example.ouzeri

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OrdersIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_orders_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TIME
        //get current time
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        //set timeEditView
        val timeEditText = findViewById<EditText>(R.id.time)
        timeEditText.setText(currentTime)

        //pending variable
        val pendingQuantities = mutableMapOf<String, Int>()


        //MENU LAYOUT
        val menuLayout = findViewById<LinearLayout>(R.id.orderContainer)
        val menuItems = MenuRepository.menuItems

        for (item in menuItems) {

            //set horizontal layout
            val itemLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            //inti menu layout
//            val button = Button(this).apply {
//                text = "${item.name} - ${item.quantity}"
//                textSize = 18f
//                setOnClickListener {
//
//                }
//            }
//            menuLayout.addView(button)


            //new
            pendingQuantities[item.name] = 0
            lateinit var centerBtn: TextView

            //min button
            val minusBtn = Button(this).apply {
                text = "-"
                tag = "${item.name}_min"
                layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)

                setOnClickListener {
                    if (pendingQuantities[item.name]!! > 0) {
                        pendingQuantities[item.name] = pendingQuantities[item.name]!! - 1
                        centerBtn.text = "${item.name} - ${pendingQuantities[item.name]}"
                    }
                }
            }

            //center button
            centerBtn = TextView(this).apply {
                text = "${item.name} - ${pendingQuantities[item.name]}"
                textSize = 18f
                gravity = Gravity.CENTER
                layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 3f)
                setPadding(5, 5, 5, 5)
                setBackgroundColor(Color.parseColor("#EEEEEE"))
            }

            //plus button
            val plusBtn = Button(this).apply {
                text = "+"
                tag = "${item.name}_plus"
                layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)

                setOnClickListener {
                    pendingQuantities[item.name] = pendingQuantities[item.name]!! + 1
                    centerBtn.text = "${item.name} - ${pendingQuantities[item.name]}"
                }

            }

            itemLayout.addView(minusBtn)
            itemLayout.addView(centerBtn)
            itemLayout.addView(plusBtn)

            menuLayout.addView(itemLayout)
        }

        //apply button
        val applyAllButton = Button(this).apply {
            text = "Apply All"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 16
                gravity = Gravity.CENTER_HORIZONTAL
            }

            setOnClickListener {
                for (item in menuItems) {
                    val pending = pendingQuantities[item.name] ?: 0
                    if (pending != 0) {
                        item.quantity += pending
                        pendingQuantities[item.name] = 0
                    }
                }
                Toast.makeText(context, "All quantities applied", Toast.LENGTH_SHORT).show()

                finish()
            }
        }

        menuLayout.addView(applyAllButton)


    }
}