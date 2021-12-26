package com.avanade.avamovies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.model.Post

class PostAdapter(val postsList: List<Post>, val context: Context): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_post, parent, false)

        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        var post = postsList[position]
        holder.postTitle.text = "${post.title}"
        holder.postMovieSerieName.text = "${post.description}"

//        holder.textViewImc.setOnClickListener {
//            Toast.makeText(context, "${holder.textViewImc.text}", Toast.LENGTH_SHORT).show()
//        }

    }

    override fun getItemCount() = postsList.size

    class PostHolder(view: View): RecyclerView.ViewHolder(view) {
        var postTitle: TextView = view.findViewById<TextView>(R.id.rv_post_title)
        var postMovieSerieName: TextView = view.findViewById<TextView>(R.id.rv_post_movie_serie_name)
    }

}