package com.example.test.models

data class Paging(

    val total: Int,
    val offset: Int,
    val limit: Int,
    val primary_results: Int
)