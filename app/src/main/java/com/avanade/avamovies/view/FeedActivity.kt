package com.avanade.avamovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.adapter.PostAdapter
import com.avanade.avamovies.model.Post

//class FeedActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_feed)
//    }
//}

class FeedActivity : AppCompatActivity() {

    private lateinit var rvPost: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        rvPost = findViewById(R.id.rv_post)

        val posts = mutableListOf<Post>(
            Post(title="Titulo 1", movieName = "Homem-Aranha: Longe de Casa", id = 1, description = "", userId = 1, hasSpoiler = false),
            Post(title="Titulo 2", movieName = "Batman - O Cavaleiro das Trevas", id = 2, description = "", userId = 2,  hasSpoiler = true),
            Post(title="Titulo 3", movieName = "O Poderoso Chefão", id = 3, description = "", userId = 3, hasSpoiler = false),
            Post(title="Titulo 4", movieName = "Grey's Anatomy", id = 4, description = "", userId = 4, hasSpoiler = true)
        )

        // Obter os dados que serão carregados na Recycler
        postAdapter = PostAdapter(posts, this)

        // Definir o layout/orientação da RecyclerView
        rvPost.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvPost.adapter = postAdapter
    }
}