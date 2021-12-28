package com.avanade.avamovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.adapter.PostAdapter
import com.avanade.avamovies.databinding.ActivityFeedBinding
import com.avanade.avamovies.model.Post

class FeedActivity : AppCompatActivity() {

    lateinit var binding: ActivityFeedBinding
    private lateinit var rvPost: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        rvPost = findViewById(binding.feedRvPost.id)

        val posts = mutableListOf<Post>(
            Post(title="Titulo 1", movieName = "Homem-Aranha: Longe de Casa", id = 1, description = "", userId = 1, hasSpoiler = false),
            Post(title="Titulo 2", movieName = "Batman - O Cavaleiro das Trevas", id = 2, description = "", userId = 2,  hasSpoiler = true),
            Post(title="Titulo 3", movieName = "O Poderoso Chefão", id = 3, description = "", userId = 3, hasSpoiler = false),
            Post(title="Titulo 4", movieName = "Grey's Anatomy", id = 4, description = "", userId = 4, hasSpoiler = true)
        )

        postAdapter = PostAdapter(posts, this)
        rvPost.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvPost.adapter = postAdapter

        // Nova Postagem
        binding.feedNovaPostagem.setOnClickListener {
            val intent = Intent(this, NewPostActivity::class.java)
            startActivity(intent)
        }

        binding.feedBottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_feed_home -> {
                    true
                }
                R.id.menu_feed_editar_conta -> {
                    true
                }
                else -> false
            }
        }

    }

}