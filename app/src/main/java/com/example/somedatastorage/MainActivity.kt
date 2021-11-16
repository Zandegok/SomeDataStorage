package com.example.somedatastorage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var editTextAddNoteName: EditText
    private lateinit var editTextAddNoteBody: EditText
    private lateinit var editTextAddNoteDate: EditText
    private lateinit var buttonAddNote: Button
    private lateinit var recyclerView: RecyclerView
    var df = SimpleDateFormat("d-M-y")
    var noteManager = NoteManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextAddNoteName = findViewById(R.id.editTextAddNoteName)
        editTextAddNoteBody = findViewById(R.id.editTextAddNoteBody)
        editTextAddNoteDate = findViewById(R.id.editTextAddNoteDate)
        buttonAddNote = findViewById(R.id.buttonAddData)
        recyclerView = findViewById(R.id.recyclerView)

        editTextAddNoteDate.setText(df.format(Date()))
        recyclerView.layoutManager= LinearLayoutManager(applicationContext)
        buttonAddNote.setOnClickListener {
            noteManager addNote Note().apply {
                with(editTextAddNoteName) {
                    name =
                        if (text.isEmpty()) hint.toString()
                        else text.toString()
                    text.clear()
                }
                body = editTextAddNoteBody.text.toString()
                editTextAddNoteBody.text.clear()
                date = try {
                    df.parse(editTextAddNoteDate.text.toString())
                } catch (_: ParseException) {
                    Date()
                }
                Log.d("MY_TAG", toString())
            }
            recyclerView.adapter = RvAdapterNote(noteManager)
        }
    }
}