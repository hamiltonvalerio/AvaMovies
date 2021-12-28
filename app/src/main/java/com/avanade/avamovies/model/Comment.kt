package com.avanade.avamovies.model

data class Comment(
    var uid: String = "",
    val comentario: String = "",
    var postId: String = "",
    var userId: String = ""
)
