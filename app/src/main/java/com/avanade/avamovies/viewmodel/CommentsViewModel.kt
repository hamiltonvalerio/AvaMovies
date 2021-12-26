package com.avanade.avamovies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avanade.avamovies.model.Comment
import com.google.firebase.firestore.FirebaseFirestore

class CommentsViewModel: ViewModel() {

    private var _comments = MutableLiveData<ArrayList<Comment>>()
    private lateinit var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        listenComments()
    }

    private fun listenComments(){
        firestore.collection("comments")
            .addSnapshotListener { snapshot, error ->
                if(error != null){
                    return@addSnapshotListener
                }
                val listaComments = ArrayList<Comment>()
                if(snapshot != null){
                    val documents = snapshot.documents
                    documents.forEach {
                        val comment = it.toObject(Comment::class.java)
                        listaComments.add(comment!!)
                    }
                }

                _comments.value = listaComments

            }
    }

    //gets e sets
    internal var getComments: MutableLiveData<ArrayList<Comment>>
        get() {return _comments}
        set(value) {_comments.value}

}