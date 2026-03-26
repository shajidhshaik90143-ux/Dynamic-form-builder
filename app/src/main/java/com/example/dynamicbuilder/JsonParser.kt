package com.example.dynamicbuilder.utils

import android.content.Context
import com.example.dynamicbuilder.model.FormField
import org.json.JSONObject

object JsonParser {

    fun parseForm(context: Context): List<FormField> {

        val input = context.resources.openRawResource(
            context.resources.getIdentifier(
                "form_config",
                "raw",
                context.packageName
            )
        )

        val json = input.bufferedReader().use { it.readText() }

        val jsonObject = JSONObject(json)

        val fields = jsonObject.getJSONArray("fields")

        val list = mutableListOf<FormField>()

        for (i in 0 until fields.length()) {

            val obj = fields.getJSONObject(i)

            val type = obj.getString("type")
            val label = obj.getString("label")

            val options = if (obj.has("options")) {
                val arr = obj.getJSONArray("options")
                List(arr.length()) { arr.getString(it) }
            } else null

            list.add(FormField(type, label, options))
        }

        return list
    }
}