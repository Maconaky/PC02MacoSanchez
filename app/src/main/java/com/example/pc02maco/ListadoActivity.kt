package com.example.pc02maco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class ListadoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listadoAdapter: ListadoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        // Obtén la lista de equipos desde Firestore (esto depende de tu implementación).

        val equipos = mutableListOf(
            Equipo("Universitario de Deportes", 27, R.drawable.escudo_universitario),
            Equipo("Alianza Lima", 25, R.drawable.escudo_alianza),
            Equipo("Sporting Cristal", 20, R.drawable.escudo_sporting)
        )

        recyclerView = findViewById(R.id.recyclerViewListado)
        listadoAdapter = ListadoAdapter(equipos)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListadoActivity)
            adapter = listadoAdapter
        }
    }
}
