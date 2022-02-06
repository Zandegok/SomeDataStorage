package com.example.somedatastorage

import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class RvAdapterNote(var noteManager: NoteManager) :
    RecyclerView.Adapter<RvAdapterNote.NoteViewHolder>() {

    var df = SimpleDateFormat("d-M-y")

    class NoteViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var editTextViewNoteName: EditText = itemView.findViewById(R.id.editTextNoteName)
        var editTextNoteBody: EditText = itemView.findViewById(R.id.editTextNoteBody)
        var editTextNoteDate: EditText = itemView.findViewById(R.id.editTextNoteDate)
        var buttonNoteDelete: Button = itemView.findViewById(R.id.buttonNoteDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_view, parent, false)

        return NoteViewHolder(v)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note = noteManager.getNote(position)
        with(holder) {
            editTextViewNoteName.setText(note.title)
            editTextNoteBody.setText(note.body)
            editTextNoteDate.setText(df.format(note.date))
            buttonNoteDelete.setOnClickListener {
                noteManager.deleteNote(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, noteManager.count)
            }
        }

    }

    override fun getItemCount(): Int {
        return noteManager.count
    }
}