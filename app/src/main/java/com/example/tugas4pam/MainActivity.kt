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

        initializeViews()
        setupRecyclerView()
        setupSaveButton()
    }

    private fun initializeViews() {
        recyclerView = findViewById(R.id.recyclerView)
        nimEditText = findViewById(R.id.nim)
        namaEditText = findViewById(R.id.nama)
        saveButton = findViewById(R.id.tombolSimpan)
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupSaveButton() {
        saveButton.setOnClickListener {
            addItemToList()
        }
    }

    private fun addItemToList() {
        val nim = nimEditText.text.toString().trim()
        val nama = namaEditText.text.toString().trim()

        if (nim.isNotEmpty() && nama.isNotEmpty()) {
            val newItem = ItemModel(nim, nama)
            itemList.add(0, newItem) // Menambahkan item baru ke posisi 0 (paling atas)
            adapter.notifyItemInserted(0) // Memberitahu adapter bahwa item baru ditambahkan di posisi 0
            recyclerView.scrollToPosition(0) // Menggulir RecyclerView ke posisi paling atas
            clearInputFields()
        }
    }

    private fun clearInputFields() {
        nimEditText.text.clear()
        namaEditText.text.clear()
    }
}