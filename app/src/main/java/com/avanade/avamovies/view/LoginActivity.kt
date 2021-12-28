package com.avanade.avamovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.avanade.avamovies.R
//import com.avanade.avamovies.databiding.ActivityLoginBiding
//import com.google.android.gms.tasks.OnCompleteListener
//import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
//import com.google.firebase.internal.api.FirebaseNoSignedInUserException
//import com.google.firebase.ktx.Firebase
//import java.lang.Exception

class LoginActivity : AppCompatActivity() {
  /*lateinit var binding: ActivityLoginBinding*/

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_login)

    val editSenha = findViewById<EditText>(R.id.login_edit_text_password)
    val editEmail = findViewById<EditText>(R.id.login_edit_text_email)
    val btnLogin = findViewById<Button>(R.id.login_button_entrar)
//    val btnGoogle = findViewById<Button>(R.id.login_button_google)
    val textRegister = findViewById<TextView>(R.id.login_text_view_criar_conta)

    btnLogin.setOnClickListener{




        FirebaseAuth.getInstance().signInWithEmailAndPassword(editEmail.text.toString(), editSenha.text.toString())
            .addOnSuccessListener {
//                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
                val feed = Intent(this, FeedActivity::class.java)
                startActivity(feed)
            }
            .addOnFailureListener {
                Log.i("Login", it.message!!)
                Toast.makeText(this, "Falha na Matrix! Sua senha pode estar errada ou o usuário não existe!", Toast.LENGTH_SHORT).show()
            }
    }



   /* binding = ActivityLoginBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    setListeners()*/
//    btnGoogle.setOnClickListener{
//        Toast.makeText(this, "GOOGLE", Toast.LENGTH_SHORT).show()
//        val feed = Intent(this, FeedActivity::class.java)
//        startActivity(feed)
//    }

    textRegister.setOnClickListener{
//        Toast.makeText(this, "SIGN UP", Toast.LENGTH_SHORT).show()
        val signup = Intent(this, SignupActivity::class.java)
        startActivity(signup)
    }
}

private fun setListeners() {
   /* binding.loginTextViewCriarConta.setOnClickListener {
        //val intent = Intent(this, signup_Activity::class.java)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    binding.loginButtonEntrar.setOnClickListener {
        autenticar()
    }*/
}

private fun autenticar() {

//    if (validar()) {
//        // Abrir o arquivo
//        val dados = getSharedPreferences("usuario", MODE_PRIVATE)
//        val editor = dados.edit()
//
//        val email = dados.getString("email", "")
//        val senha = dados.getString("senha", "")
//
//        if (binding.loginCheckBoxLembrar.isChecked) {
//            editor.putBoolean("lembrar", true)
//        } else {
//            editor.putBoolean("lembrar", false)
//        }
//
//        editor.commit()
//
//        if (email == binding.loginEditTextEmail.text.toString() && senha == binding.loginEditTextPassword.text.toString()){
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        } else {
//            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
//        }
//    }


}

private fun validar(): Boolean {

    /*if (binding.loginEditTextEmail.text.isEmpty()) {
        binding.loginEditTextEmail.error = "E-mail é obrigatório!"
        return false
    }

    if (binding.loginEditTextPassword.text.isEmpty()){
        binding.loginEditTextPassword.error = "Senha é obrigatório!"
        return false
    }*/

    return true

}
}

