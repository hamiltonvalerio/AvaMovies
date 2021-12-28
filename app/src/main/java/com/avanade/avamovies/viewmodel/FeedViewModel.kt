package com.avanade.avamovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.avanade.avamovies.model.Post
import com.avanade.avamovies.repository.PostRepository

class FeedViewModel: ViewModel()  {

    private var repository:PostRepository = PostRepository()

    init{
        repository = PostRepository()
    }

    fun createPost(post: Post, context: Context) {
        repository.savePost(post, context)
    }
}