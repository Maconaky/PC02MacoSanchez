package com.example.pc02maco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot


class ListaEquiposActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EquiposAdapter

    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_equipos)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EquiposAdapter()
        recyclerView.adapter = adapter

        // Obtener datos de Firestore y actualizar el RecyclerView
        obtenerEquiposDesdeFirestore()
    }

    private fun obtenerEquiposDesdeFirestore() {
        firestore.collection("equipos")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val nombre = document.getString("nombre")
                    val ciudad = document.getString("ciudad")

                    if (nombre != null && ciudad != null) {
                        // Agregar el equipo al adaptador
                        adapter.agregarEquipo("$nombre - $ciudad")
                    }
                }

                // Notificar al adaptador que los datos han cambiado
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                // Manejar el fallo al obtener datos de Firestore
            }
    }
}
