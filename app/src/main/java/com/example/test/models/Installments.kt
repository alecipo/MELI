package com.example.test.models

data class Installments(

    val quantity: Int,
    val amount: Double,
    val rate: Double,
    val currency_id: String
)