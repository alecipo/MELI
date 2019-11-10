package com.example.test.models

data class AvailableFilters(

    val id: String,
    val name: String,
    val type: String,
    val values: List<Values>
)