package com.avanade.avamovies.model

data class Comment(
    val id: Int,
    val description: String,
    val postId: Int,
    val userId: Int
)
