package com.ivnmg.chat_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ivnmg.chat_kotlin.databinding.ActivityMainBinding
import com.ivnmg.chat_kotlin.databinding.ActivityOpcionesLoginBinding

class OpcionesLoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityOpcionesLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityOpcionesLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.opcionEmail.setOnClickListener{
            startActivity(Intent(applicationContext, LoginEmailActivity::class.java))
        }

    }
}