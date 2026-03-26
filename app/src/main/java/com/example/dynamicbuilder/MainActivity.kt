package com.example.dynamicbuilder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val formButton = Button(this)
        formButton.text = "Dynamic Form"

        val chartButton = Button(this)
        chartButton.text = "View Chart"

        layout.addView(formButton)
        layout.addView(chartButton)

        setContentView(layout)

        formButton.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        chartButton.setOnClickListener {
            startActivity(Intent(this, ChartActivity::class.java))
        }
    }
}