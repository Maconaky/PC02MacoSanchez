package com.example.pc02maco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class   RegistroActivity : AppCompatActivity() {

    private lateinit var nombreEquipoEditText: EditText
    private lateinit var ciudadEditText: EditText
    private lateinit var guardarButton: Button

    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombreEquipoEditText = findViewById(R.id.nombreEquipoEditText)
        ciudadEditText = findViewById(R.id.ciudadEditText)
        guardarButton = findViewById(R.id.guardarButton)

        guardarButton.setOnClickListener {
            val nombreEquipo = nombreEquipoEditText.text.toString()
            val ciudad = ciudadEditText.text.toString()

            // Guardar en Firestore
            guardarEquipoEnFirestore(nombreEquipo, ciudad)

            // Redireccionar a la pantalla de visualización
            startActivity(Intent(this, ListaEquiposActivity::class.java))
            finish()
        }
    }

    private fun guardarEquipoEnFirestore(nombreEquipo: String, ciudad: String) {
        val equipo = hashMapOf(
            "nombre" to nombreEquipo,
            "ciudad" to ciudad
        )

        firestore.collection("equipos")
            .add(equipo)
            .addOnSuccessListener { documentReference ->
                // Éxito al guardar en Firestore
                // Puedes realizar alguna acción si lo deseas
            }
            .addOnFailureListener { e ->
                // Manejar el fallo al guardar en Firestore
            }
    }
}
