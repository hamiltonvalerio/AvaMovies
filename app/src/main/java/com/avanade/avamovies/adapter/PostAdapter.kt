package com.avanade.avamovies.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.model.Post
import com.avanade.avamovies.view.CommentsActivity

class PostAdapter(val postsList: List<Post>, val context: Context): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_post, parent, false)

        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        var post = postsList[position]
        var liked = post.hasSpoiler

        holder.postTitle.text = "${post.title}"
        holder.postMovieSerieName.text = "${post.movieName}"
        holder.postBtnLike.setBackgroundColor(if(liked) Color.parseColor("#BB86FC") else 0)
        holder.postDescription.text = "${post.description}"


        holder.postBtnLike.setOnClickListener {
            liked = !liked
            holder.postBtnLike.setBackgroundColor(if(liked) Color.parseColor("#BB86FC")  else 0)
        }

        holder.postComentar.setOnClickListener {
            val intent = Intent(holder.itemView.context, CommentsActivity::class.java)
            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount() = postsList.size

    class PostHolder(view: View): RecyclerView.ViewHolder(view) {
        var postTitle: TextView = view.findViewById<TextView>(R.id.rv_post_title)
        var postMovieSerieName: TextView = view.findViewById<TextView>(R.id.rv_post_movie_serie_name)
        var postBtnLike: TextView = view.findViewById<Button>(R.id.rv_post_curtir)
        var postComentar: TextView = view.findViewById<Button>(R.id.rv_post_comentar)
        var postDescription: TextView = view.findViewById<Button>(R.id.rv_post_description)
    }

}