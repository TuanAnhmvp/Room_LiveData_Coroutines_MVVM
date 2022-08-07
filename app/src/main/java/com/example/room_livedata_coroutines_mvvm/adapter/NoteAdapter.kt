package com.example.room_livedata_coroutines_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_livedata_coroutines_mvvm.R
import com.example.room_livedata_coroutines_mvvm.databinding.ItemNoteBinding
import com.example.room_livedata_coroutines_mvvm.model.Note

class NoteAdapter(
    private val context: Context,
    private val onClick: (Note) -> Unit,
    private val onDelete: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    //view binding
    private lateinit var binding: ItemNoteBinding

    private var notes: List<Note> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = ItemNoteBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
      return  notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle = binding.itemTitle
        private val txtDes = binding.itemDescription
        private val btnDelete = binding.itemImageDelete
        private val layoutItem = binding.itemLayout

        fun onBind(note: Note) {
            txtDes.text = note.description
            txtTitle.text = note.title

            btnDelete.setOnClickListener { onDelete(note) }

            layoutItem.setOnClickListener { onClick(note) }
        }
    }
}