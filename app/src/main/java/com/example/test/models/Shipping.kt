package com.example.test.models

data class Shipping(

    val free_shipping: Boolean,
    val mode: String,
    val tags: List<String>,
    val logistic_type: String,
    val store_pick_up: Boolean
)