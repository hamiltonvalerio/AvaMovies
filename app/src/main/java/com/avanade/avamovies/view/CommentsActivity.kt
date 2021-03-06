package com.avanade.avamovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.avanade.avamovies.R
import com.avanade.avamovies.databinding.ActivityCommentsBinding
import com.avanade.avamovies.model.Comment
import com.avanade.avamovies.viewmodel.CommentsViewModel

class CommentsActivity : AppCompatActivity() {

    private lateinit var commentsFragment: CommentsFragment
    lateinit var binding: ActivityCommentsBinding
    lateinit var commentVM: CommentsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        commentsFragment = CommentsFragment()
        setFragment(commentsFragment)

        commentVM = ViewModelProvider.NewInstanceFactory().create(CommentsViewModel::class.java)

        binding.salvarComentario.setOnClickListener {
            gravarComentario()
        }
    }

    private fun gravarComentario(){

        val comentario = Comment(
            comentario = binding.editTextComentarios.text.toString()
        )
        binding.editTextComentarios.setText("")
        commentVM.saveComment(comentario)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragment, fragment)
        fragmentTransaction.commit()

    }



}