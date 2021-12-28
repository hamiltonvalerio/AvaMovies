package com.avanade.avamovies.repository

import android.content.Context
import android.widget.Toast
import com.avanade.avamovies.model.User
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {
    private lateinit var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
    }

    fun save(user: User, context: Context) {
        firestore.collection("users").add(user)
            .addOnSuccessListener {
                Toast.makeText(context, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Ocorreu um erro ao gravar!", Toast.LENGTH_SHORT).show()
            }
    }
}