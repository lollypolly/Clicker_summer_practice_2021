package com.example.studentslife.one

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslife.ItemActive


class OneAdapter(
    private val dataSrc: List<ItemActive>,
    private val clickLambda: (ItemActive, TextView) -> Unit,
    private val initLambda :(ItemActive,TextView)->Unit
) :
    RecyclerView.Adapter<OneViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneViewHolder =
        OneViewHolder.create(parent, clickLambda,initLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: OneViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}