package com.example.tugas4pam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList: List<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nimTextView: TextView = itemView.findViewById(R.id.item_nim)
            val namaTextView: TextView = itemView.findViewById(R.id.item_nama)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            return ItemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val currentItem = itemList[position]
            holder.nimTextView.text = currentItem.nim
            holder.namaTextView.text = currentItem.nama
        }

        override fun getItemCount() = itemList.size
    }