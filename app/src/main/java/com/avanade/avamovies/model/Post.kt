package com.avanade.avamovies.model

data class Post(
    val id: Int,
    val title: String,
    val subtitle: String,
    val description: String,
    val userId: Int
)
