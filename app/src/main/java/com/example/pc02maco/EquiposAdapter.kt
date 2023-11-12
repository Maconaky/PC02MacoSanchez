package com.example.pc02maco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class EquiposAdapter : RecyclerView.Adapter<EquiposAdapter.ViewHolder>() {

    private val equiposList: MutableList<String> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val equipoTextView: TextView = view.findViewById(R.id.equipoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.equipoTextView.text = equiposList[position]
    }

    override fun getItemCount(): Int {
        return equiposList.size
    }

    fun agregarEquipo(equipo: String) {
        equiposList.add(equipo)
    }
}
