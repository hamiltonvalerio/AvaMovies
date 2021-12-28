package com.avanade.avamovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avanade.avamovies.R
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this);
    }
}