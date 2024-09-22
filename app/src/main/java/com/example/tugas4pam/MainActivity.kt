package com.example.tugas4pam

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var nimEditText: EditText
    private lateinit var namaEditText: EditText
    private lateinit var saveButton: Button

    private val itemList = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        nimEditText = findViewById(R.id.nim)
        namaEditText = findViewById(R.id.nama)
        saveButton = findViewById(R.id.tombolSimpan)

        adapter = ItemAdapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        saveButton.setOnClickListener {
            addItemToList()
        }
    }

    private fun addItemToList() {
        val nim = nimEditText.text.toString()
        val nama = namaEditText.text.toString()

        if (nim.isNotEmpty() && nama.isNotEmpty()) {
            val newItem = ItemModel(nim, nama)
            itemList.add(newItem)
            adapter.notifyItemInserted(itemList.size - 1)

            nimEditText.text.clear()
            namaEditText.text.clear()
        }
    }
}