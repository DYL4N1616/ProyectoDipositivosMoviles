package com.example.proyectodipositivosmoviles

import com.example.proyectodipositivosmoviles.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth


        binding.btIngresar.setOnClickListener { haceLogin() }

        binding.btRegistro.setOnClickListener { haceRegistro() }


    }
    private fun haceRegistro() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etContrasena.text.toString()

        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("creando usuario", "Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("creando usuario", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }
    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etPassword.text.toString()
        //Se hace el registro
        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Autenticando", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }
    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Menu_Principal::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart() {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }
    fun abrirTipoMoneda(view: View){
        val intent = Intent(this,Tipo_Moneda::class.java).apply {  }
        startActivity(intent)
    }

}