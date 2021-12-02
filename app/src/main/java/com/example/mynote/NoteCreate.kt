package com.example.mynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note.view.*
import android.text.method.ScrollingMovementMethod




class NoteCreate(
    private val notes: MutableList<Note>
) : RecyclerView.Adapter<NoteCreate.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note,
                parent,
                false
            )
        )
    }
    fun addNote(note: Note) {
        notes.add(0, note)
        notifyItemInserted(0)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curNote = notes[position]
        holder.itemView.apply {
            tvNoteName.text = curNote.name
            tvNoteComment.text = curNote.comment
            tvData.text = curNote.curData
            tvNoteComment.movementMethod = ScrollingMovementMethod()
            tvNoteName.movementMethod = ScrollingMovementMethod()
        }
    }

    override fun getItemCount(): Int {
       return notes.size
    }
}