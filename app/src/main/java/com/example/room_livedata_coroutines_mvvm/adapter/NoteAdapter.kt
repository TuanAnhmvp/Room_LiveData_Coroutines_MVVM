package com.example.room_livedata_coroutines_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.room_livedata_coroutines_mvvm.R
import com.example.room_livedata_coroutines_mvvm.nodel.Note

class NoteAdapter(
    private val context: Context,
    private val onClick:(Note)->Unit,
    private val onDelete:(Note)->Unit
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes:List<Note> = listOf()


    // inner co the chuy suoat vao thuuoc tinh cua lop cha
    inner class NoteViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        private val txtTitle:TextView = itemview.findViewById(R.id.item_title)
        private val txtDes:TextView = itemview.findViewById(R.id.item_description)
        private val btnDelete:ImageView = itemview.findViewById(R.id.item_image_delete)
        private val layoutItem:ConstraintLayout = itemview.findViewById(R.id.item_layout)

        fun onBind(note: Note){
            txtTitle.text = note.description
            txtTitle.text = note.title
            btnDelete.setOnClickListener {onDelete(note) }
            layoutItem.setOnClickListener {onClick(note) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    fun setNote(notes:List<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

}