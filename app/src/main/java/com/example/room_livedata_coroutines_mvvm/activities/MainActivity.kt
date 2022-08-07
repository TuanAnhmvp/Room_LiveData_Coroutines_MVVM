package com.example.room_livedata_coroutines_mvvm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room_livedata_coroutines_mvvm.adapter.NoteAdapter
import com.example.room_livedata_coroutines_mvvm.databinding.ActivityMainBinding
import com.example.room_livedata_coroutines_mvvm.model.Note
import com.example.room_livedata_coroutines_mvvm.viewmodel.NoteViewModel


class MainActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityMainBinding

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this,
            NoteViewModel.NoteViewModelFactory(this.application)
        )[NoteViewModel::class.java]

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initControls()
        initEvents()
    }

    private fun initEvents() {
        binding.btnRecView.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter: NoteAdapter = NoteAdapter(this@MainActivity, onItemClick, onItemDelete)

        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = adapter

        noteViewModel.getAllNote().observe(this, Observer {
            adapter.setNotes(it)
        })

    }

    private val onItemClick: (Note) -> Unit = {
        val intent = Intent(this,UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE",it)
        startActivity(intent)

    }
    private val onItemDelete: (Note) -> Unit = {
        noteViewModel.deleteNote(it)
    }
}