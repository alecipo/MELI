package com.example.test.models

data class SaleTerms(

    val id: String,
    val name: String,
    val value_id: Int,
    val value_name: String,
    val value_struct: ValueStruct,
    val values: List<Values>
)