package com.example.test.models

data class Filters(

    val id: String,
    val name: String,
    val type: String,
    val values: List<Values>
)