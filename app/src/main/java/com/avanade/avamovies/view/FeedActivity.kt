package com.avanade.avamovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.adapter.PostAdapter
import com.avanade.avamovies.databinding.ActivityFeedBinding
import com.avanade.avamovies.model.Post
import com.avanade.avamovies.model.User
import com.avanade.avamovies.viewmodel.FeedViewModel
import java.util.*

class FeedActivity : AppCompatActivity() {

    lateinit var binding: ActivityFeedBinding
    private lateinit var rvPost: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var mFeedViewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        rvPost = findViewById(binding.feedRvPost.id)

        mFeedViewModel = ViewModelProvider.NewInstanceFactory().create(FeedViewModel::class.java)

        val posts = mutableListOf<Post>(
            Post(title="Resenha Matrix 4", movieName = "Matrix Resurrections", id = "1", description = "Da visionária realizadora Lana Wachowski chega-nos MATRIX RESURRECTIONS o tão aguardado 4º filme do inovador franchise que redefiniu o género. O novo filme reúne os protagonistas originais Keanu Reeves e Carrie-Anne Moss nos icónicos personagens que os tornaram famosos, Neo e Trinity.", userId = "1", hasSpoiler = true),
            Post(title="Novo Carreta Furacão", movieName = "Avengers: Guerra Infinita", id = "3", description = "Da visionária realizadora Lana Wachowski chega-nos MATRIX RESURRECTIONS o tão aguardado 4º filme do inovador franchise que redefiniu o género. O novo filme reúne os protagonistas originais Keanu Reeves e Carrie-Anne Moss nos icónicos personagens que os tornaram famosos, Neo e Trinity.", userId = "1", hasSpoiler = true),
            Post(title="Eis o verdadeiro Mandarim, SQN", movieName = "Shang-Chi e a Lenda dos Dez Anéis", id = "5", description = "Um homem (Jake Gyllenhaal) está em um clube noturno assistindo um show erótico, que termina com uma mulher nua esmagando uma tarântula com seu sapato. Em outro lugar, uma mulher grávida está sentada na cama, sozinha. ", userId = "1", hasSpoiler = true),
            Post(title="Villeneuve dá um show outra vez", movieName = "Duna", id = "6", description = "Paul Atreides é um jovem brilhante, dono de um destino além de sua compreensão. Ele deve viajar para o planeta mais perigoso do universo para garantir o futuro de seu povo.", userId = "1", hasSpoiler = true),
            Post(title="Eternos, mas logo serão esquecidos", movieName = "Eternos", id = "7", description = "Os Eternos são uma raça de seres imortais que viveram durante a antiguidade da Terra, moldando sua história e suas civilizações enquanto batalhavam os malignos Deviantes.", userId = "1", hasSpoiler = true)
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