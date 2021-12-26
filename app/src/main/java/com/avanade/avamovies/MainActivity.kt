package com.avanade.avamovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avanade.avamovies.databinding.ActivityMainBinding
import com.avanade.avamovies.view.CommentsActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)


        binding.btnComments.setOnClickListener {
            val intent = Intent(this,CommentsActivity::class.java)
            startActivity(intent)
        }

    }
}