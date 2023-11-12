package com.example.pc02maco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class ListadoAdapter(private val equipos: List<Equipo>) :
    RecyclerView.Adapter<ListadoAdapter.ListadoViewHolder>() {

    class ListadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreEquipoTextView: TextView = itemView.findViewById(R.id.nombreEquipoTextView)
        val puntosEquipoTextView: TextView = itemView.findViewById(R.id.puntosEquipoTextView)
        val escudoEquipoTextView: TextView = itemView.findViewById(R.id.escudoEquipoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListadoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_equipo, parent, false)
        return ListadoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListadoViewHolder, position: Int) {
        val equipo = equipos[position]

        holder.nombreEquipoTextView.text = equipo.nombre
        holder.puntosEquipoTextView.text = equipo.puntos.toString()
        // Puedes establecer el escudo de acuerdo a tu implementación, por ejemplo, con una imagen.
        holder.escudoEquipoTextView.text = "(con escudo)"
    }

    override fun getItemCount(): Int {
        return equipos.size
    }
}
