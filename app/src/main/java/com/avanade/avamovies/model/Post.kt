package com.avanade.avamovies.model

data class Post(
    val id: String,
    val title: String,
    val movieName: String,
    val description: String,
    val hasSpoiler: Boolean,
    val userId: String
)
