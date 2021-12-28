package com.avanade.avamovies.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.model.Comment
import com.avanade.avamovies.view.CommentsFragment

class CommentsAdapter(var context: Context): RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    private var commentsList = emptyList<Comment>()

    fun update(lista: List<Comment>){
        commentsList = lista
        notifyDataSetChanged()
    }

    class CommentsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvComentario = view.findViewById<TextView>(R.id.tv_comentario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_comments_layout, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = commentsList[position]
        holder.tvComentario.text = comment.comentario

        holder.itemView.setOnClickListener{
            val activity: AppCompatActivity = it.context as AppCompatActivity

            // Instância do fragmento que será exibido
            val commentsFragment = CommentsFragment()

            // O bundle é um "pacote" que será responsável por carregar dados no formato chave-valor
            val bundle = Bundle()
            bundle.putString("comment_comentario", comment.comentario.toString())

            // Nesta linha estamos adicionando o bundle aos argumentos do fragment
            // O bundle poderá ser recuperado no fragment de destino
            commentsFragment.arguments = bundle

            // Nesta linha estamos inserindo o fragment na activity
            activity.supportFragmentManager.beginTransaction().replace(R.id.frame_fragment, commentsFragment).addToBackStack(null).commit()
        }

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }
}