package com.avanade.avamovies.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.avanade.avamovies.R
import com.avanade.avamovies.databinding.ActivityCommentsBinding
import com.avanade.avamovies.model.Comment
import com.avanade.avamovies.viewmodel.CommentsViewModel
import com.google.firebase.FirebaseApp

class CommentsActivity : AppCompatActivity() {

    lateinit var binding: ActivityCommentsBinding
    lateinit var commentVM: CommentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        commentVM = ViewModelProvider.NewInstanceFactory().create(CommentsViewModel::class.java)

        binding.salvarComentario.setOnClickListener{
            gravarComentario()
        }
    }

    private fun gravarComentario(){

        val comentario = Comment(
            comentario = binding.editTextComentarios.text.toString()
        )

        commentVM.saveComment(comentario)
    }
}