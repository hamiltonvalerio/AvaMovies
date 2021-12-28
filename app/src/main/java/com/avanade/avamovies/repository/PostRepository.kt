package com.avanade.avamovies.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.avanade.avamovies.model.Post
import com.google.firebase.firestore.FirebaseFirestore

class PostRepository {
    var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
    }

    fun savePost(post: Post, context: Context) {
        firestore.collection("posts").add(post)
            .addOnSuccessListener {
                Toast.makeText(context, "Postategem publicada!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Ocorreu um erro ao gravar!", Toast.LENGTH_SHORT).show()
            }
    }
}