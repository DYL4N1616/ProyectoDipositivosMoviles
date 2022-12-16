package com.example.proyectodipositivosmoviles

import android.view.View
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.view.Menu
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

public class Configuracion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.configuracion)
    }

    fun abrirPerfil(view:View){
        val intent = Intent(this,Perfil::class.java).apply {  }
        startActivity(intent)
    }

    fun abrirNotificaciones(view:View){
        val intent = Intent(this,Notificaciones::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirAyuda(view:View){
        val intent = Intent(this,Ayuda::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirCuentaBancaria(view:View){
        val intent = Intent(this,Cuenta_Bancaria::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirTipoMoneda(view:View){
        val intent = Intent(this,Tipo_Moneda::class.java).apply {  }
        startActivity(intent)
    }
    fun haceLogoff() {
        Firebase.auth.signOut()
        finish()
    }
}