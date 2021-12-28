package com.avanade.avamovies.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avanade.avamovies.R
import com.avanade.avamovies.adapter.CommentsAdapter
import com.avanade.avamovies.model.Comment
import com.avanade.avamovies.viewmodel.CommentsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommentsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentsFragment : Fragment() {

    lateinit var commentVM: CommentsViewModel
    lateinit var adapter: CommentsAdapter
    lateinit var rvComments: RecyclerView

    private var comments = mutableListOf<Comment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commentVM = ViewModelProvider.NewInstanceFactory().create(CommentsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_comments, container, false)

        rvComments = view.findViewById(R.id.rv_comments)
        rvComments.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        adapter = CommentsAdapter(requireActivity().applicationContext)
        rvComments.adapter = adapter

        listarComentarios()


        return view
    }


    private fun listarComentarios(){


        commentVM.getComments.observe(viewLifecycleOwner, Observer<ArrayList<Comment>> {
            adapter.update(it)
        })

    }

}