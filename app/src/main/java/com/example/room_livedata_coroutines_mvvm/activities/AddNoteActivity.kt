package com.example.room_livedata_coroutines_mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.room_livedata_coroutines_mvvm.R
import com.example.room_livedata_coroutines_mvvm.databinding.ActivityAddNoteBinding
import com.example.room_livedata_coroutines_mvvm.databinding.ActivityMainBinding
import com.example.room_livedata_coroutines_mvvm.model.Note
import com.example.room_livedata_coroutines_mvvm.viewmodel.NoteViewModel

class AddNoteActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityAddNoteBinding

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this,
            NoteViewModel.NoteViewModelFactory(this.application)
        )[NoteViewModel::class.java]

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddNote.setOnClickListener {
            val note = Note(binding.edtAddTitle.text.toString().trim(), binding.edtAddDes.text.toString().trim())
            noteViewModel.insertNote(note)
            finish()
        }
    }
}