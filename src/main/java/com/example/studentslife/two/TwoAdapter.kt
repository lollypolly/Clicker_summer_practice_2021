package com.example.studentslife.two

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslife.ItemActive
import com.example.studentslife.ItemPassive


class TwoAdapter(
    private val dataSrc: List<ItemPassive>,
    private val clickLambda: (ItemPassive, TextView) -> Unit,
    private val initLambda :(ItemPassive, TextView)->Unit
) :
    RecyclerView.Adapter<TwoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoViewHolder =
        TwoViewHolder.create(parent, clickLambda,initLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: TwoViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}