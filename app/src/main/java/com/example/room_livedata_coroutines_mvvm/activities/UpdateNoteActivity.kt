package com.example.room_livedata_coroutines_mvvm.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.room_livedata_coroutines_mvvm.R
import com.example.room_livedata_coroutines_mvvm.databinding.ActivityMainBinding
import com.example.room_livedata_coroutines_mvvm.databinding.ActivityUpdateNoteBinding
import com.example.room_livedata_coroutines_mvvm.model.Note
import com.example.room_livedata_coroutines_mvvm.viewmodel.NoteViewModel

class UpdateNoteActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityUpdateNoteBinding

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this,
            NoteViewModel.NoteViewModelFactory(this.application)
        )[NoteViewModel::class.java]

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val note = intent.getSerializableExtra("UPDATE_NOTE") as Note
        binding.edtUpdateTitle.setText(note.title)
        binding.edtUpdateDes.setText(note.description)

        binding.btnUpdateNote.setOnClickListener {
            note.title = binding.edtUpdateTitle.text.toString().trim()
            note.description = binding.edtUpdateDes.text.toString().trim()
            noteViewModel.updateNote(note)
            finish()
        }

    }
}