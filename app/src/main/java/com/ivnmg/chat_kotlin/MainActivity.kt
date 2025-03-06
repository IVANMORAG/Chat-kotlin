package com.ivnmg.chat_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.ivnmg.chat_kotlin.Fragmentos.FragmentChats
import com.ivnmg.chat_kotlin.Fragmentos.FragmentPerfil
import com.ivnmg.chat_kotlin.Fragmentos.FragmentUsuarios
import com.ivnmg.chat_kotlin.databinding.ActivityMainBinding
import com.ivnmg.chat_kotlin.databinding.FragmentChatsBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser == null){
            irOpcionesLogin()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Fragmento por defecto
        verFragmentoPerfil()

        binding.bottomNV.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.item_perfil->{
                    //Visualizar el fragmento perfil
                    verFragmentoPerfil()
                    true
                }
                R.id.item_usuarios->{
                    //Visualizar el fragmento de usuarios
                    verFragmentoUsuarios()
                    true
                }
                R.id.item_chats->{
                    //Visualizar el fragmento Chats
                    verFragmentoChats()
                    true
                }
                else ->{
                    false
                }

            }
        }

    }

    private fun irOpcionesLogin() {
        startActivity(Intent(applicationContext, OpcionesLoginActivity::class.java))
    }

    private fun verFragmentoPerfil(){
        binding.tvTitulo.text = "Perfil"

        val fragment = FragmentPerfil()
        val fragmentTrasaction = supportFragmentManager.beginTransaction()
        fragmentTrasaction.replace(binding.fragmentoFL.id, fragment, "Fragment Perfil")
        fragmentTrasaction.commit()

    }

    private fun verFragmentoUsuarios(){
        binding.tvTitulo.text = "Usuarios"

        val fragment = FragmentUsuarios()
        val fragmentTrasaction = supportFragmentManager.beginTransaction()
        fragmentTrasaction.replace(binding.fragmentoFL.id, fragment, "Fragment Usuarios")
        fragmentTrasaction.commit()

    }

    private fun verFragmentoChats(){
        binding.tvTitulo.text = "Chats"

        val fragment = FragmentChats()
        val fragmentTrasaction = supportFragmentManager.beginTransaction()
        fragmentTrasaction.replace(binding.fragmentoFL.id, fragment, "Fragment Chats")
        fragmentTrasaction.commit()

    }



















}