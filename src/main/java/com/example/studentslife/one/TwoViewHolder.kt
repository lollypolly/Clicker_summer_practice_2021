package com.example.studentslife.one

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslife.ItemActive
import com.example.studentslife.Keys
import com.example.studentslife.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

class OneViewHolder(
    override val containerView: View,
    private val clickLambda: (ItemActive, TextView) -> Unit,
    private val initLambda: (ItemActive,TextView) -> Unit
) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: ItemActive) {
        initLambda(item,tvElementCounter)
        Name_item.text = item.nameItem
        Upgrade.text = "+${item.upgrade}/клик"
        btnToast.text=item.cost.toString()
        btnToast.setOnClickListener { clickLambda(item, tvElementCounter)
            btnToast.text = item.cost.toString()
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            clickLambda: (ItemActive, TextView) -> Unit,
            initLambda: (ItemActive,TextView) -> Unit
        ) = OneViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ), clickLambda, initLambda
        )
    }
}