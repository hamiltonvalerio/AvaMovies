package com.avanade.avamovies.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.avanade.avamovies.MainActivity
import com.avanade.avamovies.R
import com.avanade.avamovies.model.User
import com.avanade.avamovies.viewmodel.SignupViewModel
import java.util.*

class SignupActivity: AppCompatActivity() {

    private lateinit var username:EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var create: Button

    private lateinit var mViewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username = findViewById(R.id.et_signup_username)
        email = findViewById(R.id.et_signup_email)
        password = findViewById(R.id.et_signup_password)
        create = findViewById(R.id.bt_create_account)

        mViewModel = ViewModelProvider.NewInstanceFactory().create(SignupViewModel::class.java)

        create.setOnClickListener {
            createAccount()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validate(): Boolean {
        if(username.text.trim().isEmpty() || email.text.trim().isEmpty() || password.text.trim().isEmpty()) {
            Toast.makeText(this, "Todos os campos devem ser preenchidos.", Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }

    private fun createAccount() {
        if(validate()) {
            val user = User(
                UUID.randomUUID().toString(),
                username.text.trim().toString(),
                email.text.trim().toString(),
                password.text.trim().toString()
            );

            mViewModel.createUser(user, this)
        }
    }
}