package com.example.dynamicbuilder

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicbuilder.utils.JsonParser

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20,20,20,20)

        setContentView(layout)

        val fields = JsonParser.parseForm(this)

        for (field in fields) {

            val label = TextView(this)
            label.text = field.label
            layout.addView(label)

            when(field.type){

                "text" -> {
                    val edit = EditText(this)
                    layout.addView(edit)
                }

                "dropdown" -> {
                    val spinner = Spinner(this)
                    val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        field.options ?: listOf()
                    )
                    spinner.adapter = adapter
                    layout.addView(spinner)
                }

                "checkbox" -> {
                    val check = CheckBox(this)
                    check.text = field.label
                    layout.addView(check)
                }
            }
        }
    }
}