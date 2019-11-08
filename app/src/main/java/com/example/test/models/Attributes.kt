package com.example.test.models

data class Attributes(

    val value_name: String,
    val value_struct: String,
    val values: List<Values>,
    val source: Long,
    val id: String,
    val name: String,
    val value_id: Int,
    val attribute_group_id: String,
    val attribute_group_name: String
)