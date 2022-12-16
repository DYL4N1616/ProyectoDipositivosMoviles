package com.example.proyectodipositivosmoviles

import android.view.View
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.view.Menu
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

public class Perfil : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)
    }

    fun abrirDiaSemana(view:View){
        val intent = Intent(this,Dia_Semana::class.java).apply {  }
        startActivity(intent)
    }

    fun abrirIdioma(view:View){
        val intent = Intent(this,Cambiar_Idioma::class.java).apply {  }
        startActivity(intent)
    }

}