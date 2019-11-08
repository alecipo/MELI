package com.example.test.models

data class Seller(

    val id: Int,
    val power_seller_status: String,
    val car_dealer: Boolean,
    val real_estate_agency: Boolean,
    val tags: List<String>
)