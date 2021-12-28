package com.avanade.avamovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.avanade.avamovies.model.User
import com.avanade.avamovies.repository.UserRepository

class SignupViewModel: ViewModel()  {

    private var repository:UserRepository = UserRepository()

    init{
        repository = UserRepository()
    }

    fun createUser(user: User, context: Context) {
        repository.save(user, context)
    }
}