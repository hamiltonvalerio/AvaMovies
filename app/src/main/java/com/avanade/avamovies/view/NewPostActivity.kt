package com.avanade.avamovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.avanade.avamovies.R
import com.avanade.avamovies.databinding.ActivityFeedBinding
import com.avanade.avamovies.databinding.ActivityNewPostBinding
import com.avanade.avamovies.model.Post
import com.avanade.avamovies.viewmodel.FeedViewModel
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class NewPostActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewPostBinding
    private lateinit var mFeedViewModel: FeedViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        binding = ActivityNewPostBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        mFeedViewModel = ViewModelProvider.NewInstanceFactory().create(FeedViewModel::class.java)

        binding.newPostPublish.setOnClickListener {
            createPost()
        }
    }

    private fun validate(): Boolean {
        return true;
    }

    private fun createPost() {
        if(validate()) {
            val post = Post(
                id = UUID.randomUUID().toString(),
                title = binding.newPostTitle.text.toString(),
                movieName = binding.newPostMovieName.text.toString(),
                description = binding.newPostMovieDescription.text.toString(),
                hasSpoiler = binding.newPostHasSpoiler.isChecked,
                userId = auth.uid.toString()
            );

            mFeedViewModel.createPost(post, this)
        }
    }
}