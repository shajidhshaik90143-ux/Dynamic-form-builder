package com.example.dynamicbuilder.model

data class FormField(
    val type: String,
    val label: String,
    val options: List<String>? = null
)