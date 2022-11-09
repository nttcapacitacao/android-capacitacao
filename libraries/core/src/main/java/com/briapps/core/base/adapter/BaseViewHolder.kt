package com.briapps.core.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T,L>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(params: T, listener: L)
}