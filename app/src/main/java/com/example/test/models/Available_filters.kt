package com.example.test.models

data class Available_filters(

    val id: String,
    val name: String,
    val type: String,
    val values: List<Values>
)